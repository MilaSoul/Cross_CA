/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crossover_ca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_interaction.Table_Interaction;

import server_interaction.Server_Connection;

/**
 *
 * @author adminBeka
 */
public class User_Authentication {

    private Server_Connection ca;

    public User_Authentication() {
        this.ca = new Server_Connection();
    }

    public User_Authentication(Server_Connection ca) {
        this.ca = ca;
    }

    public void AdminOrUser(int user_id) {

        if (user_id == 1) {
            
            Admin admin = null;
            admin = CreateUser();
            admin.showAdminFunctions();
        } else{

            RegularUser rUser = null;
            rUser = CreateUser(user_id);
            rUser.showUserFunctions();
        }
    }

    public void UserLogin() throws SQLException,
            ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hello \n"
                + "Please enter your username:");
        String username = scan.next();
        System.out.println("Please enter your password:");
        String password = scan.next();

        int user_id;
        String userType, usernameC, passwordC; // C = stand for Checked
        try {

            Connection con = ca.connectToTheServer();

            PreparedStatement stm = con.prepareStatement("SELECT user_id, username, password FROM users WHERE username = ? AND password = ?");
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet result = stm.executeQuery();
            if (result.next()) {
                System.out.println("User is in the table");
                user_id = result.getInt("user_id");
                usernameC = result.getString("username");
                passwordC = result.getString("password");
                System.out.println(user_id + " " + usernameC + " " + passwordC);
                AdminOrUser(user_id);
               /* if (user_id == 1) {

                    userType = "admin";
                    return user_id;
                    /* Admin admin = null;
                    admin = CreateUser();
                    admin.modifyProfile(user_id);
                } else {

                    userType = "user";
                    return user_id;
                    /* rUser = new RegularUser();
                    rUser = CreateUser(user_id);
                 //   rUser.modifyProfile(user_id);
                  //  rUser.solveEquation2x2();
                    rUser.solveEquation3x3();
                }*/
                // this.setUser_id(result.getInt("user_id"));
            } else {
                System.out.println("User not found, wrong name or password");
                UserLogin();
            }

            con.close();
            stm.close();
            result.close();

        } catch (SQLException var8) {
            SQLException se = var8;
            System.out.println("SQL Exception:");

            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        } catch (Exception var9) {
            System.out.println(var9);
        }
       // return -1;

        //solveEquation3x3();
    }

    public Admin CreateUser() {

        String selectQuery = "SELECT `users`.`user_id`, `users`.`username`, `users`.`password`, `personal_info`.`firstname`, `personal_info`.`secondname`, `personal_info`.`email`, `role`.`role_type`"
                + "FROM ((`ca_cross`.`users`"
                + "INNER JOIN `ca_cross`.`personal_info` ON `users`.`user_id` = `personal_info`.`user_id`)"
                + "INNER JOIN `ca_cross`.`role` ON `users`.`user_id` = `role`.`user_id`)"
                + "WHERE `ca_cross`.`users`.`user_id` = '1';";
        Table_Interaction tableint = new Table_Interaction();
        ArrayList array;
        int user_id;
        String username, password, firstname, secondname, email, role; // 5 values

        try {
            int j = 0;
            array = tableint.getFromTable(selectQuery);
            // 5 colums with values to output all of them in 1 row, we devide array size to 5 ( 5 values) 
            user_id = Integer.parseInt(array.get(j).toString());
            username = array.get(++j).toString();
            password = array.get(++j).toString();
            firstname = array.get(++j).toString();
            secondname = array.get(++j).toString();
            email = array.get(++j).toString();
            role = array.get(++j).toString();
            System.out.println(user_id + " " + username + " " + firstname + " " + secondname + " " + email + " " + role);
            Admin admin = new Admin(user_id, username, password, firstname, secondname, email, role);
            return admin;
            //String table*/
        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public RegularUser CreateUser(int id) {

        String selectQuery = "SELECT `users`.`user_id`, `users`.`username`, `users`.`password`, `personal_info`.`firstname`, `personal_info`.`secondname`, `personal_info`.`email`, `role`.`role_type`"
                + "FROM ((`ca_cross`.`users`"
                + "INNER JOIN `ca_cross`.`personal_info` ON `users`.`user_id` = `personal_info`.`user_id`)"
                + "INNER JOIN `ca_cross`.`role` ON `users`.`user_id` = `role`.`user_id`)"
                + "WHERE `ca_cross`.`users`.`user_id` = '" + id + "';";
        Table_Interaction tableint = new Table_Interaction();
        ArrayList array;
        int user_id;
        String username, password, firstname, secondname, email, role; // 5 values

        try {
            int j = 0;
            array = tableint.getFromTable(selectQuery);
            // 5 colums with values to output all of them in 1 row, we devide array size to 5 ( 5 values) 
            user_id = Integer.parseInt(array.get(j).toString());
            username = array.get(++j).toString();
            password = array.get(++j).toString();
            firstname = array.get(++j).toString();
            secondname = array.get(++j).toString();
            email = array.get(++j).toString();
            role = array.get(++j).toString();
            System.out.println(user_id + " " + username + " " + firstname + " " + secondname + " " + email + " " + role);
            RegularUser rUser = new RegularUser(user_id, username, password, firstname, secondname, email, role);
            return rUser;
            //String table*/
        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    /*public void Authentication(){
        
        boolean valid;
        String username, password;
        UsersTable usersT = new UsersTable();
        
        do{
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter your username");
                valid = true;
                username = input.nextLine();

                System.out.println("Please enter your password");
                password = input.nextLine();
                String usernameDB = usersT.selectUsername(username);
                String passwordDB = usersT.selectPassword(password);
                if (username.equals(usernameDB) && password.equals(passwordDB)) {
                    System.out.println("The access is proved");
                } else {
                    System.out.println("the access id denied");
                    valid = false;
                }
            }catch(Exception e){
                System.out.println("The password is invalid");
                valid = false;

            }
        }while (!valid);
    }    */

}
