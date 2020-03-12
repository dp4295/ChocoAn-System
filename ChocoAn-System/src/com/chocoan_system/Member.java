package com.chocoan_system;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Member {

    protected String first_name;
    protected String last_name;
    protected int member_ID;
    protected String street_name;
    protected String city;
    protected String state;
    protected int zip;

    Scanner input = new Scanner(System.in);

    protected void member_UI() throws IOException{
        String id;

        try {
            System.out.println("** YOU ARE IN THE MEMBER INTERFACE **");
            System.out.println("\tEnter your 9 digit member ID to log in: ");
            System.out.println("   (for testing purposes, please pretend you are John Doe - Member ID: 111111111)");
            id = input.nextLine();

            int d = Integer.parseInt(id);
            //test for id number if valid or not
            check_ID(id);
            //member_report() function goes here
            //will continue to loop back until report function is placed.
        } catch (NumberFormatException e) {
            System.out.println("PLEASE ENTER NUMBERS ONLY!!! \n");
            member_UI();
        }

    }

    public void check_ID(String id) throws IOException {

        File inputFile = new File("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt");
        if (!inputFile.isFile()) {
            System.out.println("Not an existing file");//check file path
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt"));
        String line = null;

        while ((line = br.readLine()) != null) {

            if (line.contains(id)==true) {
                if (line.endsWith("suspended")) {
                    System.out.println("Member Suspended");
                    return;
                } else {
                    System.out.println("Validated");
                    System.out.println("Welcome, your ID is: " + id);
                    return;
                }
            }
        }

        System.out.println("Invalid Number");
        return;

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

    public void delete_member() {

        try {
            File inputFile = new File("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt");

            if (!inputFile.isFile()) {
                System.out.println("Not an existing file");//check file path
                return;
            }
            //temp file to store info not to be deleted
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;

            System.out.println("Enter the FIRST name of the member to be removed: ");
            first_name = input.nextLine();

            System.out.println("Enter the LAST name of the member to be removed: ");
            last_name = input.nextLine();

            while ((line = br.readLine()) != null) {
                if (!line.startsWith(first_name + " " + last_name)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();


            //Delete original file
            if (!inputFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename temp file to the original file name.
            if (!tempFile.renameTo(inputFile))
                System.out.println("Could not rename file");

            System.out.println("The member directory has been updated successfully.");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }



    // This function will return the name of the member based on id
    // Node: String variable to catch the name
    public void return_member_name(String number) throws IOException {

        String name = new String();

        Scanner scanner = null;
        try {

            scanner  = new Scanner(new File("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt"));

            // Check if there is another line of input
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                // parse each line using delimiter
                parseData(str, number);
            }

        } catch (IOException exp) {
            exp.printStackTrace();
        } finally {
            if (scanner != null)
                scanner.close();
        }
    }


    public void parseData(String str, String match_id ) {
        String name = new String();
        String address, city, state, zip, id;

        Scanner lineScanner = new Scanner(str);
        lineScanner.useDelimiter("\\|");
        while (lineScanner.hasNext()) {
            name = lineScanner.next();
            id = lineScanner.next();
            address = lineScanner.next();
            city = lineScanner.next();
            state = lineScanner.next();
            zip = lineScanner.next();

            if(id.equals(match_id)) {
                System.out.println("name: " + name + " id:  " + id +
                        " address:  " + address + city + state + zip);
                lineScanner.close();
            }
        }

        lineScanner.close();

    }


    // This function will create a folder based on the name
    // This function will call every time when new member has been added to the
    // member directory
    public void create_folder(String name) throws IOException {
        String filename = "ChocoAn-System/ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + name;
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
            System.out.println("Folder was created !");
        } else {
            System.out.println("Folder is exist");
        }
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



    public void writeout_member_reports() {

        return;
    }
}
