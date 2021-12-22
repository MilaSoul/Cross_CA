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
import server_interaction.Validation;

/**
 *Log_IN class has methods to 
 * 1) to output the startup menu
 * 2) to Log-in 
 * 3) to Log-up 
 * 4) create Admin or regular user
 * @author Bekezhan Abdykarimov
 * @author Liudmila Stolbetskaia
 */
public class Log_IN {

    private Server_Connection ca;

    public Log_IN() {
        this.ca = new Server_Connection();
    }

    public Log_IN(Server_Connection ca) {
        this.ca = ca;
    }

    public void StartupMenu() throws SQLException, ClassNotFoundException {  // shows starup menu and offers to user to either login or logup

        int answer;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Hello, \n"
                    + "1) Log-up \n"
                    + "2) Log-in \n"
                    + " Enter 1 if you do not have an accaunt \n"
                    + " Enter 2 if you have an account \n");
            answer = scan.nextInt();
            scan.nextLine(); // to handle the /n (enterkey)
            if (answer == 1) {
                Logup();
                Login();
            } else if (answer == 2) {
                Login();
            } else {
                System.out.println("Error!!! Try again please!!!");
                StartupMenu();
            }
        } catch (Exception e) {
            System.out.println("Error!!! Try again please!!!");
            StartupMenu();
        }

    }

    public void Login() throws SQLException,
            ClassNotFoundException {   //Login method that allows us to get and store user's input, check if it is valid, and match it with the Database 

        //1) getting user's username and password 
        Scanner scan = new Scanner(System.in);
        //getting username and password
        System.out.println("Hello, enter your username and password to log-in\n"
                + "Please enter your username: \n");
        String username = scan.next();
        System.out.println("Please enter your password: \n");
        String password = scan.next();

        int user_id;
        try {

            Connection con = ca.connectToTheServer();   // Connecting to a server by using Server_connection class
            //2) selecting username and password(that user have entered) from the table
            PreparedStatement stm = con.prepareStatement("SELECT user_id, username, password FROM users WHERE username = ? AND password = ?");
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet result = stm.executeQuery(); //executing a statement
            //3) if username and password matches with the table:
            if (result.next()) { //this block will execute if there is will be a result from the query

                System.out.println(" \n User " + username + " is in the table \n");
                user_id = result.getInt("user_id");

                /* if user ID is equal to 1, it will create the admin,
                if it is not 1, then it will initiate regular user 
                 */
                if (user_id == 1) {

                    Admin admin;
                    admin = CreateUser();
                    /*CreateUser() methods are getting data from DB and putting them
                                           into the constructor to and return ready user or admin with data that maches with the username and password*/
                    admin.showAdminFunctions();  // Showing what admin can do
                } else {

                    RegularUser rUser;
                    rUser = CreateUser(user_id);
                    rUser.showUserFunctions();
                }
                // this.setUser_id(result.getInt("user_id"));
            } else {
                System.out.println("User not found, wrong name or password");
                Login();
            }

            con.close();// closing connection, prepared statement and result set
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
    }

    public void Logup() throws ClassNotFoundException {
        /*Logup method allows us to register get and store user's input, 
          check if it is valid, and post it into the Database's tables one by one
         */

        String username, password, firstname, secondname, email;
        boolean validUsername, validPassword, validFirstname, validSecondname, validEmail;
        Validation v = new Validation();
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to register as a user?");

        do {
            System.out.println("Type your username");
            username = sc.nextLine();
            validUsername = v.isUsernameValid(username);
            System.out.println(validUsername);

            System.out.println("Type your password:");
            password = sc.nextLine();
            validPassword = v.isValidPassword(password);
            System.out.println(validPassword);

        } while (validPassword != true || validUsername != true); // 1) Will run the loop until username and password won't be valid

        //2) if username and password are valid, this peice of code will insert data to Database(users table) 
        int user_id;
        String usersT = "users";
        String whatToInsert = "username, password";
        Table_Interaction table = new Table_Interaction();
        table.insertTo_Table(usersT, whatToInsert, username, password);
        // 3) after inserting data into the users table, which is gives us a user_id
        // we use this user_id to post other data and link it to this user
        user_id = table.selectUser_ID(username);
        System.out.println(user_id);
        System.out.println("Username and Password Created! \n"
                + "Please add your personal information: \n");

        do {
            System.out.println("Type your firstname: \n");
            firstname = sc.nextLine();
            validFirstname = v.isNameValid(firstname);

        } while (validFirstname != true); 

        do {
            System.out.println("Type your secondname: \n");
            secondname = sc.nextLine();
            validSecondname = v.isNameValid(secondname);

        } while (validSecondname != true);

        do {
            System.out.println("Type your email: \n");
            email = sc.nextLine();
            validEmail = v.isEmailValid(email);

        } while (validEmail != true);
        
        //4) entered personal information is valid, now we can insert it to the table
        String piT = "personal_info";
        whatToInsert = "firstname, secondname, email, user_id";

        String ID = Integer.toString(user_id);
        table.insertTo_Table(piT, whatToInsert, firstname, secondname, email, ID);
        table.insertTo_Table("role", "role_type, user_id", "user", ID); //posting user's role type and user id to the role table
        System.out.println("Registration complite!");
      

    }

    public Admin CreateUser() { //Creates and returns an Admin object with the data from the database a
        //method is basically just puts the data from DataBase to the Admin constructor 

        String selectQuery = "SELECT `users`.`user_id`, `users`.`username`, `users`.`password`, `personal_info`.`firstname`, `personal_info`.`secondname`, `personal_info`.`email`, `role`.`role_type`"
                + "FROM ((`ca_cross`.`users`"
                + "INNER JOIN `ca_cross`.`personal_info` ON `users`.`user_id` = `personal_info`.`user_id`)"
                + "INNER JOIN `ca_cross`.`role` ON `users`.`user_id` = `role`.`user_id`)"
                + "WHERE `ca_cross`.`users`.`user_id` = '1';";
        Table_Interaction tableint = new Table_Interaction(); //calling table interaction class with the templates to interact with the table
        ArrayList array;
        int user_id;
        String username, password, firstname, secondname, email, role; // 7 values(with int user_id)

        try {
            int j = 0;
            array = tableint.getFromTable(selectQuery); // method that is getting multiple values from database and puts them into the array list and returns this array list
            // 7 colums with values to output all of them in 1 row, we devide array size to 7 ( 7 values) 
            // adding the data from the getFromTable() arraylist to our local array
            user_id = Integer.parseInt(array.get(j).toString());
            username = array.get(++j).toString();
            password = array.get(++j).toString();
            firstname = array.get(++j).toString();
            secondname = array.get(++j).toString();
            email = array.get(++j).toString();
            role = array.get(++j).toString();
            Admin admin = new Admin(user_id, username, password, firstname, secondname, email, role); //putting that data to the empty constructor
            return admin; //returning ready user object with appropiate data from database
            //String table*/
        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public RegularUser CreateUser(int id) { // exact the same method as above, the only differences are 
                                            //1) it returns Regular user instead of admin
                                            //2) it is asking user id 

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
            //  System.out.println(user_id + " " + username + " " + firstname + " " + secondname + " " + email + " " + role);
            RegularUser rUser = new RegularUser(user_id, username, password, firstname, secondname, email, role);
            return rUser;
            //String table*/
        } catch (Exception ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
