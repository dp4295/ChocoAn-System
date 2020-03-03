package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ARR
{
    protected ARR_node[] head = new ARR_node[2];
    public ARR()
    {
        for(int i = 0; i < 2; ++i)
        {
            this.head[i] = null;
        }
    }

    //Base case, create node if it doesn't exist. If it does, call recursive function.
    //The flag is the choice the user makes when adding a member or provider.
    //Members will be stored in index 0, providers will be stored in index 1.
    protected int createNode(int flag)
    {
        if(this.head[flag] == null)
        {
            this.head[flag] = new ARR_node();
            this.head[flag].create(flag);
            return 1;
        }

        else
            return createNode(this.head[flag], flag);
    }

    //Recursive function, inserts into the list in order of last name.
    protected int createNode(ARR_node head, int type)
    {
       if(head.getNext() == null)
       {
           ARR_node temp = new ARR_node();
           temp.create(type);
           head.setNext(temp);
           temp.setNext(null);
           return 2;
       }

        String str1 = temp.obj.name;
        String str2 = head.obj.name;

        //If names are equal, check ID number, if ID number is the same return failure
        //If ID number is different, sort by ID number
        if(str1.compareTo(str2) == 0 ) {

            ARR_node temp = new ARR_node();
            temp.create(type);
        }
    }








}
