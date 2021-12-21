/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import server_interaction.Server_Connection;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import server_interaction.Table_Interaction;

/**
 *
 * @author adminBeka
 * @author Liudmila Stolbetskaia
 */
public class Crossover_CA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
       
        User_Authentication login = new User_Authentication();
        login.UserLogin();
}

 
        
     
        }


 /*"SELECT `user_id`"
                    + "FROM `users`" 
                    + "WHERE username=" + "'" + user_name + "';";




//   table.tableUpdate("password", "Dublin", "CCT");
    /*   String copyID = "\n SELECT user_id FROM  ";
       String insertQuery = "INSERT INTO `ca_cross`.`personal_info`\n" +
"(`firstname`,\n" + "`secondname`,\n" + "`email`,\n" + "`user_id`)" +
"VALUES\n" + "('Mila',\n" + "'Stolbetskaya',\n" + "'mila@mail.ru'\n" + copyID + " );";
       table.postTo_Table(insertQuery);
       System.out.println(table.getFromTable("personal_info"));  


    
       /*String insertQuery = "INSERT INTO `ca_cross`.`personal_info`\n" +
"(`firstname`,\n" + "`secondname`,\n" + "`email`,\n" + "`user_id`)" +
"VALUES\n" + "('Mila',\n" + "'Stolbetskaya',\n" + "'mila@mail.ru',\n" + "'1')";
    /*    String insertQuery = "INSERT INTO `ca_cross`.`users`\n" +
"(`username`,\n" + "`password`)" +
"VALUES\n" + "('Daniel',\n" + "'joints')"; //поставь ; перед " в конце
        users.postTo_Table(insertQuery);*/
     //   admin.showAll_Users();
   
        
    
  


