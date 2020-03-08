package com.chocoan_system;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//readfile looks at file input
//tests should be for file input
public class readFile {

  // I'm guessing this class is where you read in file input and output the contents to the data structures?
  protected Provider provider;
  protected Member member;
  protected History_node history;
  // Scanner input; //???1604


  public void provider_readin(){
    try {
      File Obj = new File("provider_directory.txt");
      Scanner scanner = new Scanner(Obj);
      //scanner.useDelimiter("|");
      while (scanner.hasNextLine()) {
        //String data = scanner.nextLine();
        String data = scanner.useDelimiter("|");
        provider.name = data;
        String data = scanner.useDelimiter("|");

        System.out.println(data);//replace with code to store values(how are we storing?)
        //provider.name = data;
        //provider.ID = data; //Error:(26, 17) java: cannot find symbol [typo]
        //provider.street = data;
        //provider.city = data;
        //provider.state = data;
        //provider.zip = data; //Error:(30, 24) java: incompatible types: java.lang.String cannot be converted to int




      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

