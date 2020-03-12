package com.chocoan_system;

import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class Provider {

    protected String first_name;
    protected String last_name;
    protected int provider_ID;
    protected String street_name;
    protected String city;
    protected String state;
    protected int zip;

    Scanner input = new Scanner(System.in);

    protected String date;
    protected String time;
    protected int num_consult;
    protected String service_code;

    public final int name_size = 25;
    public final int ID_size = 9;
    public final int street_size = 25;
    public final int city_size = 14;
    public final int zip_size = 5;

    public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class


    //PROVIDER UI
    protected void providerUI() throws IOException {
        System.out.println("** YOU ARE IN THE PROVIDER INTERFACE **");
        System.out.println("\tChoose an option:");
        System.out.println("\t1 - Member is requesting health services");
        System.out.println("\t2 - Display service codes");
        System.out.println("\t3 - Print weekly service report");
        System.out.println("\t4 - Go back to the menu of roles");
        System.out.println("\tEnter number the corresponding number to the action of your choice: ");

        int option = input.nextInt();
        input.nextLine();

        Member m_object = new Member();
        String member_ID;

        switch (option) {
            case 1: //request services
                //add a service
                System.out.println("\nSwipe member ID card...");
                System.out.println("[Use the example of John Doe whose member ID is 112233445]");
                System.out.println("\nEnter member ID: ");
                member_ID = input.nextLine();
                //input.nextLine();
                System.out.println("Member ID is: " + member_ID);

                m_object.return_member_name(member_ID);

                break;

            case 2: //view service codes
                try {
                    display_codes();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                try {
                    display_provider_report();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //print weekly services
                break;

            case 4:
                break;
        }
    }


    public void display_codes() throws IOException {

        String line = null;

        try (FileReader fr = new FileReader("./ChocoAn-System/src/com/chocoan_system/files/provider/service_codes.txt")) {

            BufferedReader br = new BufferedReader(fr);

            System.out.println("SERVICE CODES");
            System.out.println("-------------");

            while ((line = br.readLine()) != null) {

                String[] service_code_info = line.split("\\|");

                System.out.println("\t" + service_code_info[1].toUpperCase() + " - "
                        + service_code_info[0].toUpperCase() + " (Fee $" + service_code_info[2] + ")");

            }

            br.close();
        } catch (IOException ex) {
            System.out.println("Error reading the service code file. Please check with administrator.");
        }
    }

    public void display_provider_report() throws IOException {

        String line = null;
        String line2 = null;

        try (FileReader fr = new FileReader("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_reports/test.txt")) {

            BufferedReader br = new BufferedReader(fr);

            System.out.println("PROVIDER REPORT");
            System.out.println("-----------------------------------------------------------------------------------------------");

            int i = 1;
            if((line = br.readLine()) != null) {

                String[] provider_info = line.split("\\|");

                //provider name and address
                System.out.println("\t" + provider_info[0].toUpperCase() + " | " + provider_info[1].toUpperCase() +
                        provider_info[2].toUpperCase() + provider_info[3].toUpperCase() + ", " + provider_info[4].toUpperCase() + " " + provider_info[5].toUpperCase());

                if ((line2 = br.readLine()) != null) {
                    System.out.println("\tTOTAL FEE FOR WEEK = $" + line2);
                    System.out.println();
                    System.out.println();
                    System.out.println("\tLIST OF MEMBERS THAT RECEIVED SERVICES: ");
                    System.out.println();
                }
            }

            while((br.readLine() != null)) {

                if ((line2 = br.readLine()) != null)
                    System.out.println("\t" + i + ". SERVICE REQUESTED ON: " + line2);

                if ((line2 = br.readLine()) != null)
                    System.out.println("\t   " + "DATE OF SERVICE: " + line2);

                if ((line2 = br.readLine()) != null) {
                    String[] member_name_id = line2.split("\\|");
                    System.out.println("\t   " + "MEMBER NAME: " + member_name_id[0].toUpperCase() + " | " + member_name_id[1]);
                }

                if ((line2 = br.readLine()) != null) {
                    String[] service_code_name = line2.split("\\|");
                    System.out.println("\t   " + "PROVIDED SERVICE: " + service_code_name[1].toUpperCase());
                }

                if ((line2 = br.readLine()) != null)
                    System.out.println("\t   CHARGED FEE: $" + line2);

                if ((line2 = br.readLine()) != null)
                    System.out.println("\t   TOTAL NUMBER OF CONSULTATIONS WITH MEMBER: " + line2);

                System.out.println("--------------------------------------------------------------------");

                ++i;
            }

            System.out.println();

            br.close();

        } catch (IOException ex) {
            System.out.println("Error reading the weekly provider report file. Please check with administrator.");
        }
    }

/*    // This function will be used to create a provider file
    public void create_File(String name, String date) throws IOException {

      String filename = "ChocoAn-System/ChocoAn-System/src/com/chocoan_system/files/provider/provider_reports/" + name +date + ".txt";

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
*/

    //random ID generator
    public static int number_Gen(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }


    //This function appends to the provider directory text file
    //The admin can add new providers by using this function
    public void appendTo_providerDirectory() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_directory.txt", true));
        try{
            writer.newLine();

            System.out.println("Enter the FIRST name of the provider: ");
            first_name = input.nextLine();
            if (first_name.matches("[0-9]"))
                throw new IllegalArgumentException();
            writer.write(first_name);
            writer.write(" ");

            System.out.println("Enter the LAST name of the provider: ");
            last_name = input.nextLine();
            if (last_name.matches("[0-9]"))
                throw new IllegalArgumentException();
            writer.write(last_name);
            writer.write("|");

            provider_ID = number_Gen(9);
            System.out.println("Assigned provider ID: " + provider_ID);
            writer.write(provider_ID + "");
            writer.write("|");

            System.out.println("Enter the STREET address of the provider: ");
            street_name = input.nextLine();
            writer.write(street_name);
            writer.write("|");

            System.out.println("Enter the CITY of the provider's address: ");
            city = input.nextLine();
            if (city.matches("[0-9]"))
                throw new IllegalArgumentException();
            writer.write(city);
            writer.write("|");

            System.out.println("Enter the STATE abbreviation of the provider's address: ");
            state = input.nextLine();
            if (state.matches("[0-9]"))
                throw new NumberFormatException();
            if (state.length() > 2)
                throw new IllegalArgumentException();
            writer.write(state);
            writer.write("|");

            System.out.println("Enter the zip code of the provider's address: ");
            zip = input.nextInt();

            input.nextLine();
            writer.write(zip + "");

            writer.close();

            System.out.println("** Provider is added to the database. **");

        }catch (NumberFormatException e) {
            System.out.println("Error: Invalid state ID\n");
            appendTo_providerDirectory();
        }
        catch (IllegalArgumentException i) {
            System.out.println("Error: Invalid input\nPlease restart the addition of a new member\n");
            appendTo_providerDirectory();
        }
    }

    public void delete_provider() {
        try {
            File inputFile = new File("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_directory.txt");

            if (!inputFile.isFile()) {
                System.out.println("Not an existing file");//check file path
                return;
            }
            //temp file to store info not to be deleted
            File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_directory.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;

            System.out.println("Enter the FIRST name of the provider to be removed: ");
            first_name = input.nextLine();

            System.out.println("Enter the LAST name of the provider to be removed: ");
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

            System.out.println("The provider directory has been updated successfully.");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public int writeout_provider_reports(){

        return 0;
    }

    public int writeout_EFT(){

        return 0;
    }


}

