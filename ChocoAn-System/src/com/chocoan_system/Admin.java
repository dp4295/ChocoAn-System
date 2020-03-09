package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    Scanner input = new Scanner(System.in);

    protected int adminUI(){
        System.out.println("Please choose an option\n");
        System.out.println("1. Add a member");
        System.out.println("2. Add a provider");
        System.out.println("3. Delete a member");
        System.out.println("4. Delete a provider");
        int role = input.nextInt();
        int flag;
        switch (role){
            case 1: //Add Member
                break;
            case 2: //Add Provider
                break;
            case 3: //Delete Member
                break;
            case 4: //Delete Provider
                break;
        }
        return 0;
    }
}

