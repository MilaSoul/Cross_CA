/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_interaction;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author adminBeka
 */
public class Table_Interaction {

    private Server_Connection ca;

    public Table_Interaction() {
        this(new Server_Connection());
    }

    public Table_Interaction(Server_Connection ca) {
        this.ca = ca;
    }

     public String selectFromTable(String selectQuery, String value){
        
        String selectedValue = null;
        try {
            Connection con = ca.connectToTheServer();

            PreparedStatement stm = con.prepareStatement(selectQuery);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                selectedValue = (result.getString(value));

                //System.out.println(user_id);
            }
            con.close();
            return selectedValue;
        } catch (SQLException var8) {
            SQLException se = var8;
            System.out.println("SQL Exception:");

            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        } catch (Exception var9) {
            System.out.println(var9);
        }
        return null;
    }

    public void tableUpdate(String updateQuery, String newValue, String where) {

        try {
            Connection conn = ca.connectToTheServer();
            // create a java mysql database connection

            // create the java mysql update preparedstatement
            String query = updateQuery;

            /*"UPDATE `ca_cross`.`"+ tableName + "`" 
        +"SET `" + value + "` = ?"
        +"WHERE `user_id` = ?";*/
            //"update users set num_points = 6000 where id = 2;";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, newValue);
            preparedStmt.setString(2, where);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<String> getFromTable(String selectQuery) {

        try {
            String query = selectQuery;

            ArrayList<String> array = new ArrayList<>();

            Connection conn = ca.connectToTheServer();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData(); // getting the number of columns in the table 
            int numberOfColumn = rsmd.getColumnCount();
            // System.out.println(numberOfColumn);

            while (rs.next()) { //will run the loop until as long as there is a result coming 

                for (int column = 1; column <= numberOfColumn; column++) { //will add the values from columns one by one 
                    if (rs.wasNull()) {
                        array.add((String) rs.getObject(column));
                        //   array.add("null");
                    } else {
                        array.add(rs.getString(column));
                    }
                }

            }
            conn.close();
            stmt.close();
            rs.close();
            return array;
            // closening writing to the file 

        } catch (SQLException var8) {
            SQLException se = var8;
            System.out.println("SQL Exception:");

            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        } catch (Exception var9) {
            System.out.println(var9);
        }
        return null;
    }

    public void insertTo_Table(String tableName, String whatToInsert, String value1, String value2, String value3, String value4) {
        try {
            Connection con = ca.connectToTheServer();

            PreparedStatement stm = con.prepareStatement("INSERT INTO " + tableName + " (" + whatToInsert + ")" + " VALUES (?, ?, ?, ?);");
            stm.setString(1, value1);
            stm.setString(2, value2);
            stm.setString(3, value3);
            stm.setString(4, value4);

            stm.executeUpdate();
            System.out.println("Insert Complited!");

            stm.close();
            con.close();

        } catch (SQLException e) {
            System.err.println("e");
            System.err.println(e.getMessage());
        }
    }

    public void insertTo_Table(String tableName, String whatToInsert, String value1, String value2) {
        try {
            Connection con = ca.connectToTheServer();

            PreparedStatement stm = con.prepareStatement("INSERT INTO " + tableName + " (" + whatToInsert + ")" + " VALUES (?, ?);");
            stm.setString(1, value1);
            stm.setString(2, value2);

            stm.executeUpdate();
            System.out.println("Insert Complited!");

            stm.close();
            con.close();

        } catch (SQLException e) {
            System.err.println("e");
            System.err.println(e.getMessage());
        }
    }

    public int selectUser_ID(String username) {

        int user_id = 0;
        try {
            Connection con = ca.connectToTheServer();

            PreparedStatement stm_3 = con.prepareStatement("SELECT user_id FROM users WHERE username = '" + username + "'");
            ResultSet result = stm_3.executeQuery();

            while (result.next()) {
                user_id = (result.getInt("user_id"));

                //System.out.println(user_id);
            }
            return user_id;
        } catch (Exception e) {
        }
        return -1;
    }

    
    public void deleteFromTable(String query) {
        Connection conn = ca.connectToTheServer();
        Statement stmt = null;
        try {

            conn = ca.connectToTheServer();
            stmt = (Statement) conn.createStatement();
            String query1 = query;
            stmt.executeUpdate(query1);
            System.out.println("Record is deleted from the table successfully..................");
        } catch (SQLException excep) {
            excep.printStackTrace();
        } catch (Exception excep) {
            excep.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Please check it in the MySQL Table. Record is now deleted.......");
    }
}
