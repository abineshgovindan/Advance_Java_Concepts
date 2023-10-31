package org.example.MemoryManagement;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {



    public static void main(String[] args)  throws RuntimeException{
        String hello = new String("Hello World!");
        //The String obj is stored in heap
        //The ref is stored in stack
        System.out.println(hello);

        // types of references:
        //Strong reference : Any object which has Strong reference attached
        // to it is not eligible for garbage collection
        String StrongObj = new String("Hello World!");
        //-----------------------------------------------------------------------------------------------------------------
        //Weak Reference: It does not survive after the next garbage collection process.
        //-----------------------------------------------------------------------------------------------------------------








        //--------------------------------------------------------------------------------------
        // Soft Reference: The garbage collector does not collect the softly
        // reachable objects. All soft referenced object s are collected before it throws an OutOfMemoryError.
        SoftReference<StringBuilder> SoftRef = new SoftReference<>(new StringBuilder());
        // Phantom Reference: The object which has only phantom reference pointing them can be collected whenever
        //  garbage collector wants to collect"
        //PhantomReference<Integer> PhantomRef = new PhantomReference<>(new StringBuilder("Hello"));






    }
}
