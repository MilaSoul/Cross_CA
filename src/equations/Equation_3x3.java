/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author milastolbetskaya
 */
public class Equation_3x3 { // 3X3

    private int[] xyz = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] constant = {0, 0, 0};
    private int det;
    private int[] ctranspose = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private float det1,finalX,finalY,finalZ;
    private String equation1,equation2,equation3;
    

    public int[] getXyz() {
        return xyz;
    }

    public void setXyz(int[] xyz) {
        this.xyz = xyz;
    }

    public int[] getConstant() {
        return constant;
    }

    public void setConstant(int[] constant) {
        this.constant = constant;
    }

    public int getDet() {
        return det;
    }

    public void setDet(int det) {
        this.det = det;
    }

    public int[] getCtranspose() {
        return ctranspose;
    }

    public void setCtranspose(int[] ctranspose) {
        this.ctranspose = ctranspose;
    }

    public float getFinalX() {
        return finalX;
    }

    public void setFinalX(float finalX) {
        this.finalX = finalX;
    }

    public float getFinalY() {
        return finalY;
    }

    public void setFinalY(float finalY) {
        this.finalY = finalY;
    }

    public float getFinalZ() {
        return finalZ;
    }

    public void setFinalZ(float finalZ) {
        this.finalZ = finalZ;
    }

    public String getEquation1() {
        return equation1;
    }

    public void setEquation1(String equation1) {
        this.equation1 = equation1;
    }

    public String getEquation2() {
        return equation2;
    }

    public void setEquation2(String equation2) {
        this.equation2 = equation2;
    }

    public String getEquation3() {
        return equation3;
    }

    public void setEquation3(String equation3) {
        this.equation3 = equation3;
    }

    public float getDet1() {
        return det1;
    }

    public void setDet1(float det1) {
        this.det1 = det1;
    }

    public Equation_3x3() {
        
        readingEquations();
    }
    
    
    

    public void readingEquations() {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please type your first equation :");
         equation1 =s.next();
        equation1=equation1.toLowerCase().trim().replace(" ", "");
        String[] x = equation1.split("x");

        if (x[0].equals("")) {
            x[0] = x[0] + 1;
        } else if (x[0].equals("-") || x[0].equals("+")) {

            x[0] = x[0] + 1;
        }

        //System.out.println(x[0]);
        this.xyz[0] = Integer.parseInt(x[0]);

        String[] y = x[1].split("y");

        if (y[0].equals("")) {
            y[0] = y[0] + 1;
        } else if (y[0].equals("-") || y[0].equals("+")) {

            y[0] = y[0] + 1;
        }
        //System.out.println(y[0]);
        this.xyz[1] = Integer.parseInt(y[0]);

        String[] z = y[1].split("z");

        if (z[0].equals("")) {
            z[0] = z[0] + 1;
        } else if (z[0].equals("-") || z[0].equals("+")) {

            z[0] = z[0] + 1;
        }

        //System.out.println(z[0]);
        this.xyz[2] = Integer.parseInt(z[0]);

        String[] cosnt = z[1].split("=");
        //System.out.println(cosnt[1]);

        this.constant[0] = Integer.parseInt(cosnt[1]);
        
        
        System.out.println("Please type your second equation :");
        equation2 = s.next();
       equation2=equation2.toLowerCase().trim().replace(" ", "");

        String[] x2 = equation2.split("x");

        if (x2[0].equals("")) {
            x2[0] = x2[0] + 1;
        } else if (x2[0].equals("-") || x2[0].equals("+")) {

            x2[0] = x2[0] + 1;
        }

        //System.out.println(x2[0]);
        this.xyz[3] = Integer.parseInt(x2[0]);

        String[] y2 = x2[1].split("y");

        if (y2[0].equals("")) {
            y2[0] = y2[0] + 1;
        } else if (y2[0].equals("-") || y2[0].equals("+")) {

            y2[0] = y2[0] + 1;
        }
        //System.out.println(y2[0]);
        this.xyz[4] = Integer.parseInt(y2[0]);

        String[] z2 = y2[1].split("z");

        if (z2[0].equals("")) {
            z2[0] = z2[0] + 1;
        } else if (z2[0].equals("-") || z2[0].equals("+")) {

            z2[0] = z2[0] + 1;
        }

        //System.out.println(z2[0]);
        this.xyz[5] = Integer.parseInt(z2[0]);

        String[] cosnt2 = z2[1].split("=");
        //System.out.println(cosnt2[1]);
        this.constant[1] = Integer.parseInt(cosnt2[1]);
        
        
        System.out.println("Please type your third equation :");
        equation3 = s.next();
        equation3=equation3.toLowerCase().trim().replace(" ", "");

        String[] x3 = equation3.split("x");

        if (x3[0].equals("")) {
            x3[0] = x3[0] + 1;
        } else if (x3[0].equals("-") || x3[0].equals("+")) {

            x3[0] = x3[0] + 1;
        }

        //System.out.println(x3[0]);
        this.xyz[6] = Integer.parseInt(x3[0]);

        String[] y3 = x3[1].split("y");

        if (y3[0].equals("")) {
            y3[0] = y3[0] + 1;
        } else if (y3[0].equals("-") || y3[0].equals("+")) {

            y3[0] = y3[0] + 1;
        }
        //System.out.println(y3[0]);
        this.xyz[7] = Integer.parseInt(y3[0]);

        String[] z3 = y3[1].split("z");

        if (z3[0].equals("")) {
            z3[0] = z3[0] + 1;
        } else if (z3[0].equals("-") || z3[0].equals("+")) {

            z3[0] = z3[0] + 1;
        }
        //System.out.println(z3[0]);
        this.xyz[8] = Integer.parseInt(z3[0]);

        String[] cosnt3 = z3[1].split("=");
        //System.out.println(cosnt3[1]);
        this.constant[2] = Integer.parseInt(cosnt3[1]);

        //System.out.println(Arrays.toString(xyz));
        //System.out.println(Arrays.toString(constant));
        findDet();// read the next method 

    }

    public void findDet() {

        System.out.println("Determinant|A| formula = (a.e.i + b.f.g + c.d.h) - (c.e.g + a.f.h + b.d.i) :\n");

        // -------------First Side
        int aei = (this.getXyz()[0] * this.getXyz()[4] * this.getXyz()[8]);
        //System.out.println(aei);

        int bfg = (this.getXyz()[1] * this.getXyz()[5] * this.getXyz()[6]);
        //System.out.println(bfg);

        int cdh = (this.getXyz()[2] * this.getXyz()[3] * this.getXyz()[7]);
        //System.out.println(cdh);

        // -------------Second Side
        int ceg = (this.getXyz()[2] * this.getXyz()[4] * this.getXyz()[6]);
        //System.out.println(ceg);

        int afh = (this.getXyz()[0] * this.getXyz()[5] * this.getXyz()[7]);
        //System.out.println(afh);

        int bdi = (this.getXyz()[1] * this.getXyz()[3] * this.getXyz()[8]);
        //System.out.println(bdi);

        // Final result
        this.setDet((aei + bfg + cdh) - (ceg + afh + bdi)); // 23
        
        System.out.print("This is the Determinant of A: ");
        System.out.println(this.getDet()+"\n");
        cofactorsA();

    }

    public void cofactorsA() {

        int cf1 = ((this.getXyz()[4] * this.getXyz()[8]) - (this.getXyz()[5] * this.getXyz()[7]));

        int cf2 = ((this.getXyz()[3] * this.getXyz()[8]) - (this.getXyz()[5] * this.getXyz()[6])) * -1;

        int cf3 = ((this.getXyz()[3] * this.getXyz()[7]) - (this.getXyz()[4] * this.getXyz()[6]));

        int cf4 = ((this.getXyz()[1] * this.getXyz()[8]) - (this.getXyz()[2] * this.getXyz()[7])) * -1;

        int cf5 = ((this.getXyz()[0] * this.getXyz()[8]) - (this.getXyz()[2] * this.getXyz()[6]));

        int cf6 = ((this.getXyz()[0] * this.getXyz()[7]) - (this.getXyz()[1] * this.getXyz()[6])) * -1;

        int cf7 = ((this.getXyz()[1] * this.getXyz()[5]) - (this.getXyz()[2] * this.getXyz()[4]));

        int cf8 = ((this.getXyz()[0] * this.getXyz()[5]) - (this.getXyz()[2] * this.getXyz()[3])) * -1;

        int cf9 = ((this.getXyz()[0] * this.getXyz()[4]) - (this.getXyz()[1] * this.getXyz()[3]));

        System.out.println("Cofactors of A :");
        System.out.println("[" + cf1 + "," + cf2 + "," + cf3 + "," + cf4 + "," + cf5 + "," + cf6 + "," + cf7 + "," + cf8 + "," + cf9 + "]\n");

        System.out.println("Tranpose of Cofactors A:");
        
        this.ctranspose[0] = cf1;
        this.ctranspose[1] = cf4;
        this.ctranspose[2] = cf7;
        this.ctranspose[3] = cf2;
        this.ctranspose[4] = cf5;
        this.ctranspose[5] = cf8;
        this.ctranspose[6] = cf3;
        this.ctranspose[7] = cf6;
        this.ctranspose[8] = cf9;

        System.out.println(Arrays.toString(ctranspose)+"\n");
       transposeAxB();// callimg the next method 

    }
    
    public void transposeAxB(){
    
        System.out.println("Tranpose of Cofactors A * B :");
        
        float axb [] = {0,0,0};
        
        axb[0] = ((this.ctranspose[0]*this.constant[0]) + (this.ctranspose[1]*this.constant[1]) + (this.ctranspose[2]*this.constant[2])); 
        //System.out.println(axb[0]);
        
         axb[1] = ((this.ctranspose[3]*this.constant[0]) + (this.ctranspose[4]*this.constant[1]) + (this.ctranspose[5]*this.constant[2])); 
        //System.out.println(axb[1]);
        
         axb[2] = ((this.ctranspose[6]*this.constant[0]) + (this.ctranspose[7]*this.constant[1]) + (this.ctranspose[8]*this.constant[2])); 
        //System.out.println(axb[2]);
        
        det1 =1f/(this.getDet());// 23

        
        System.out.println(Arrays.toString(ctranspose)+" * "
                           +Arrays.toString(constant)+" = "+ 
                           "1/"+this.getDet()+" * "+ Arrays.toString(axb) +"\n");
        
        
        System.out.println("Final values: \nX = "+det1 * axb[0]+"\nY = "+det1 * axb[1]+"\nZ = "+det1 * axb[2]);
        
        this.setFinalX(det1 * axb[0]);
        this.setFinalY(det1 * axb[1]);
        this.setFinalZ(det1 * axb[2]);
    
    
    }
}
