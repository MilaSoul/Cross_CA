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
public class Admin extends User implements Interface_Admin {
    public Admin(int userID, String userName, String password, String userRole) {
        super(userID, userName, password, userRole);
    }

    @Override
    public void modifyProfile() {

    }

    @Override
    public void showAll_Users() {

    }

    @Override
    public void removeUser() {

    }

    @Override
    public void showOperations() {

    }    
}
