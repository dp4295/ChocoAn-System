package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ARR {
    protected ARR_node[] head = new ARR_node[2];

    public ARR() {
        for (int i = 0; i < 2; ++i) {
            this.head[i] = null;
        }
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
