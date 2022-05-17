/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Ryan Dixon
 */
public class VendingMachine {
    
    private static final int q0 = 0, q1 = 1, q2 = 2, q3 = 3, q4 = 4, q5 = 5, 
            q6 = 6, q7 = 7, q8 = 8;
    private int state;
    private static double balance;
    
    public VendingMachine(){
        balance = 0;
    }

    private static int delta(int s, char c){
        switch (s){
            case q0 : switch(c){
                case '1' : 
                    VendingMachine.deposit(0.25);
                    return q1;
                case '2' : 
                    VendingMachine.deposit(1.00);
                    return q4;
                case '3' : 
                    System.out.println("Please Input $1.25 for Soda");
                    return q0;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q1 : switch(c){
                case '1' : 
                    VendingMachine.deposit(0.25);
                    return q2;
                case '2' : 
                    VendingMachine.deposit(1.00);
                    return q5;
                case '3' : 
                    System.out.println("Please Input $1.25 for Soda");
                    return q1;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q2 : switch(c){
                case '1' : 
                    VendingMachine.deposit(0.25);
                    return q3;
                case '2' : 
                    VendingMachine.deposit(1.00);
                    return q6;
                case '3' : 
                    System.out.println("Please Input $1.25 for Soda");
                    return q2;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q3 : switch(c){
                case '1' : 
                    VendingMachine.deposit(0.25);
                    return q4;
                case '2' : 
                    VendingMachine.deposit(1.00);
                    return q7;
                case '3' : 
                    System.out.println("Please Input $1.25 for Soda");
                    return q3;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q4 : switch(c){
                case '1' : 
                    VendingMachine.deposit(0.25);  
                    return q5;
                case '2' : 
                    VendingMachine.deposit(1.00);
                    return q8;
                case '3' : 
                    System.out.println("Please Input $1.25 for Soda");
                    return q4;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q5 : switch(c){
                case '1' : 
                    System.out.println("Please Select a Soda");
                    return q5;
                case '2' : 
                    System.out.println("Please Select a Soda");
                    return q5;
                case '3' : 
                    VendingMachine.withdraw(1.25);
                    System.out.println("Thank You!");
                    return q0;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q6 : switch(c){
                case '1' : 
                    System.out.println("Please Select a Soda");
                    return q6;
                case '2' : 
                    System.out.println("Please Select a Soda");
                    return q6;
                case '3' : 
                    VendingMachine.withdraw(1.25);
                    System.out.println("Thank You!");
                    return q1;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q7 : switch(c){
                case '1' : 
                    System.out.println("Please Select a Soda");
                    return q7;
                case '2' : 
                    System.out.println("Please Select a Soda");
                    return q7;
                case '3' : 
                    VendingMachine.withdraw(1.25);
                    System.out.println("Thank You!");
                    return q2;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            case q8 : switch(c){
                case '1' :  
                    System.out.println("Please Select a Soda");
                    return q8;
                case '2' : 
                    System.out.println("Please Select a Soda");
                    return q8;
                case '3' : 
                    VendingMachine.withdraw(1.25);
                    System.out.println("Thank You!");
                    return q3;
                case '4' : 
                    VendingMachine.refund();
                    return q0;
            }
            default : return q0;
        }
    }
    
    public void reset(){
        state = q0;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public static void refund(){
        balance = 0;
    }

    public static void deposit(double amount){
        balance = balance + amount;
    }
 
    public static void withdraw(double amount){
        balance = balance - amount;
    }
    
    public void process(String in){
        for(int i = 0; i < in.length(); i++){
            char c = in.charAt(i);
            state = delta(state, c);
        }
    }
}