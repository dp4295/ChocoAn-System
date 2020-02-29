package com.chocoan_system;
// Class for storing data about a treatment session
//import java.util.Scanner;

public class History {
  protected String date;
  protected String time;
  protected String service_type;
  protected History next;
  
  //public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class

  
  public History() {
    this.date = "__-__-____";
    this.time = "__:__";
    this-service_type = null;
    this.next = null;
}
