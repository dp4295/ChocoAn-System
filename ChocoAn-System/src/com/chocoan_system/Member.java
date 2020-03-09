package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Member {

    Scanner input;

    // This function will useful to create
    public void create_File(String name, String date) throws IOException {

        String filename = "ChocoAn-System/ChocoAn-System/src/com/chocoan_system/files/member/member_reports/" + name +date + ".txt";
        try{
            File file  = new File(filename);
            if(file.createNewFile()) {
                System.out.println("File is created");

            }else
            {
                System.out.println("File already exist");
            }
        }catch (IOException e){
            System.out.println("Error occurred while creating a file");
            e.printStackTrace();
        }
    }

    public void writeout_member_directory() {

        return;
    }

    public void writeout_member_reports() {

        return;
    }
}
