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
 * @author adminBeka
 * @author Liudmila Stolbetskaia
 */
public interface Modify_User {

    public default void modifyProfile(int user_id) {

        Scanner scan = new Scanner(System.in);
        int i;
        int id = user_id;
        System.out.println(user_id);
        try {
            do {

                System.out.println("What you would like to modify? \n"
                        + "1)username \n"
                        + "2)password \n"
                        + "3)firstname \n"
                        + "4)secondname \n"
                        + "5)email \n"
                        + "6)go back");

                //    if (scan.hasNextInt()) {
                //  i = in.read();
                System.out.println("before scanner");
                i = scan.nextInt();
                System.out.println("after scanner");

                // scan.nextLine(); // after getting the int input, avoiding the error by adding nextLine()
                switch (i) {
                    case 1:

                        usernameUpdate(id);
                        System.out.println("1");
                        break;

                    case 2:

                        passwordUpdate(id);
                        System.out.println("2");
                        break;

                    case 3:

                        firstnameUpdate(id);
                        System.out.println("3");
                        break;

                    case 4:

                        secondnameUpdate(id);
                        System.out.println("4");
                        break;

                    case 5:
                        emailUpdate(id);
                        System.out.println("4");
                        break;
                    case 6:
                        System.out.println("exit");
                        break;

                    default:

                        System.out.println("try again");
                }
                scan.nextLine();
                System.out.println(i);
                System.out.println("loop");
                //    }
            } while (i != 6);
          //  scan.close();
        } catch (RuntimeException NException) {
            System.out.println("error");
            //modifyProfile();
        }
    }

    ;
    public default void usernameUpdate(int user_id) {

        System.out.println("Please, enter your new username: \n");
        Table_Interaction ti = new Table_Interaction();
        Scanner scan = new Scanner(System.in);
        String newUsername = scan.nextLine();

        String where, updateQuery;
        Validation v = new Validation();
        boolean validUsername = v.isUsernameValid(newUsername);

        if (validUsername) {
            where = Integer.toString(user_id);
            updateQuery = "UPDATE `ca_cross`.`users`"
                    + "SET `username` = ?"
                    + "WHERE `user_id` = ?";

            ti.tableUpdate(updateQuery, newUsername, where);
            System.out.println("Updated! Your username: " + newUsername);

        } else {
            System.out.println("wrong, username is not valid, do it again!");
            usernameUpdate(user_id);
        }
    }

    public default void passwordUpdate(int user_id) {

        Table_Interaction ti = new Table_Interaction();
        System.out.println("Please, enter your new password: \n");
        Scanner scan = new Scanner(System.in);
        String newPassword = scan.next();

        String where, updateQuery;
        Validation v = new Validation();
        boolean passValid = v.isValidPassword(newPassword);

        if (passValid) {

            where = Integer.toString(user_id);
            updateQuery = "UPDATE `ca_cross`.`users`"
                    + "SET `password` = ?"
                    + "WHERE `user_id` = ?";

            ti.tableUpdate(updateQuery, newPassword, where);
            System.out.println("Updated! Your password: " + newPassword);

        } else {
            System.out.println("wrong, password is not valid, do it again!");
            passwordUpdate(user_id);
        }
    }

    public default void firstnameUpdate(int user_id) {

        Table_Interaction ti = new Table_Interaction();
        System.out.println("Please, enter your new firstname: \n");
        Scanner scan = new Scanner(System.in);
        String newFirstname = scan.next();

        String where, updateQuery;
        Validation v = new Validation();
        boolean nameValid = v.isFirstNameValid(newFirstname);
        if (nameValid) {

            where = Integer.toString(user_id);
            updateQuery = "UPDATE `ca_cross`.`personal_info`"
                    + "SET `firstname` = ?"
                    + "WHERE `user_id` = ?";
            ti.tableUpdate(updateQuery, newFirstname, where);
            System.out.println("Updated! Your firstname: " + newFirstname);
        } else {
            System.out.println("Wrong, firstname is not valid, do it again");
            firstnameUpdate(user_id);
        }
    }

    public default void secondnameUpdate(int user_id) {

        Table_Interaction ti = new Table_Interaction();
        System.out.println("Please, enter your new secondname: \n");
        Scanner scan = new Scanner(System.in);
        String newSecondName = scan.next();

        String where, updateQuery;
        Validation v = new Validation();
        boolean nameValid = v.isSecondNameValid(newSecondName);
        if (nameValid) {

            where = Integer.toString(user_id);
            updateQuery = "UPDATE `ca_cross`.`personal_info`"
                    + "SET `secondname` = ?"
                    + "WHERE `user_id` = ?";
            ti.tableUpdate(updateQuery, newSecondName, where);
            System.out.println("Updated! Your secondname: " + newSecondName);
        } else {
            System.out.println("Wrong, secondname is not valid, do it again");
            secondnameUpdate(user_id);
        }
    }

    public default void emailUpdate(int user_id) {

        Table_Interaction ti = new Table_Interaction();
        System.out.println("Please, enter your new email: \n");
        Scanner scan = new Scanner(System.in);
        String newEmail = scan.next();

        String where, updateQuery;
        Validation v = new Validation();
        boolean emailValid = v.isEmailValid(newEmail);
        if (emailValid) {
            where = Integer.toString(user_id);
            updateQuery = "UPDATE `ca_cross`.`personal_info`"
                    + "SET `email` = ?"
                    + "WHERE `user_id` = ?";
            ti.tableUpdate(updateQuery, newEmail, where);
            System.out.println("Updated! Your email: " + newEmail);
        } else {
            System.out.println("Wrong, email is not valid, do it again");
            emailUpdate(user_id);
        }

    }

}
