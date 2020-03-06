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

}
