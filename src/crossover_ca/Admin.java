/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_interaction.Table_Interaction;

/**
 *
 * @author adminBeka
 * @author Liudmila Stolbetskaia
 */
public class Admin extends User implements Modify_User {

    public Admin() {
        this(1, "", "", "", "", "", "");
    }

    public Admin(int user_id, String username, String password, String userRole, String firstname, String secondname, String email) {
        super(user_id, username, password, userRole, firstname, secondname, email);
    }

    public void showAdminFunctions() {
        try {
            int answer;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Hello dear user, what you would like to do? \n"
                        + "1) Modify your profile"
                        + "2) See all users in the system"
                        + "3) See all users operations"
                        + "4) Delete a particular user from the system"
                        + "5) exit"
                        + "Please type your answer: \n");

                answer = sc.nextInt();
                sc.nextLine(); // to handle the /n input in the buffer 
                if (answer == 1) {
                    modifyProfile(getUser_id());
                } else if (answer == 2) {
                    showAll_Users();
                } else if (answer == 3) {
                    showUsersOperations();
                } else if (answer == 4) {
                    removeUser();
                } else if (answer == 5) {
                    System.out.println("exit");
                    break;
                }
            } while (answer != 5);

        } catch (Exception ex) {

        }
    }

    public void showAll_Users() {

        String selectQuery = "SELECT `users`.`user_id`, `users`.`username`, `personal_info`.`firstname`, `personal_info`.`secondname`, `personal_info`.`email`, `role`.`role_type`"
                + "FROM ((`ca_cross`.`users`"
                + "INNER JOIN `ca_cross`.`personal_info` ON `users`.`user_id` = `personal_info`.`user_id`)"
                + "INNER JOIN `ca_cross`.`role` ON `users`.`user_id` = `role`.`user_id`);";
        Table_Interaction tableint = new Table_Interaction();

        ArrayList<String> array;
        String user_id, username, firstname, secondname, email, role; // 6 values

        try {

            array = tableint.getFromTable(selectQuery);
            int j = 0; // index in array
            System.out.println(array.size());
            System.out.println(array);
            for (int i = 0; i < array.size() / 6; i++) {  // 6 colums with values to output all of them in 1 row, we devide array size to 5 ( 5 values) 

                user_id = array.get(j++);
                username = array.get(j++);
                firstname = array.get(j++);
                secondname = array.get(j++);
                email = array.get(j++);
                role = array.get(j++);
                System.out.println(user_id + " " + username + " " + firstname + " " + secondname + " " + email + " " + role + "\n");
            }

            //String table*/
        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeUser() {
        try {
            String query1, query2, query3, query4;
            Scanner sc = new Scanner(System.in);
            Table_Interaction table = new Table_Interaction();
            System.out.println("Which user you would like to delete ? \n");
            showAll_Users();
            System.out.println("Please enter user ID of the user that you would like to delete: \n");
            int answer = sc.nextInt();
            sc.nextLine(); // to handle the /n (Enter key) from the buffer

            query1 = "DELETE FROM `ca_cross`.`personal_info`"
                    + "WHERE `user_id` = " + "'" + answer + "';";
            query2 = "DELETE FROM `ca_cross`.`role`"
                    + "WHERE `user_id` = " + "'" + answer + "';";
            query3 = "DELETE FROM `ca_cross`.`users`"
                    + "WHERE `user_id` = " + "'" + answer + "';";
            query4 = "DELETE FROM `ca_cross`.`equations`"
                    + "WHERE `user_id` = " + "'" + answer + "';";
            table.deleteFromTable(query1);
            table.deleteFromTable(query2);
            table.deleteFromTable(query3);
            table.deleteFromTable(query4); 
        } catch (Exception e) {
        }
    }

    public void showUsersOperations() {

        String selectQuery = "SELECT `users`.`user_id`, `users`.`username`, `personal_info`.`firstname`,"
                + " `equations`.`equsions_id`, `equations`.`equs_1`, `equations`.`equs_2`,  `equations`.`equs_3`,"
                + "`equations`.`det_1`, `equations`.`solution_1`, `equations`.`solution_2`, `equations`.`solution_3`"
                + "FROM ((`ca_cross`.`users`"
                + "INNER JOIN `ca_cross`.`equations` ON `users`.`user_id` = `equations`.`user_id`)"
                + "INNER JOIN `ca_cross`.`personal_info` ON `users`.`user_id` = `personal_info`.`user_id`);";
        Table_Interaction tableint = new Table_Interaction();
        ArrayList<String> array;
        String user_id, username, firstname, equsions_id, equs_1, equs_2, equs_3, det_1, det_2, solution_1, solution_2, solution_3; // 5 values

        try {

            array = tableint.getFromTable(selectQuery);
            System.out.println(array.size());
            System.out.println(array);
            int j = 0; // index in array
            for (int i = 0; i < array.size() / 11; i++) {  // 10 colums with values to output all of them in 1 row, we devide array size to 5 ( 5 values) 

                user_id = array.get(j++);
                username = array.get(j++);
                firstname = array.get(j++);
                equsions_id = array.get(j++);
                equs_1 = array.get(j++);
                equs_2 = array.get(j++);
                equs_3 = array.get(j++);
                det_1 = array.get(j++);
                //    det_2 = array.get(j++).toString();
                solution_1 = array.get(j++);
                solution_2 = array.get(j++);
                solution_3 = array.get(j++);
                System.out.println(user_id + " " + username + " " + firstname + " \n"
                        + "equations: \n"
                        + equsions_id + " " + equs_1 + " " + equs_2 + " " + equs_3 + " " + det_1 + " " + solution_1 + " " + solution_2 + " " + solution_3);
            }

            //String table*/
        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
