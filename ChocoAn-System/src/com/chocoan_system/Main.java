package com.chocoan_system;

import java.util.Scanner; 

public class Main {

    public static void main(String[] args) {
        ARR ARR1 = new ARR();
        Scanner input;
        input = new Scanner(System.in);

        int role;

        System.out.println("\n* WELCOME TO THE CHOCAN DATA PROCESSING SYSTEM *");
        System.out.println("\tChoose your role:");
        System.out.println("\t1 - Admin (Operator/Manager at ChocAn Data Center)");
        System.out.println("\t2 - Provider (Access Provider Interface)");
        System.out.println("\t3 - Member (Access Member Interface");
        System.out.print("\tEnter: ");
        role = input.nextInt();
        input.nextLine();

        //pause for a little bit
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        switch (role) {
            case 1: //Admin
                //admin interface
                ARR1.adminUI();
                break;
            case 2:
                //provider interface
                break;
            case 3:
                //Member
                break;
        }


    }
}
