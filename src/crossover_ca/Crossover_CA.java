/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            
            Class.forName("com.mysql.cj.jdbc.Driver");
           // Class.forName("com.mysql.jdbc.Driver");
            String dbServer = "jdbc:mysql://localhost:3306/test-database";//Userstable will be the name of the SQLProject
            String user = "root";
            String password = "root";//to set password if needed
            String query = "SELECT * FROM people";// user is the name of the SQLtable
            
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);
            
            // Get a statement from the connection
            Statement stmt = conn.createStatement() ;
            
            // Execute the query
            ResultSet rs = stmt.executeQuery(query);
            
           
           
        /*    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test-database", "root", "root" );
            
            Statement stmt = connection.createStatement() ;
            
            // Execute the query
            ResultSet rs = stmt.executeQuery("select * from people;"); */
            
            while(rs.next()){
              //  System.out.println(rs.getString("firstname")); 
                PrintStream var10000 = System.out;
                String var10001 = rs.getString("idpeople");
                var10000.println(var10001 + "\t" + rs.getString("firstname"));
           } 
            
            
           /* while(rs.next()) {
                PrintStream var10000 = System.out;
                String var10001 = rs.getString("idpeople");
                var10000.println(var10001 + "\t" + rs.getString("user_name") + "\t" + rs.getString("user_password") + 
                        "\t" + rs.getString("user_role") + "\t" + rs.getString( "idpersonal_info" ));
            }*/
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
}


