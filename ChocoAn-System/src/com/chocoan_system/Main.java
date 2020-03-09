package com.chocoan_system;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner input;
        input = new Scanner(System.in);

        Admin user_admin = new Admin();
        Member user_member = new Member();
        Provider user_provider = new Provider();

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
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        switch (role) {
            case 1: //Admin
                //admin interface
                //user_admin.adminUI();
                //user_member.writeout();
                break;
            case 2:
                //provider interface

                user_provider.providerUI();
                break;
            case 3:
                //Member
                System.out.println("You chose 3");
                user_member.member_UI();
                break;
        }


    }
}
