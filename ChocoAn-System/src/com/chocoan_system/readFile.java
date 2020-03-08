package com.chocoan_system;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;


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
