/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

/**
 *
 * @author adminBeka
 */
public abstract class User {
    
    private int userID;
    private int personal_info_ID;

    private String name;
    private String surname;
    private String email;
    private String userName;
    private String password;
    private String userRole;

    public User(int userID, String userName, String password, String userRole) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPersonal_info_ID() {
        return personal_info_ID;
    }

    public void setPersonal_info_ID(int personal_info_ID) {
        this.personal_info_ID = personal_info_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
