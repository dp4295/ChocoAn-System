package com.chocoan_system;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readFile {

  // I'm guessing this class is where you read in file input and output the contents to the data structures?
  // protected Provider ptemp;
  // protected Member mtemp;
  // protected History_node temp;
  // Scanner input; //???

  public static void main(String[] args) {
    try {
      File myObj = new File("provider_directory.txt");
      Scanner myReader = new Scanner(myObj);
      //scanner.useDelimiter("|");
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);//replace with code to store values
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

