/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import java.util.Scanner;
import server_interaction.Table_Interaction;
import server_interaction.Validation;

/**
 *
 * @author Bekezhan Abdykarimov 2020297
 * @author Liudmila Stolbetskaia
 */
public class Crossover_CA {

    /**
     * 
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        Log_IN login = new Log_IN(); //initiating the Log_IN object( it is already with the database
        login.StartupMenu(); //calling startup menu to star our program 
        
       
    }

}
