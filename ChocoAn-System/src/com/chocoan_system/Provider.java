package com.chocoan_system;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Provider {

  Scanner input = new Scanner(System.in);

  protected String date;
  protected String time;
  protected int num_consult;
  protected String service_code;


  protected String name;
  protected int ID;
  protected String street;
  protected String city;
  protected String state;
  protected int zip;

  public final int name_size = 25;
  public final int ID_size = 9;
  public final int street_size = 25;
  public final int city_size = 14;
  public final int zip_size = 5;

  public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class


  //PROVIDER UI
  protected int providerUI(){
    System.out.println();
    System.out.println("\tChoose an option:");
    System.out.println("\t1 - Member is requesting health services");
    System.out.println("\t2 - Display service codes");
    System.out.println("\t3 - Print weekly service report");
    System.out.println("\tEnter: ");

    int option = input.nextInt();

    switch (option){
      case 1: //request services
        break;

      case 2: //view service codes
        display_codes();
        break;

      case 3:
        break;
    }

    return 0;
  }


  // Display provider Directory
  public void display()
  {
    System.out.println("\n\n");
    System.out.println("\tProvider name: "+ name);
    System.out.println("\tService code:" + service_code);
    System.out.println("\tStreet: " + street);
    System.out.println("\tState: " + state);
    System.out.println("\tZip code: "+ zip);
    System.out.println("\n");
  }


  public void display_codes()
  {
/*
      String line = null;

      try (FileReader fr = new FileReader("services_codes.txt")) {

        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
              System.out.println(line);
        }

        br.close();
      }
      catch(IOException ex)
      {
        System.out.println("Error reading file.");
  */
  }


    // This function will be used to create a provider file
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


    public int writeout_provider_directory(String name, String id, String address, String city, String state, String zip){

      return 0;
    }

    public int writeout_provider_reports(){

      return 0;
    }

    public int writeout_EFT(){

      return 0;
    }

  }


