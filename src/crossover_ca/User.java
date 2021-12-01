/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;


/**
 *
 * @author adminBeka
 * @author Liudmila Stolbetskaia
 */
import java.util.Scanner;
import java.sql.ResultSet;

public abstract class User {
    
    private int userID;
    private String userName;
    private String password;
    private String userRole;

    public User(int userID, String userName, String password, String userRole) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }
    
    
    public void Authentication(String usernameDB, String passwordDB){
        
        boolean valid;
        String username, password;
        do{
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter your username");
                valid = true;
                username = input.nextLine();

                System.out.println("Please enter your password");
                password = input.nextLine();


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
    }
    
  /*  public void usernameValidation(String userName){

        if(userName == userNameFromD){
            System.out.println("Welcome " + userName);
        }else{
            System.out.println("Sorry wrong userName");
        }
    }*/

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
}
