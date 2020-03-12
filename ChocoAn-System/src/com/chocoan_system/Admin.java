package com.chocoan_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {

    Member member_obj = new Member();
    Provider provider_obj = new Provider();

    Scanner input = new Scanner(System.in);

    protected int adminUI() throws IOException {

            try {

                System.out.println("** YOU ARE IN THE ADMIN INTERFACE **");
                System.out.println("\tPlease choose an option");
                System.out.println("\t1 - Add a member");
                System.out.println("\t2 - Add a provider");
                System.out.println("\t3 - Delete a member");
                System.out.println("\t4 - Delete a provider");
                System.out.println("\t5 - View member directory");
                System.out.println("\t6 - View provider directory");
                System.out.println("\t7 - Go back to the menu of roles");
                System.out.println("\n\tEnter the corresponding number to the action of your choice: ");

                int role = input.nextInt();

                int flag;

                switch (role) {
                    case 1: //Add Member
                        member_obj.appendTo_memberDirectory();
                        break;
                    case 2: //Add Provider
                        provider_obj.appendTo_providerDirectory();
                        break;
                    case 3: //Delete Member
                        member_obj.delete_member();
                        break;
                    case 4: //Delete Provider
                        provider_obj.delete_provider();
                        break;
                    case 5:
                        display_member_directory();
                        break;
                    case 6:
                        display_provider_directory();
                        break;
                    case 7:
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("PLEASE ENTER NUMBERS ONLY!!! \n");
                input.nextLine();
                adminUI();
            }
            return 0;
        }


        // Display provider Directory!
        public void display_provider_directory() throws IOException {


            String line = null;

            try (FileReader fr = new FileReader("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_directory.txt")) {

                BufferedReader br = new BufferedReader(fr);

                System.out.println("PROVIDER DIRECTORY");
                System.out.println("------------------");
                while ((line = br.readLine()) != null) {

                    //line.toUpperCase();
                    String[] provider_info = line.split("\\|");
                    //i.e) provider_info[0] = provider name, etc

                    System.out.println("\t- " + provider_info[0].toUpperCase() + " | " + provider_info[1].toUpperCase());
                    System.out.println("\t  " + provider_info[2].toUpperCase());
                    System.out.println("\t  " + provider_info[3].toUpperCase() + ", " + provider_info[4].toUpperCase() + " " + provider_info[5].toUpperCase());

                    System.out.println();
                }

                br.close();
            } catch (IOException ex) {
                System.out.println("Error reading the provider directory file. Please check with administrator.");
            }
        }

        public void display_member_directory() throws IOException {

            String line = null;

            try (FileReader fr = new FileReader("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt")) {

                BufferedReader br = new BufferedReader(fr);

                System.out.println("MEMBER DIRECTORY");
                System.out.println("----------------");

                while ((line = br.readLine()) != null) {

                    String[] member_info = line.split("\\|");

                    System.out.println("\t- " + member_info[0].toUpperCase() + " | " + member_info[1]);
                    System.out.println("\t  " + member_info[2].toUpperCase());
                    System.out.println("\t  " + member_info[3].toUpperCase() + ", " + member_info[4].toUpperCase() + " " + member_info[5].toUpperCase());

                    System.out.println();
                }

                br.close();
            } catch (IOException ex) {
                System.out.println("Error reading the member directory file. Please check with administrator.");
            }
        }

    }

