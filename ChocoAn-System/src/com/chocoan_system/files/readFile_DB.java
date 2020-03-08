package com.chocoan_system.files;

import java.io.File;
import java.util.Scanner;

public class readFile_DB {
    protected Scanner input;

    //opens file - if not found, throw an exception
    public void openFile() {
        try {
            input = new Scanner(new File("toppings.txt"));
        }
        catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    //read the data from the file
    public void readFile(ARR menu) {
        while(input.hasNext()) {
            int type = input.nextInt();
            int id = input.nextInt();
            float price = input.nextFloat();
            String topping_name = input.next();

            if(type == 1) //if it is a taco topping, add to menu[0]
            {
                //System.out.println("Taco is added");
                if(id == 1) {
                    Vegetable v_object = new Vegetable(price, topping_name);
                    menu.insert_array(0, v_object);
                }

                if(id == 2) {
                    Wrap w_object = new Wrap(price, topping_name);
                    menu.insert_array(0, w_object);
                }

                if(id == 3) {
                    Protein p_object = new Protein(price, topping_name);
                    menu.insert_array(0, p_object);
                }
            }
            else //if it is burrito topping, add to menu[1]
            {
                //System.out.println("burrito is added");
                if(id == 1) {
                    Vegetable v_object = new Vegetable(price, topping_name);
                    menu.insert_array(1, v_object);
                }

                if(id == 2) {
                    Wrap w_object = new Wrap(price, topping_name);
                    menu.insert_array(1, w_object);
                }

                if(id == 3) {
                    Protein p_object = new Protein(price, topping_name);
                    menu.insert_array(1, p_object);
                }
            }

        }
    }

    //closes file
    public void closeFile() {
        input.close();
    }
}
