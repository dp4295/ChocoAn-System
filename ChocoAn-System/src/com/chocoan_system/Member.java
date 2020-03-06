package com.chocoan_system;
// Derived class of Person
//import java.util.Scanner;

public class Member extends Person {
  // protected String date;
 //  protected String time;
  protected History_node my_histories;

  
  public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class

  
  public Member() {
   // this.date = null;
    // this.time = null;
    this.my_histories = null;

  }


  // Constructor with argument list
  public Member(String name, int ID, String street, String city, String state, int zip, String date, String time)
  {
    super(name, ID, street, city, state, zip);
    // this.date = date;
    // this.time = time;
    this.my_histories = null;
  }


  public void build()
  {
     super.build();

  }

  public void display()
  {
    System.out.println("\n\n");
    System.out.println("\tMember name: "+ name);
    System.out.println("\tMember Id:" + ID);
    System.out.println("\tStreet: " + street);
    System.out.println("\tState: " + state);
    System.out.println("\tZip code: "+ zip);
    System.out.println("\n");
  }
  public void add_service()
  {


  }




}
