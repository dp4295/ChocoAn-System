package com.chocoan_system;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Member {

    protected String first_name;
    protected String last_name;
    protected int member_ID;
    protected String street_name;
    protected String city;
    protected String state;
    protected int zip;

    Scanner input = new Scanner(System.in);

    protected void member_UI() {
        int id;

        System.out.println("** YOU ARE IN THE MEMBER INTERFACE **");
        System.out.println("\tEnter your member ID to log in: ");
        System.out.println("   (for testing purposes, please pretend you are John Doe - Member ID: 111111111)");
        id = input.nextInt();
        input.nextLine();

        System.out.println("Welcome, your ID is: " + id);
    }


    // This function will useful to create
    public void create_File(String name, String date) throws IOException {

        String filename = "ChocoAn-System/ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + name + date + ".txt";
        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                System.out.println("File is created");

            } else {
                System.out.println("File already exist");
            }
        } catch (IOException e) {
            System.out.println("Error occurred while creating a file");
            e.printStackTrace();
        }
    }

    /*
 //this function appends new members to the member directory
    public void writeout_member_directory() throws IOException {
        try {
            File file = new File("./files/member/member_directory.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Enter the first name of the member: ");
            first_name = input.nextLine();
            input.nextLine();

            fw.write(first_name);

            System.out.println("Enter the LAST name of the member: ");
            last_name = input.nextLine();
            input.nextLine();

            fw.write(last_name);

            System.out.println("Enter the ");
            last_name = input.nextLine();
            input.nextLine();

            fw.close();

        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

    }

*/
    //creates 9 digit ID
    public static int number_Gen(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }

    //this function appends to the member directory text file located in the member folder
    //This function acts as an add function
    //The admin can use this to add new members to the database
    public void appendTo_memberDirectory() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt", true));

        writer.newLine();

        System.out.println("Enter the first name of the member: ");
        first_name = input.nextLine();
        writer.write(first_name);

        writer.write(" ");

        System.out.println("Enter the LAST name of the member: ");
        last_name = input.nextLine();
        writer.write(last_name);

        writer.write("|");

        member_ID = number_Gen(9);
        System.out.println("Assigned member ID: " + member_ID);
        writer.write(member_ID + "");

        writer.write("|");

        System.out.println("Enter the street address of the member: ");
        street_name = input.nextLine();
        writer.write(street_name);

        writer.write("|");

        System.out.println("Enter the CITY of the member's address: ");
        city = input.nextLine();
        writer.write(city);

        writer.write("|");

        System.out.println("Enter the STATE abbreviation of the member's address: ");
        state = input.nextLine();
        writer.write(state);

        writer.write("|");

        System.out.println("Enter the zip code of the member's address: ");
        zip = input.nextInt();
        input.nextLine();
        writer.write(zip + "");

        writer.close();

        System.out.println("** Member is added to the database. **");
}


    public void writeout_member_reports() {

        return;
    }
}
