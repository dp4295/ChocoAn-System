package com.chocoan_system;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;


public class  Provider {

    protected String first_name;
    protected String last_name;
    protected int provider_ID;
    protected String street_name;
    protected String city;
    protected String state;
    protected int zip;
    protected String id;
    protected String service_fee;
    protected String service_name;
    protected int counter = 0;
    protected int total_fee =0;

    Scanner input = new Scanner(System.in);

    protected String date;
    protected String time;
    protected int num_consult;
    protected String service_code;
    protected String comment;
    protected String current_time;
    protected String current_date;

    public final int name_size = 25;
    public final int ID_size = 9;
    public final int street_size = 25;
    public final int city_size = 14;
    public final int zip_size = 5;



    //PROVIDER UI
    protected void providerUI() throws IOException {
        System.out.println("** YOU ARE IN THE PROVIDER INTERFACE **");
        System.out.println("   (for testing purposes, please pretend you are Providence group - Provider ID: 124789741)");
        System.out.println("\nEnter your 9 digit provider ID to log in: ");
        id = input.nextLine();
        if (id.length() != 9){
            System.out.println("Error: ID number too long or too short or invalid input. Try again! \n");
            providerUI();}
        String line = check_ID(id);
        String [] provider_values = line.split("\\|");
        String provider_name = provider_values[0];

        System.out.println("\tChoose an option:");
        System.out.println("\t1 - Member is requesting health care services");
        System.out.println("\t2 - Display service names and corresponding service codes and fees");
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
                try {
                    System.out.println("\nSwipe member ID card...");
                    System.out.println("   (for testing purposes, please pretend you are John Doe - Member ID: 111111111)");
                    System.out.println("\nEnter 9 digit member ID: ");
                    member_ID = input.nextLine();

                    if (member_ID.length() != 9)
                        throw new IllegalArgumentException();
                    String name = m_object.check_ID(member_ID);
                    //String member_name = name.split("\\|")[0];
                    String [] member_values = name.split("\\|");
                    String member_name = member_values[0].toLowerCase();

                    System.out.println("\nName: " + member_name);
                    m_object.create_folder(member_name);


                    System.out.println("Enter in the date the service was provided using the format MM-DD-YYYY: \n");
                    date = input.nextLine();
                    //if string length no match call function again


                    int response = 0;
                    while(response != 1) {

                        service_code = null;
                        display_codes();
                        System.out.println("\nPlease key in the service code for the service provided using the service list above and press enter: ");
                        service_code = input.nextLine();
                        input.nextLine();

                        //display service name or print error message if wrong/does not exist
                        String service = check_service(service_code);
                        String [] service_values = service.split("\\|");
                        service_name = service_values[0];
                        service_fee = service_values[2];

                        System.out.println("The service corresponding to the code entered in is: "+service_name+"\n");
                        System.out.println("Confirm that this is the service you meant to enter.");
                        System.out.println("Enter 1 to confirm OR any other key for no: ");
                        response = input.nextInt();

                    }
                    //look up the fee to be paid for that service and display it on the provider’s terminal.
                    //print fee

                    System.out.println("The fee to be paid for the service "+service_name+" is: "+service_fee);
                    System.out.println("\nEnter in any comments about the service provided. Limit to 100 characters. (Note: this is optional) : \n");
                    input.nextLine();
                    comment = input.nextLine();
                    //input.nextLine();

                    System.out.println("\nEnter in the current date using the format MM-DD-YYYY : ");
                    boolean checkFormat = false;

                    while(checkFormat == false) {
                        current_date = input.nextLine();

                        if (current_date.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})"))
                            checkFormat = true;
                        else {
                            checkFormat = false;
                            System.out.println("Please enter in the date using the format MM-DD-YYYY. ");
                        }
                    }

                    checkFormat = false;
                    System.out.println("\nEnter in the current time using the format HH:MM:SS :");

                    while(checkFormat == false) {
                        current_time = input.nextLine();

                        if (current_time.matches("([0-9]{2}):([0-9]{2}):([0-9]{2})"))
                            checkFormat = true;
                        else {
                            checkFormat = false;
                            System.out.println("Please enter in the date using the format HH:MM:SS. ");
                        }
                    }

                    /*
                    //calc toal fee
                    counter+= 1;//number of consultations*30=total fee
                    total_fee += (30*counter);
                    */

                    //WRITE functions below
                    //provider form aka archive
                    writeout_archive(current_date, current_time, comment, service_code, date, member_ID, id); //write to archive.txt
                    String member_file_name = m_object.create_File(member_name, current_date );
                    writeout_member_reports(member_file_name, member_values, date, provider_name, service_name, service_code);


                    create_folder(provider_name);
                    String provider_file_name = create_File(provider_name, current_date);
                    writeout_provider_reports(provider_file_name, provider_values, service_fee, member_name, current_date, current_time, service_code, service_name, date, member_ID);
                    writeout_EFT(service_fee, provider_name, id);
                    // after provider report write to EFT.txt


                }
                catch (NumberFormatException e) {
                    System.out.println("Error: ID number too long or Invalid input!!\n");
                    providerUI();
                }
                catch(IllegalArgumentException i) {
                    System.out.println("Error: ID number too long or too short \n");
                    providerUI();
                }


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

    public String check_service(String service_code) throws IOException {
        File inputFile = new File("./ChocoAn-System/src/com/chocoan_system/files/provider/service_codes.txt");
        if (!inputFile.isFile()) {
            System.out.println("Not an existing file");//check file path
            return null;
        }
        BufferedReader br = new BufferedReader(new FileReader("./ChocoAn-System/src/com/chocoan_system/files/provider/service_codes.txt"));
        String line = null;

        while ((line = br.readLine()) != null) {

            if (line.contains(service_code) == true) {
                return line;
            }
        }
        System.out.println("\nInvalid Number. Please try again.\n");
        providerUI();
        return null;

    }

    public void writeout_member_reports(String member_file_name, String [] member_values, String date, String provider_name, String service_name, String service_code) throws IOException {

        //BufferedWriter writer = new BufferedWriter(new FileWriter("./ChocoAn-System/src/com/chocoan_system/files/member/archive.txt", true));
        BufferedWriter writer = new BufferedWriter(new FileWriter(member_file_name, true));

        writer.write(member_values[0]); //name
        writer.write("|");
        writer.write(member_values[1]);
        writer.write("|");
        writer.write(member_values[2]);
        writer.write("|");
        writer.write(member_values[3]);
        writer.write("|");
        writer.write(member_values[4]);
        writer.write("|");
        writer.write(member_values[5]); //zip
        writer.newLine();
        writer.write(date);
        writer.newLine();
        writer.write(provider_name);
        writer.newLine();
        writer.write(service_code);
        writer.write("|");
        writer.write(service_name);

        writer.close();

        System.out.println("\n** Member reports updated. **\n");

    }

    public void writeout_archive(String current_date, String current_time, String comment, String service_code, String date, String member_ID, String id) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("./ChocoAn-System/src/com/chocoan_system/files/provider/archive.txt", true));
        writer.newLine();

        writer.write(current_date);
        writer.write(" ");
        writer.write(current_time);
        writer.write("|");
        writer.write(date);
        writer.write("|");
        writer.write(id);
        writer.write("|");
        writer.write(member_ID);
        writer.write("|");
        writer.write(service_code);
        writer.write("|");
        writer.write(comment);
        writer.write("|");

        writer.close();

        System.out.println("\n** Record written to disk. **\n");

    }

    public String check_ID(String id) throws IOException {

        File inputFile = new File("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_directory.txt");
        if (!inputFile.isFile()) {
            System.out.println("Not an existing file");//check file path
            return null;
        }
        BufferedReader br = new BufferedReader(new FileReader("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_directory.txt"));
        String line = null;

        while ((line = br.readLine()) != null) {

            if (line.contains(id) == true) {
                System.out.println("\nValidated \n");
                System.out.println("Welcome, your ID is: " + id + "\n");
                String [] provider_info = line.split("\\|");
                String provider_name = provider_info[0];
                System.out.println("You have logged as: " + provider_name.toUpperCase());
                return line;
            }
        }
        System.out.println("\nInvalid Number. Please try again.\n");
        providerUI();
        return null;
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

        File f = new File("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_reports/"); //folder path

        String[] fileList = f.list(); //array of all file names in the path: /provider reports

        int number_of_files = fileList.length;  //number of files in the directory

        for(int j = 0; j < number_of_files; ++j) {
            try (FileReader fr = new FileReader("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_reports/" + fileList[j])) {

                BufferedReader br = new BufferedReader(fr);

                System.out.println("******************************************************************************************************");
                System.out.println("PROVIDER REPORT: " + fileList[j].toUpperCase());
                System.out.println("******************************************************************************************************");

                int i = 1;
                if ((line = br.readLine()) != null) {

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

                while ((br.readLine() != null)) {

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

                    System.out.println("\t   -------------------------------------------------");

                    ++i;
                }


                System.out.println();

                br.close();

            } catch (IOException ex) {
                System.out.println("Error reading the weekly provider report file. Please check with administrator.");
            }
        }
    }


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
            if (!tempFile.renameTo(inputFile)){
                System.out.println("Could not rename file");
                return;}

            System.out.println("The provider directory has been updated successfully.");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public void writeout_provider_reports(String provider_file_name, String [] provider_values, String service_fee, String member_name, String current_date, String current_time, String service_code, String service_name, String date, String member_ID) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(provider_file_name, true));

        writer.write(provider_values[0]); //provider name
        writer.write("|");
        writer.write(provider_values[1]);
        writer.write("|");
        writer.write(provider_values[2]);
        writer.write("|");
        writer.write(provider_values[3]);
        writer.write("|");
        writer.write(provider_values[4]);
        writer.write("|");
        writer.write(provider_values[5]);
        writer.newLine();

        //Total fee for the week
        //writer.newLine();

        writer.write("/");
        writer.newLine();
        writer.write(date);
        writer.newLine();
        writer.write(current_date);
        writer.write(" | ");
        writer.write(current_time);
        writer.newLine();
        writer.write(member_name);
        writer.write("|");
        writer.write(member_ID);
        writer.newLine();
        writer.write(service_code);
        writer.write("|");
        writer.write(service_name);
        writer.newLine();
        writer.write(service_fee);

        //Total number of consultations with members

        writer.close();

        System.out.println("\n** Provider reports updated. **\n");
    }

    public void writeout_EFT(String service_fee, String provider_name, String id) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("./ChocoAn-System/src/com/chocoan_system/files/provider/EFT.txt", true));
        writer.newLine();

        writer.write(provider_name);
        writer.write("|");
        writer.write(id);
        writer.write("|");
        writer.write(service_fee);

        writer.close();

        System.out.println("\n** EFT data updated. **\n");

    }

    // This function will create a folder based on the name
    // This function will call every time when new provider has been added to the
    // provider directory
    public void create_folder(String name) throws IOException {
        String filename = "ChocoAn-System/src/com/chocoan_system/files/provider/provider_reports/" + name;
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
            System.out.println("Folder was created !");
        } else {
            System.out.println("Folder exists");
        }
    }


    public String create_File(String name, String date) throws IOException {


        String filename = "ChocoAn-System/src/com/chocoan_system/files/provider/provider_reports/"+name+"/"+name+" "+date+".txt";
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
        return filename;
    }


}

