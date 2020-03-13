package com.chocoan_system;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    protected String response; // ask if member is active or not

    Scanner input = new Scanner(System.in);

    protected void member_UI() throws IOException{
        String id;

        try {
            System.out.println("** YOU ARE IN THE MEMBER INTERFACE **");
            System.out.println("\tEnter your 9 digit member ID to log in: ");
            System.out.println("   (for testing purposes, please pretend you are John Doe - Member ID: 111111111)");
            id = input.nextLine();

            if(id.length() != 9)
                throw new IllegalArgumentException();
            //test for id number if valid or not
            String name = check_ID(id);

            //member_report() function goes here
            display_member_report(name);
        } catch (NumberFormatException e) {
            System.out.println("Error: ID number too long or Invalid input!!\n");
            member_UI();
        }
        catch(IllegalArgumentException i) {
            System.out.println("Error: ID number too long or too short \n");
            member_UI();
        }
    }

    public String check_ID(String id) throws IOException {

        File inputFile = new File("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt");
        if (!inputFile.isFile()) {
            System.out.println("Not an existing file");//check file path
            return null;
        }
        BufferedReader br = new BufferedReader(new FileReader("./ChocoAn-System/src/com/chocoan_system/files/member/member_directory.txt"));
        String line = null;

        while ((line = br.readLine()) != null) {

            if (line.contains(id) == true) {
                if (line.endsWith("suspended")) {
                    System.out.println("\nMember Suspended");
                } else {
                    System.out.println("\nValidated");
                    System.out.println("\nWelcome, your ID is: " + id+"\n");
                }
                return line;
            }
        }
        System.out.println("\nInvalid Number. Please try again.\n");
        member_UI();
        return null;
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

        try {
            writer.newLine();

            System.out.println("Enter the first name of the member: ");
            first_name = input.nextLine();
            if (first_name.matches("[0-9]"))
                throw new IllegalArgumentException();
            writer.write(first_name);
            writer.write(" ");

            System.out.println("Enter the LAST name of the member: ");
            last_name = input.nextLine();
            if (last_name.matches("[0-9]"))
                throw new IllegalArgumentException();
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
            if (city.matches("[0-9]"))
                throw new IllegalArgumentException();
            writer.write(city);
            writer.write("|");

            System.out.println("Enter the STATE abbreviation of the member's address: ");
            state = input.nextLine();
            if (state.matches("[0-9]"))
                throw new NumberFormatException();
            if (state.length() > 2)
                throw new IllegalArgumentException();
            writer.write(state);
            writer.write("|");

            System.out.println("Enter the zip code of the member's address: ");
            zip = input.nextInt();
            input.nextLine();
            int ziplength = (int) (Math.log10(zip) + 1);
            if (ziplength != 5)
                throw new IndexOutOfBoundsException();
            writer.write(zip);
            writer.write("|");

            System.out.println("Is the member active? [Y/N]: ");
            response = input.nextLine();
            input.nextLine();
            if (response.length() > 1)
                throw new IllegalArgumentException();
            else if (response.matches("[yY]"))
                writer.write("active");
            else
                writer.write("suspended");
            writer.close();

            System.out.println("** Member is added to the database. **");

        }catch (NumberFormatException e) {
                System.out.println("Error: Invalid state ID\n");
                appendTo_memberDirectory();
            }
        catch (IllegalArgumentException i) {
            System.out.println("Error: Invalid input\nPlease restart the addition of a new member\n");
            appendTo_memberDirectory();
        }
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



    // This function will create a folder based on the name
    // This function will call every time when new member has been added to the
    // member directory
    public void create_folder(String name) throws IOException {
        String filename = "ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + name;
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

        String filename = "ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + name + date + ".txt";
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

    public void display_member_report(String name) throws IOException {

        String line = null;
        String line2 = null;

        //parse the member info for just the member's full name
        String [] member_info = name.split("\\|");
        String full_name = member_info[0].toLowerCase();

        //parse the full name into the first and last name
        String [] name_parsed = full_name.split(" ");
        String first_name = name_parsed[0];
        String last_name = name_parsed[1];

        //display member name and address
        System.out.println();
        System.out.println("******************************************************************************************************");
        System.out.println("MEMBER REPORT: " + member_info[0].toUpperCase());
        System.out.println("               " + member_info[2].toUpperCase());
        System.out.println("               " + member_info[3].toUpperCase() + ", " + member_info[4].toUpperCase() + " " + member_info[5].toUpperCase());
        System.out.println("               " + member_info[6].toUpperCase());
        System.out.println("******************************************************************************************************");

        File f = new File("./ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + first_name + "_" + last_name); //folder path

        if(!f.exists()) {
            System.out.println("Member does not have any service history. ");
        } else {

            String[] fileList = f.list(); //array of all file names in the path: /provider reports

            int number_of_files = fileList.length;  //number of files in the directory

            for (int j = 0; j < number_of_files; ++j) {
                try (FileReader fr = new FileReader("./ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + first_name + "_" + last_name + "/" + fileList[j])) {

                    BufferedReader br = new BufferedReader(fr);

                    while ((br.readLine() != null)) {

                        if ((line2 = br.readLine()) != null)
                            System.out.println("\t" + "DATE OF SERVICE: " + line2);

                        if ((line2 = br.readLine()) != null) {
                            String[] member_name_id = line2.split("\\|");
                            System.out.println("\t" + "PROVDER NAME: " + line2);
                        }

                        if ((line2 = br.readLine()) != null) {
                            String[] service_code_name = line2.split("\\|");
                            System.out.println("\t" + "PROVIDED SERVICE: " + service_code_name[1].toUpperCase());
                        }

                        System.out.println("\t-------------------------------------------------");

                    }

                    System.out.println();

                    br.close();

                } catch (IOException ex) {
                    System.out.println("Error reading the member report file OR a service file does not exist. Please check with administrator if you think this is a mistake.");
                }
            }
        }
    }
}
