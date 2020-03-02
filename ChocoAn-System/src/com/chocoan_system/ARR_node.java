package com.chocoan_system;

public class ARR_node {

    protected int type;
    protected ARR_node next;
    ARR_node()
    {
        int type = 0;
        ARR_node next = null;

    }

    ARR_node(int type)
    {
        type = type;
    }

    public ARR_node getNext()
    {
        return next;
    }

    public void setNext(ARR_node obj)
    {
       next = obj.next;
    }
}
