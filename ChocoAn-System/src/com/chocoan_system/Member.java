package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;


public class Member {

    String first_name;
    String last_name;
    int ID;
    String street;
    String city;
    String state;
    int zip;

    Scanner input = new Scanner(System.in);

    protected int member_UI()
    {
        int id;

        System.out.println("Enter your member ID to log in: ");
        System.out.println("   (for testing purposes, please pretend you are John Doe - Member ID: 111111111)");
        id = input.nextInt();
        input.nextLine();

        System.out.println("Welcome, your ID is: " + id);


        return 0;

    }

    // This function will useful to create
    public void create_File(String name, String date) throws IOException {

        String filename = "ChocoAn-System/ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + name +date + ".txt";
        try{
            File file  = new File(filename);
            if(file.createNewFile()) {
                System.out.println("File is created");

            }else
            {
                System.out.println("File already exist");
            }
        }catch (IOException e){
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
    public void writeout_member_reports() {

        return;
    }
}
