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
        int role = input.nextInt();
        int flag;
        switch (role){
            case 1: //Member
                break;
            case 2: //Provider
                break;
            case 3:
                break;
        }
        return 0;
    }
}

