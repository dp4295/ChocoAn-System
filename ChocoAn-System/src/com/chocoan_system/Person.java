package com.chocoan_system;
// Base class for Objects containing Data
//import java.util.Scanner;

public class Person {

  protected String name;
  protected int ID;
  protected String street;
  protected String city;
  protected String state;
  protected int zip;
  
  //protected Scanner input;
  public Person() {
    this.name = "";
    this.ID = 000000000;
    this.street = "";
    this.city = "";
    this.state = "--";
    this.zip = 00000;
  }
  
}
