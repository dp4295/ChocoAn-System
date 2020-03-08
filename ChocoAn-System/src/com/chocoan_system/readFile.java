package com.chocoan_system;
import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;


//Scanner read = new Scanner (new File("provider_directory.txt"));
        //read.useDelimiter("|");
        //String title, category, runningTime, year, price;

        //while (read.hasNext())
//readfile looks at file input
//tests should be for file input
/*
public class readFile {
  //public void provider_readin()
  public static void main(String[] args) {
    try {
      //File Obj = new File("provider_directory.txt");
      Scanner scanner = new Scanner (new File("provider_directory.txt"));
      //Scanner scanner = new Scanner(Obj);
      scanner.useDelimiter("|");
      while (scanner.hasNextLine()) {
        //String data = scanner.nextLine();
        String provider_name = scanner.next();
        //parseData(provider_name);
        System.out.println("name: "+provider_name);
        String provider_id = scanner.next();
        System.out.println("id "+provider_id);
        String provider_address = scanner.next();
        String provider_city  = scanner.next();
        String provider_state = scanner.next();
        String provider_zip  = scanner.next();
        System.out.println("zip "+provider_zip);

        //System.out.println(data);//replace with code to store values(how are we storing?)


      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
*/

public class readFile {
  public static void main(String[] args) {
    Scanner scanner = null;
    try {
      scanner = new Scanner( new File("provider_directory.txt"));

      // Check if there is another line of input
      while(scanner.hasNextLine()){
        String str = scanner.nextLine();
        // parse each line using delimiter
        parseData(str);
      }

    } catch (IOException  exp) {
      exp.printStackTrace();
    }finally{
      if(scanner != null)
        scanner.close();
    }
  }

  private static void parseData(String str){
    String name, id, address, city, state, zip;
    Scanner lineScanner = new Scanner(str);
    lineScanner.useDelimiter("\\|");
    while(lineScanner.hasNext()){
      name = lineScanner.next();
      id= lineScanner.next();
      address = lineScanner.next();
      city = lineScanner.next();
      state = lineScanner.next();
      zip = lineScanner.next();
      System.out.println("name: " + name + " id:  " + id +
              " address:  " + address + city + state + zip);
    }
    lineScanner.close();
  }
}
