/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_interaction;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *Server Connection class allows us to avoid keep writing this peace of code over and over again 
 * @author Bekezhan Abdykarimov 
 * @author Liudmila Stolbetskaia
 */
public class Server_Connection {

    private String dbServer,usernameS, passwordS;

    
    public Server_Connection(){
    this("jdbc:mysql://localhost:3306/ca_cross", "root", "root");
    }
    
    //Server connection constructor 
    public Server_Connection(String dbServer, String usernameS, String passwordS) {
        this.dbServer = dbServer;
        this.usernameS = usernameS;
        this.passwordS = passwordS;
    }
    
    
    public Connection connectToTheServer(){
        
        Connection conn = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            // Get a connection to the database
            conn = DriverManager.getConnection(dbServer,usernameS,passwordS);
            
        
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
       // System.out.println("Connected!");
        return conn;
      
        
    }
   
}
