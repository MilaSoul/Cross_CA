/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author adminBeka
 */
public class Table_Interaction {


    public Connection connectToTheServer(){
        
        Connection conn = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            // Get a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ca_crossover", "root", "root");
            
        
        }catch (SQLException var8) {
            SQLException se = var8;
            System.out.println("SQL Exception:");

            while(se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        } catch (Exception var9) {
            System.out.println(var9);
        }
        System.out.println("Connected!");
        return conn;
      
        
    }
    
    public String selectFromTable_Password(String user_name){
        String pass;
        try{
      
            Connection conn = connectToTheServer();
            // create our mysql database connection
     
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT `user_password`"
                    + "FROM `users`" 
                    + "WHERE user_name=" + "'" + user_name + "';";

            // create the java statement
            Statement st = conn.createStatement();
      
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
      
            // iterate through the java resultset
            while (rs.next()){
                String user_password = rs.getString("user_password");
               
        // print the results
        pass = user_password;
        System.out.format("%s\n", user_password);
        return pass;
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    
    }
        return null;
}
    
    public int selectFromTable_ID(String user_name){
        int ID;
        try{
      
            Connection conn = connectToTheServer();
            // create our mysql database connection
     
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT `iduser`"
                    + "FROM `users`" 
                    + "WHERE user_name=" + "'" + user_name + "';";

            // create the java statement
            Statement st = conn.createStatement();
      
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
      
            // iterate through the java resultset
            while (rs.next()){
                int iduser = rs.getInt("iduser");
               
        // print the results
        ID = iduser;
        System.out.format("%s\n", iduser);
        return ID;
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    
    }
        return-1;
}
    
    
    public void selectFromTable(){
        try{
      
            Connection conn = connectToTheServer();
            // create our mysql database connection
     
            // our SQL SELECT query. 
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";

            // create the java statement
            Statement st = conn.createStatement();
      
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
      
            // iterate through the java resultset
            while (rs.next()){
                int iduser = rs.getInt("iduser");
                String user_name = rs.getString("user_name");
                String user_password = rs.getString("user_password");
                String user_role = rs.getString("user_role");
        
        // print the results
        System.out.format("%s, %s, %s, %s\n", iduser, user_name, user_password, user_role);
      }
      st.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    
    }
}
    
    public void tableUpdate(String user_name, int iduser){
    try
    {
        Connection conn = connectToTheServer();
      // create a java mysql database connection
      
     // create the java mysql update preparedstatement
      String query = "update users set user_name = ? where iduser = ?";
      //"update users set num_points = 6000 where id = 2;";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString(1, user_name);
      preparedStmt.setInt(2, iduser);

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
  }
    
    public void showTheFullTable(){
        try {
            Connection conn = connectToTheServer();
            Statement stmt = conn.createStatement() ;
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
             
            while(rs.next()){
              //  System.out.println(rs.getString("firstname")); 
                PrintStream var10000 = System.out;
                String var10001 = rs.getString("iduser");
                var10000.println(var10001 + "\t" + rs.getString("user_name") + "\t" + rs.getString("user_password") + "\t" + rs.getString("user_role"));
           } 
            
            // closening writing to the file 
                rs.close();
                stmt.close();
                conn.close();
            
            } catch (SQLException var8) {
            SQLException se = var8;
            System.out.println("SQL Exception:");

            while(se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        } catch (Exception var9) {
            System.out.println(var9);
        }
    }
    public ArrayList<String> getFromTable(String query, String attribute, String attribute2) throws Exception{
        try{
            
            ArrayList<String> array = new ArrayList<>();
            
            Connection conn = connectToTheServer();
            Statement stmt = conn.createStatement() ;
            
            ResultSet rs = stmt.executeQuery(query);
            
       
      
            while(rs.next()){
              //  System.out.println(rs.getString("firstname")); 
                PrintStream var10000 = System.out;
                String var10001 = rs.getString("iduser");
                var10000.println(var10001 + "\t" + rs.getString(attribute) + "\t" + rs.getString(attribute2));
                array.add(rs.getString(attribute));
                array.add(rs.getString(attribute2));
           } 
                conn.close();
                stmt.close();
                rs.close();
                
                return array;
            // closening writing to the file 

            } catch (SQLException var8) {
            SQLException se = var8;
            System.out.println("SQL Exception:");

            while(se != null) {
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
    
    
    public void postTo_Table(String insertQuery){
      try{
            Connection conn = connectToTheServer();
            Statement posted = conn.createStatement() ;
            
            posted.executeUpdate(insertQuery);
            
            conn.close();
            System.out.println("Insert Complited!");
      }catch(Exception e){
          System.err.println("e");
          System.err.println(e.getMessage());
      }
      }
    

    
}
