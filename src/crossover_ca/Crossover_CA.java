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
