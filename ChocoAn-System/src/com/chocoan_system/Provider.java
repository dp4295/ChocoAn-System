package com.chocoan_system;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Provider {

    protected String first_name;
    protected String last_name;
    protected int member_ID;
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
  protected void providerUI() {
    System.out.println("** YOU ARE IN THE PROVIDER INTERFACE **");
    System.out.println("\tChoose an option:");
    System.out.println("\t1 - Member is requesting health services");
    System.out.println("\t2 - Display service codes");
    System.out.println("\t3 - Print weekly service report");
    System.out.println("\t4 - Go back to the menu of roles");
    System.out.println("\tEnter number the corresponding number to the action of your choice: ");

    int option = input.nextInt();

    switch (option) {
      case 1: //request services
        break;

      case 2: //view service codes
        try {
          display_codes();
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;

      case 3:
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
        System.out.println("\t- " + line);
      }

      br.close();
    } catch (IOException ex) {
      System.out.println("Error reading the service code file. Please check with administrator.");
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

      //This function appends to the provider directory text file
      //The admin can add new providers by using this function
        public void appendTo_providerDirectory() throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("./ChocoAn-System/src/com/chocoan_system/files/provider/provider_directory.txt", true));

        writer.newLine();

        System.out.println("Enter the FIRST name of the provider: ");
        first_name = input.nextLine();
        writer.write(first_name);

        writer.write(" ");

        System.out.println("Enter the LAST name of the provider: ");
        last_name = input.nextLine();
        writer.write(last_name);

        writer.write("|");

        System.out.println("Enter the 8 digit ID number of the provider: ");
        member_ID = input.nextInt();
        input.nextLine();
        writer.write(member_ID + "");

        writer.write("|");

        System.out.println("Enter the STREET address of the provider: ");
        street_name = input.nextLine();
        writer.write(street_name);

        writer.write("|");

        System.out.println("Enter the CITY of the provider's address: ");
        city = input.nextLine();
        writer.write(city);

        writer.write("|");

        System.out.println("Enter the STATE abbreviation of the provider's address: ");
        state = input.nextLine();
        writer.write(state);

        writer.write("|");

        System.out.println("Enter the zip code of the provider's address: ");
        zip = input.nextInt();
        input.nextLine();
        writer.write(zip + "");

        writer.close();

        System.out.println("** Provider is added to the database. **");
}

    public int writeout_provider_reports(){

      return 0;
    }

    public int writeout_EFT(){

      return 0;
    }



  }

