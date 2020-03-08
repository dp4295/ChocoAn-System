package com.chocoan_system;
// Derived class of Person
//import java.util.Scanner;
/*
public class Member extends Person {
  // protected String date;
 //  protected String time;
  protected History_node head;

  
  public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class

  
  public Member() {
   // this.date = null;
    // this.time = null;
    this.head = null;

  }


  // Constructor with argument list
  public Member(String name, int ID, String street, String city, String state, int zip, String date, String time)
  {
    super(name, ID, street, city, state, zip);
    // this.date = date;
    // this.time = time;
    this.head = null;
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

  // adding a new History_node to the list of History_nodes for the member
  public void add_service(History_node temp)
  {
    add_service(head, temp);
  }
  // recursive helper function for adding History_node to the LLL
  private void add_service(History_node myHead, History_node temp2) {
    if (myHead == null) {
      myHead = new History_node();
      // need to populate the newly created History_node object with the contents of temp2
    }
    else {
      add_service(myHead.get_Next(), temp2);
    }
  }
  */

public class Member extends Person {




}
