package com.chocoan_system;
// Class for storing data about a treatment session
//import java.util.Scanner;


    public class History_node {
  protected String date;
  protected String time;
  protected String service_date;
  protected String service_code;
  protected String prov_id;
  protected String mem_id;
  protected String comments;
  protected History_node next;
  //public final double unit_fee = 69.69; // let's hard code the service fee for testing purposes first; this might belong in a different class
//blsh blah

  public History_node() {
    this.date = "__-__-____";
    this.time = "__:__";
    this.service_date = "__-__-____";
    this.service_code = null;
    this.prov_id = null;
    this.mem_id = null;
    this.comments = null;
    this.next = null;
  }

}
