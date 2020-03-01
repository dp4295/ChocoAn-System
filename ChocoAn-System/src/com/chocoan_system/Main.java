package com.chocoan_system;

import java.util.Scanner; 

public class Main {

   	    
	     public static void main(String[] args) {

        Scanner input;
        input = new Scanner(System.in);

        int role;

        //random!

        System.out.println("\n* WELCOME TO THE CHOCAN DATA PROCESSING SYSTEM *");
        System.out.println("\tChoose your role:");
        System.out.println("\t1 - Admin (Operator/Manager at ChocAn Data Center)");
        System.out.println("\t2 - Provider (Access Provider Interface)");
        System.out.println("\t3 - Member (Access Member Interface");

        role = input.nextInt();
        input.nextLine();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        switch (role) {
            case 1: //Admin
                //admin interface
                break;
            case 2:
                //provider interface
                break;
            case 3:
                //Member
                break;
        }
		     
	
	int flake;
	System.out.println("\tEnter a number between 1-6");
        flake = input.nextInt();
	input.nextLine();
		     
	switch(flake) {
	case 1:
		System.out.println("Deep is a flake and a slacker :P");
		break;
	case 2:
		System.out.println("Iris is a flake and a cookie thief :P");
		break;
	case 3:
		System.out.println("Chris is a flake and a scrub :P");
		break;
	case 4:
		System.out.println("Darika is a flake and a cat lady :P");
		break;
	case 5:
		System.out.println("Minjin is a flake and a night owl :P");
		break;
	case 6:
		System.out.println("Tenzin is a flake and is really flaky :P");
		break;
	case:
		System.out.println("y u block m3h from teh group text >:(");
	}
}
		     

 	
    }
}
