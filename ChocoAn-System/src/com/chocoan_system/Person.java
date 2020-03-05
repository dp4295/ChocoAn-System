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
    public final int name_size = 25; //java has no const - only finals so i deleted the consts
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

    public void build()
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


}
