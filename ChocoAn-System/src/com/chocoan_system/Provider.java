package com.chocoan_system;
// Derived class of Person
//import java.util.Scanner;

public class Provider extends Person {
  protected String date;
  protected String time;
  protected String service_type;
  
  public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class

  public Provider() {
    this.date = null;
    this.time = null;
    this.service_type = null;      
  }

  public Provider(String date, String time, String service_type)
  {
    this.date = date;
    this.time = time;
    this.service_type = service_type;
  }
}
