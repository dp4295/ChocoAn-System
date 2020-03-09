package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    Member member_obj = new Member();
    Provider provider_obj = new Provider();

    Scanner input = new Scanner(System.in);

    protected int adminUI() throws IOException {

        System.out.println("** YOU ARE IN THE ADMIN INTERFACE **");
        System.out.println("\tPlease choose an option");
        System.out.println("\t1. Add a member");
        System.out.println("\t2. Add a provider");
        System.out.println("\t3. Delete a member");
        System.out.println("\t4. Delete a provider");
        System.out.println("\n\tEnter the corresponding number to the action of your choice: ");

        int role = input.nextInt();

        int flag;

        switch (role){
            case 1: //Add Member
                member_obj.appendTo_memberDirectory();
                break;
            case 2: //Add Provider
                provider_obj.appendTo_providerDirectory();
                break;
            case 3: //Delete Member
                break;
            case 4: //Delete Provider
                break;
        }
        return 0;
    }
}

