package com.chocoan_system;
// Derived class of Person
//import java.util.Scanner;

// import java.time.LocalTime;

public class Provider extends Person {
  protected String date;
  protected String time;
  protected String service_code;
  protected int num_consult;

  public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class

  Provider() {
    this.date = null;
    this.time = null;
    this.service_code = null;
    this.num_consult = 0;
  }

  //constructor w/ arg
  public Provider(String name, int ID, String street, String city, String state, int zip, String date, String time, String service_code)
  {
    super(name, ID, street, city, state, zip);
    this.date = date;
    this.time = time;
    this.service_code = service_code;
  }



  @Override


  // This function will ask provider to enter their information.
  // Who use this function: This function can be used by ARR_node class.
  // If admin want to create a new member
  public void build()
  {
    super.build();

    System.out.println("\tDate(mm/dd/yyyy): ");
    date = input.nextLine();
    input.nextLine();

    System.out.println("\tTime(HH:MM:SS): ");
    date = input.nextLine();
    input.nextLine();

    System.out.println("\tService code: ");
    service_code = input.nextLine();
    input.nextLine();
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

  /*
  public void display_codes()
  {
      try (BufferedReader br = new BufferedReader(new FileReader("service_codes.txt"))) {
          String line;
          while ((line = br.readLine()) != null) {
              System.out.println(line);
          }
      }
  }
   */

  //add service function is to be used by the provider UI
  //member requests service from provider
  //provider asks for all info and verifies id is correct
  //use case 2.1.1
  protected int add_service() {

      System.out.println("Enter in your member ID: ");
      int mem_id = input.nextInt();

      //if verified
      System.out.println("What service would you like today: ");

    //



  }

  //Provider UI
  protected int providerUI(){
    System.out.println("Please choose an option\n");
    System.out.println("1. Member is requesting health services");
    System.out.println("2. Display service codes");
    System.out.println("3. Print weekly service report");
    int option = input.nextInt();
    int flag;
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
}
