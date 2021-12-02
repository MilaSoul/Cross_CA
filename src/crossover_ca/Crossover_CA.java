/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import server_interaction.Table_Interaction;
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
        String insertQuery = "INSERT INTO `ca_cross`.`users`\n" +
"(`username`,\n" + "`password`)" +
"VALUES\n" + "('Beka',\n" + "'Astana')"; //поставь ; перед " в конце
        usersDB.postTo_Table(insertQuery);
        usersDB.showTheFullTable();
        usersDB.selectFromTable_Password("CCT");
        usersDB.selectFromTable_ID("CCT");
        }
}//
