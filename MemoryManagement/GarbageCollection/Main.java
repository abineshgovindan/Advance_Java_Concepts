package org.example.MemoryManagement.GarbageCollection;

import org.example.MemoryManagement.ReferenceExp.HelperClass;

public class Main {


    protected  void finalize()
    {
        System.out.println ("Garbage Collection performed by JVM");
    }

    public static void main(String[] args) {
        HelperClass HObj1 = new HelperClass();
        HelperClass HObj2 = new HelperClass();
        HelperClass HObj3 = new HelperClass();
        HObj1 = null;
        HObj2 = HObj3;
        System.out.println("----------end----------");
        System.gc();
        Runtime.getRuntime().gc();




    }
}
