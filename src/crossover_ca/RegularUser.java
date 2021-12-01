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
public class RegularUser extends User implements Interface_Regular_User {
    
     public RegularUser(int userID, String userName, String password, String userRole) {
        super(userID, userName, password, userRole);
    }
     public RegularUser(){
        this(001,"beka", "blabla", "regularUser");
         System.out.println("new Ruser");
     };
     
     public void userBuilder(){
         
     }
    
}
