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

public abstract class User {
   
    private int user_id;
    private String username;
    private String password;
    private String userRole;
    private String firstname;
    private String secondname;
    private String email;

    public User(int user_id, String username, String password, String userRole, String firstname, String secondname, String email) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
