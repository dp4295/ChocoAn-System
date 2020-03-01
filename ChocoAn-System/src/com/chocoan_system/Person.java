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
  protected Person next;
  
  public final int name_size = 25; //java has no const - only finals so i deleted the consts
  public final int ID_size = 9;
  public final int street_size = 25;
  public final int city_size = 14;
  public final int zip_size = 5;
  
  //protected Scanner input;
  public Person() {
    this.name = null;
    //this.ID = null; //ints an int
    this.street = null;
    this.city = null;
    this.state = "--";
    //this.zip = null; - int
    this.next = null;
  }
  
}
