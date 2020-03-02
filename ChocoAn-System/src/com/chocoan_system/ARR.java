package com.chocoan_system;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ARR
{
    protected ARR_node head = new ARR_node[2];
    public ARR()
    {
        for(int i = 0; i < 2; ++i)
        {
            this.head[i] = null;
        }
    }

}
