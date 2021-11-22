/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author adminBeka
 * @author Liudmila Stolbetskaia
 */
public class Crossover_CA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Class.forName("com.mysql.cl.jdbc.Driver").newInstance();
            String dbServer = "jdbc:mysql://localhost:336/Userstable";//Userstable will be the name of the SQLPtoject
            String user = "root";
            String password = "";//to set password if needed
            String query = "Select * FROM user";// user is the name of the SQLtable
            
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);
            
            // Get a statement from the connection
            Statement stmt = conn.createStatement() ;
            
            // Execute the query
            ResultSet rs = stmt.executeQuery(query) ;
            
            while(rs.next()){
            }
            
        }catch (SQLExeption var8);
    }
    
}
