package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ARR {
    protected ARR_node[] head = new ARR_node[2];
    protected Scanner input;

    public ARR() {
        for (int i = 0; i < 2; ++i) {
            this.head[i] = null;
        }
        input = new Scanner(System.in);
    }

    protected int adminUI(){
        System.out.println("Please choose an option\n");
        System.out.println("1. Add a member");
        System.out.println("2. Add a provider");
        int role = input.nextInt();
        int flag;
        switch (role){
            case 1: //Member
                flag = 0;
                createNode(flag);
                break;
            case 2: //Provider
                flag = 1;
                createNode(flag);
                break;
            case 3:
                break;
        }
        return 0;
    }

    //Base case, create node if it doesn't exist. If it does, call recursive function.
    //The flag is the choice the user makes when adding a member or provider.
    //Members will be stored in index 0, providers will be stored in index 1.
    protected int createNode(int flag) {
        if (this.head[flag] == null) {
            this.head[flag] = new ARR_node();
            this.head[flag].create(flag);
            return 1;
        } else {

            ARR_node temp = new ARR_node();
            temp.create(flag);
            return createNode(this.head[flag], temp);
        }
    }

    int compare(ARR_node head, ARR_node temp) {
        return temp.obj.name.compareTo(head.obj.name);
    }

    //Recursive function, inserts into the list in order of last name?????????.
    protected int createNode(ARR_node head, ARR_node temp) {
        //Add at the end of the list, no smaller names found
        if (head.getNext() == null) {
            head.setNext(temp);
            return 2;
        }

        createNode(head.getNext(), temp);

        //If names are equal, check ID number, if ID number is the same return failure
        //If ID number is different, sort by ID number
        if (compare(head, temp) == 0) {
            if (head.obj.ID == temp.obj.ID) {
                return 0;
            } else if (head.obj.ID > temp.obj.ID) {
                temp.setNext(head);
                return 2;
            } else {
                head.setNext(temp);
                return 2;
            }
        }

        //If current name is less then temp name insert before
        if (compare(head, temp) < 0) {
            temp.setNext(head);
            return 2;
        }

        //If current name is greater then temp name insert after
        if (compare(head, temp) > 0) {
            head.setNext(temp);
            return 2;
        }
        return 0;
    }
}
