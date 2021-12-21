/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;
import server_interaction.Server_Connection;
import server_interaction.Table_Interaction;

/**
 *
 * @author milastolbetskaya this code going to sort 2 variable linear equations
 */
public class Equations_2x2{

private String[] xy = {"x", "y"};// 
private int[] var_xy = {0,0,0,0};
private int[] constant = {0,0};
private float det;
private float[] inversA ={0,0,0,0};
private float[] axb = {0,0};
private float[] xandy = {0,0};
private String eq,eq_2;

Scanner sc;



    public Equations_2x2() throws Exception {
        this.sc = new Scanner(System.in);
solutionSplit();
       
       
       
      
    }

    public String getEq() {
        return eq;
    }

    public void setEq(String eq) {
        this.eq = eq;
    }

    public String getEq_2() {
        return eq_2;
    }

    public void setEq_2(String eq_2) {
        this.eq_2 = eq_2;
    }


    public float getDet() {
        return det;
    }

    public void setDet(float det) {
        this.det = det;
    }
        
    public String[] getXy() {
        return xy;
    }

    public void setXy(String[] xy) {
        this.xy = xy;
    }

    public int[] getVar_xy() {
        return var_xy;
    }

    public void setVar_xy(int[] var_xy) {
        this.var_xy = var_xy;
    }

    public int[] getConstant() {
        return constant;
    }

    public void setConstant(int[] constant) {
        this.constant = constant;
    }

    public float[] getInversA() {
        return inversA;
    }

    public void setInversA(float[] inversA) {
        this.inversA = inversA;
    }

    public float[] getAxb() {
        return axb;
    }

    public void setAxb(float[] axb) {
        this.axb = axb;
    }

    public float[] getXandy() {
        return xandy;
    }

    public void setXandy(float[] xandz) {
        this.xandy = xandz;
    }

 

  


 
 public void solutionSplit() throws Exception{
 
      System.out.println("Hello! I am offering you to solve 2 matrices linear equation.\n"
                + "2x-3y=2\n"
                + "3x+8y=3\n"
                );
     System.out.println("Please type the first equation\n");

      this.setEq(sc.next().toLowerCase().trim().replace(" ",""));
     //this.setEq("2x-3y=2");
     
    String[] x = this.getEq().split("x");

    var_xy[0]=Integer.parseInt(x[0]);
    
    String[] y = x[1].split("y");
    
    var_xy[1]=Integer.parseInt(y[0]);
  
    
    
    String[] constant2 = y[1].split("=");
    
    constant[0] = Integer.parseInt(constant2[1]);
    
    
       
     System.out.println("Please type the second equation");
     this.setEq_2(sc.next().toLowerCase().trim().replace(" ",""));
     //this.setEq_2("3x+8y=3");
     
     String[] x_2 = this.getEq_2().split("x");
     var_xy[2] = Integer.parseInt(x_2[0]);
     
     String[] y_2 = x_2[1].split("y");
     var_xy[3] = Integer.parseInt(y_2[0]);
     
     String[] const_2 = y_2[1].split("=");
     constant[1]=Integer.parseInt(const_2[1]);
          
     det();
     
    
 }
 
 public void det() throws Exception{
     
     System.out.println("This is the value for the Determinant|A| :");

     this.setDet((this.getVar_xy()[0] * this.getVar_xy()[3]) - (this.getVar_xy()[1] * (this.getVar_xy()[2])));
     
     System.out.println(this.getDet());
     
     inverseOfA();
     
}
 
 public void inverseOfA() throws Exception{
   
     System.out.println("This is the inverse of A:");
     inversA[0] = this.getVar_xy()[0];
     inversA[1] = (this.getVar_xy()[1] * -1);
     inversA[2] = (this.getVar_xy()[2] * -1);
     inversA[3] = this.getVar_xy()[3];
 
   
     System.out.println(Arrays.toString(this.inversA));
     inverseAxB();
}
 
 public void inverseAxB() throws Exception{
     System.out.println("This is the solution for Inverse of A x B:");
     this.axb[0] = (((this.getInversA()[3] * this.getConstant()[0])
             + (this.getInversA()[1] * this.getConstant()[1])));
     
     this.axb[1] = ((this.getInversA()[2] * this.getConstant()[0] )
             + (this.getInversA()[0] * this.getConstant()[1])); 
     
     System.out.println(Arrays.toString(axb));
     
     finalSolution();
     
     
 }
 
 public void finalSolution() throws Exception{
     
     System.out.println("These are the final values for X and Y:");
 
 xandy[0] = (1/this.getDet()) * this.getAxb()[0];//
 xandy[1] = (1/this.getDet()) * this.getAxb()[1];
 
     System.out.println(Arrays.toString(xandy));
 }
}