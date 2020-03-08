package com.chocoan_system;
// Base class for Objects containing Data


import java.util.Scanner;

public class Person {

      // public static void main(String[] args) {
      Scanner input;

    protected String name;
    protected int ID;
    protected String street;
    protected String city;
    protected String state;
    protected int zip;
    // protected Person next;
    public final int name_size = 25;
    public final int ID_size = 9;
    public final int street_size = 25;
    public final int city_size = 14;
    public final int zip_size = 5;

    //protected Scanner input;
  public Person() {
      this.name = null;
      this.ID = 0;
      this.street = null;
      this.city = null;
      this.state = "--";
      this.zip = 0;
      // this.next = null;
    }

  public Person(String name, int ID, String street, String city, String state,int zip)
    {
            this.name = name;
            this.ID = ID;
            this.street = street;
            this.city = city;
            this.state = state;
            this.zip = zip;
    }

    public void build(Provider obj)
    {
        input = new Scanner(System.in);

        System.out.println("\tProvider name: ");
        name = input.nextLine();
        input.nextLine();

        System.out.println("\tProvider ID ");
        ID = input.nextInt();
        input.nextLine();

        System.out.println("\tStreet address: ");
        street = input.nextLine();
        input.nextLine();

        System.out.println("\tCity: ");
        city = input.nextLine();
        input.nextLine();

        System.out.println("\tState:");
        state = input.nextLine();
        input.nextLine();

        System.out.println("\tZip ");
        zip = input.nextInt();
        input.nextLine();



    }
  public Person(Provider copy) {
      name = copy.name;
      street = copy.street;
      ID = copy.ID;
      street = copy.street;
      city = copy.city;
      state = copy.state;
      zip = copy.zip;
    }

    // putting subunit test code here
    // ID length bounds check [may be redundant?]
    protected int find_ID(int check) {
        // check for length- must be exactly 9 digits
        int length = (int) (Math.log10(check) + 1);
        if (length == ID_size)
            return 0;
        return -1;
    }

    // generic string length bounds check
    // we want the actual string length to be under or at the limit
    protected int check_length(String target, final int limit) {
        if (target.length() <= limit)
            return 0;
        return -1;
    }

    // series of tests to check that the date format is entered properly?
    // 1) check if the string is exactly 10 chars long
    // 2) check if the 3rd and 6th chars are dashes "__-__-____"
    // 3) [if there is time] check if the remaining chars are non-alphabetic

    protected boolean check_date_length(String test) {
      if (test.length() == 10)
          return true;
      return false;
    }

    protected boolean contains_dashes(String test) {
      char[] temp = test.toCharArray();
      if (temp[2] == '-' && temp[5] == '-')
          return true;
      return false;
    }

    // idk if the regex here is accurate but i want it to check if the contents of the string are either numeric or '-'
    protected boolean is_numeric(String test) {
      if (test.matches("[0-9-]+"))
          return true;
      return false;
    }

    protected boolean verify_date(String sample) {
        return (check_date_length(sample) && contains_dashes(sample) && is_numeric(sample));
    }


}
