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
    protected int createNode(int flag)
    {
        if(this.head[flag] == null)
        {
            this.head[flag] = new ARR_node();
            this.head[flag].create(flag);
            return 1;
        }

        else
            return createNode(this.head[flag]);
    }

    //Recursive function, inserts into the list in order of last name.
    protected int createNode(ARR_node head)
    {

    }








}
