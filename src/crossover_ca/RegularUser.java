/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import server_interaction.Server_Connection;
import server_interaction.Table_Interaction;
import server_interaction.Validation;
import equations.Equations_2x2;
import equations.Equation_3x3;

/**
 *
 * @author adminBeka
 * @author Liudmila Stolbetskaia
 */
public class RegularUser extends User implements Interface_RegUser, Modify_User {

    private Server_Connection ca;

    public RegularUser() {
        this(0, "", "", "", "", "", "");
        this.ca = new Server_Connection();
    }

    public RegularUser(int user_id, String username, String password, String userRole, String firstname, String secondname, String email) {
        super(user_id, username, password, userRole, firstname, secondname, email);
        this.ca = new Server_Connection();
    }

    public void showUserFunctions() {

        try {
            int answer;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Hello dear user, what you would like to do? \n"
                        + "1) Modify your profile"
                        + "2) Solve 2x2 Equations"
                        + "3) Solve 3x3 Equations"
                        + "4) Exit"
                        + "Please type your answer: \n");

                answer = sc.nextInt();
                sc.nextLine(); // to handle the /n input in the buffer 
                if (answer == 1) {
                    modifyProfile(getUser_id());
                } else if (answer == 2) {
                    solveEquation2x2();
                } else if (answer == 3) {
                    solveEquation3x3();
                } else if (answer == 4) {
                    System.out.println("exit");
                    break;
                }
            } while (answer != 4);

        } catch (Exception ex) {

        }
    }

    public void UserRegistration() throws Exception {

        try {
            String username, password, firstname, secondname, email;
            boolean validUsername, validPassword, validFirstname, validSecondname, validEmail;
            Validation v = new Validation();
            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to register as a user?");

            do {
                System.out.println("Type your username");
                username = sc.next();
                validUsername = v.isUsernameValid(username);

                System.out.println("Type your password:");
                password = sc.next();
                validPassword = v.isValidPassword(password);
            } while (validUsername && validPassword);

            do {
                System.out.println("Type your firstname");
                firstname = sc.next();
                validFirstname = v.isFirstNameValid(firstname);

                System.out.println("Type your secondname");
                secondname = sc.next();
                validSecondname = v.isSecondNameValid(secondname);

                System.out.println("Type your email:");
                email = sc.next();
                validEmail = v.isEmailValid(email);

            } while (validFirstname && validSecondname && validEmail);

            int user_id = 0;

            //  System.out.println("Type your id");
            //  int user_id = sc.nextInt();
//            // wheb I update the first table it has to get the user_id and 
//            
//          
            Connection con = ca.connectToTheServer();

            PreparedStatement stm_2 = con.prepareStatement("INSERT INTO users (username, password)" + " VALUES (?, ?)");
            stm_2.setString(1, username);
            stm_2.setString(2, password);

            stm_2.executeUpdate();

            PreparedStatement stm_3 = con.prepareStatement("SELECT user_id FROM users WHERE username = '" + username + "' AND password = '" + password + "'");
            ResultSet result = stm_3.executeQuery();

            while (result.next()) {
                user_id = (result.getInt("user_id"));

                //System.out.println(user_id);
            }

            //     INSERT INTO personal_info (user_id)   SELECT user_id FROM users ;                              
            PreparedStatement stm = con.prepareStatement("INSERT INTO personal_info (firstname, secondname, email, user_id)" + "VALUES (?, ?, ?, ?)");
            stm.setString(1, firstname);
            stm.setString(2, secondname);
            stm.setString(3, email);
            stm.setInt(4, user_id);

            stm.executeUpdate();

            PreparedStatement stm_4 = con.prepareStatement("INSERT INTO role (role_type, user_id)" + "VALUES (?, ?)");
            stm.setString(1, "regular user");
            stm.setInt(2, user_id);

            stm.executeUpdate();

            // ResultSet result = stm.executeQuery();
            //display(result);
            //user registration 
            System.out.println("The registration has completed =)");

            stm.close();
            con.close();
            result.close();
            stm_2.close();
            stm_3.close();
            stm_4.close();

        } catch (Exception e) {
        }
    }

    public void solveEquation2x2() throws Exception {

        Equations_2x2 eq = new Equations_2x2();
        try {

            Connection con = ca.connectToTheServer();
            PreparedStatement p = con.prepareStatement("INSERT INTO equations (equs_1,equs_2,det_1,solution_1,solution_2,user_id,equs_3) VALUES(?,?,?,?,?,?,?)");
            p.setString(1, eq.getEq());
            p.setString(2, eq.getEq_2());
            p.setFloat(3, eq.getDet());
            p.setFloat(4, eq.getXandy()[0]);
            p.setFloat(5, eq.getXandy()[1]);

            p.setInt(6, this.getUser_id());
            p.setString(7, "NULL");

            p.executeUpdate();

            con.close();
            p.close();

        } catch (Exception e) {
        }

    }

    public void solveEquation3x3() throws Exception {

        Equation_3x3 eq = new Equation_3x3();
        try {

            Connection con = ca.connectToTheServer();
            PreparedStatement p = con.prepareStatement("INSERT INTO equations (equs_1,equs_2,equs_3,"
                    + "det_1,solution_1,solution_2,solution_3,user_id) VALUES(?,?,?,?,?,?,?,?)");
            p.setString(1, eq.getEquation1());
            p.setString(2, eq.getEquation2());
            p.setString(3, eq.getEquation3());
            p.setFloat(4, eq.getDet()); //getDet1()
            p.setFloat(5, eq.getFinalX());
            p.setFloat(6, eq.getFinalY());
            p.setFloat(7, eq.getFinalZ());
            p.setInt(8, this.getUser_id());

            p.executeUpdate();

            con.close();
            p.close();

        } catch (Exception e) {
        }

    }

}
