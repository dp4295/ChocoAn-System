package com.chocoan_system;
// Derived class of Person
//import java.util.Scanner;

public class Member extends Person {
  protected String date;
  protected String time;
  protected String service_type;
  protected History my_histories;
  
  public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class

  
  public Member() {
    this.date = null;
    this.time = null;
    this.service_type = null;
    this.my_histories = null;
  }

}
