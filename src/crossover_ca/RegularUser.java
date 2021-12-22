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
import java.sql.SQLException;

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
                        + "1) Modify your profile \n"
                        + "2) Solve 2x2 Equations \n"
                        + "3) Solve 3x3 Equations \n"
                        + "4) Exit \n"
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

        } catch (SQLException e) {
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

        } catch (SQLException e) {
        }

    }

}
