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

    public String selectFromTable(String select, String from, String where, String condition) throws SQLException {

        String selectedValue = null;
        try {
            Connection conn = ca.connectToTheServer();
            // create a java mysql database connection

            String selectQuery = "SELECT " + select + " \n"
                    + "FROM " + from + " \n"
                    + "WHERE " + where + " = ?";
            PreparedStatement statement = conn.prepareStatement(selectQuery);
            statement.setString(1, condition);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                selectedValue = result.getString(where);
            }

            conn.close();
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

            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            int numberOfColumn = rsmd.getColumnCount();
            //       System.out.println(numberOfColumn);

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
            System.out.println(array);
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

    public void postTo_Table(String insertQuery) {

        try {
            Connection conn = ca.connectToTheServer();
            Statement posted = conn.createStatement();

            posted.executeUpdate(insertQuery);

            conn.close();
            System.out.println("Insert Complited!");
        } catch (Exception e) {
            System.err.println("e");
            System.err.println(e.getMessage());
        }
    }

    public String selectUser_ID(String username) throws SQLException {
        String select = "user_id";
        String from = "users";
        String where = "username";
        String value = "user_id";
        try {
            String user_id = selectFromTable(select, from, where, username);
            return user_id;
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
