/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossover_ca;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author adminBeka
 */
public class CheckUsernameAndPassword {
    /*private ConnectionTo_Server connect = new ConnectionTo_Server("jdbc:mysql://localhost:3306/ca_crossover", "root", "root");
    private Connection con;
    private String username;
    private String password;
    private String query;

    public CheckUsernameAndPassword(Connection con, String username, String password, String query) {
        this.con = connect.ConnectServer();
        this.username = username;
        this.password = password;
        this.query = query;
    }
    public Boolean check(){
        try{ 
            ResultSet r = con.createStatement().executeQuery(query);
            String admin_name = r.getString("username"); 
            while(r.next()){
                if(username.equals(r.getString("username"))) && password.equals(r.getString("password"))){
                return true;
            }
                return fasle;
            }
        }catch(SQLException ex){
                    System.out.println(ex.toString());
                    }
    
        }
    }
 */   
}
