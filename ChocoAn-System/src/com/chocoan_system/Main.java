package com.chocoan_system;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        commands();
    }

    public static int commands() throws IOException
    {
        Scanner input;
        input = new Scanner(System.in);

        Admin user_admin = new Admin();
        Member user_member = new Member();
        Provider user_provider = new Provider();

        int role, stay;

        try {
            System.out.println("\n** WELCOME TO THE CHOCAN DATA PROCESSING SYSTEM **");

            do {

                System.out.println("\tChoose your role:");
                System.out.println("\t1 - Admin (Operator/Manager at ChocAn Data Center)");
                System.out.println("\t2 - Provider (Access Provider Interface)");
                System.out.println("\t3 - Member (Access Member Interface)");
                System.out.println("\t4 - Quit program\n");
                System.out.println("\tEnter the corresponding number to the role of your choice: ");

                role = input.nextInt();
                input.nextLine();

                //pause for a little bit
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switch (role) {
                    case 1: //Admin interface

                        do {

                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            user_admin.adminUI();

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            System.out.println("\nWould you like to stay in the Admin Interface? ");
                            System.out.println("\t1 - Yes");
                            System.out.println("\t2 - No, go back to the menu of roles.");
                            System.out.println("\nEnter your decision here: ");

                            stay = input.nextInt();
                            input.nextLine();

                        } while (stay != 2);

                        break;
                    case 2: //provider interface

                        do {

                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            user_provider.providerUI();

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            System.out.println("\nWould you like to stay in the Provider Interface? ");
                            System.out.println("1 - Yes");
                            System.out.println("2 - No, go back to the menu of roles.");
                            System.out.println("\nEnter your decision here: ");

                            stay = input.nextInt();
                            input.nextLine();

                        } while (stay != 2);

                        //user_provider.display_codes();
                        break;
                    case 3: //member interface

                        do {

                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            user_member.member_UI();

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            System.out.println("\nWould you like to stay in the Member Interface? ");
                            System.out.println("1 - Yes");
                            System.out.println("2 - No, go back to the menu of roles.");
                            System.out.println("\nEnter your decision here: ");

                            stay = input.nextInt();
                            input.nextLine();

                        } while (stay != 2);

                        break;
                    case 4: //exit program
                        System.out.println("GOODBYE!");
                        break;
                }
            } while (role != 4);
        } catch (InputMismatchException e) {
            System.out.println("PLEASE ENTER NUMBERS ONLY!!! \n");
            commands();
            input.nextLine();
        }

        return 1;
    }
}
