package org.example.MemoryManagement.ReferenceExp;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.sql.SQLOutput;


public class PhantomReferenceExp {
    public static void main(String[] args) {
        HelperClass HObj = new HelperClass();
        ReferenceQueue<HelperClass> QObj = new ReferenceQueue<HelperClass>();

        PhantomReference<HelperClass> PhantomObj = new  PhantomReference<>(HObj, QObj );

        System.out.println ("-> Calling Display Function using strong object:");
        HObj.display();

        System.out.println ("-> Object set to null");
        HObj = null;

        HelperClass newHObj = PhantomObj.get();
        System.out.println ("-> Calling Display Function after retrieving from soft Object");


        if(PhantomObj.enqueue()){
            System.out.println(
                    "Object successfully  enqueued");
        }
        if(PhantomObj.isEnqueued()){
            System.out.println(
                    "Object is enqueued");

        }
        System.out.println("Clearing the HObj refer");
        PhantomObj.clear();
        if(PhantomObj.isEnqueued()){
            System.out.println(
                    "Object is enqueued");

        }else {
            System.out.println(
                    "Object not enqueued");

        }
    }
}
