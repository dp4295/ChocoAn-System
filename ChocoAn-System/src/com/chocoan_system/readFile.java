package com.chocoan_system;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Scanner read = new Scanner (new File("provider_directory.txt"));
        //read.useDelimiter("|");
        //String title, category, runningTime, year, price;

        //while (read.hasNext())
//readfile looks at file input
//tests should be for file input
public class readFile {
  //public void provider_readin()
  public static void main(String[] args) {
    try {
      //File Obj = new File("provider_directory.txt");
      Scanner scanner = new Scanner (new File("provider_directory.txt"));
      //Scanner scanner = new Scanner(Obj);
      scanner.useDelimiter("|");
      while (scanner.hasNext()) {
        //String data = scanner.nextLine();
        String provider_name = scanner.next();
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

