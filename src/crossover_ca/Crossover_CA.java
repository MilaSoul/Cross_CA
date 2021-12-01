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
import java.util.ArrayList;
import java.util.Scanner;

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
       
        Table_Interaction usersDB = new Table_Interaction();
        usersDB.connectToTheServer();
        usersDB.showTheFullTable();
        usersDB.tableUpdate("jefferson", 7);
        usersDB.showTheFullTable();
        usersDB.postTo_Table("INSERT INTO `ca_crossover`.`users`\n" +
"(`user_name`,\n" + "`user_password`,\n" + "`user_role`\n)" +
"VALUES\n" + "('michael',\n" + "'pass5',\n" + "'user');");
        usersDB.showTheFullTable();
        String passwordMila = usersDB.selectFromTable_Password("mila");
        
        
    //    ArrayList<String> tableCopy = usersTS.getFromTable(query,"user_name", "user_password");
  //      System.out.println(tableCopy + "" + tableCopy.size());
        
       /* String query2 = "INSERT INTO `ca_crossover`.`users`\n" +
"(`user_name`,\n" + "`user_password`,\n" + "`user_role`\n)" +
"VALUES\n" + "('aldana',\n" + "'pass3',\n" + "'user);";// поставь '
        usersTS.postTo_Table(query2);
        usersTS.showTheFullTable();*/
        
     /*   System.out.println(ca_ser.get(query, "user_name","user_password") + "size " + ca_ser.get(query, "user_name","user_password").size());
        System.out.println(ca_ser.get(query, "user_name","user_password").size());
        */
        }
}//
