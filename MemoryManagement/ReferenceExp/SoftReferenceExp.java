package org.example.MemoryManagement.ReferenceExp;

import java.lang.ref.SoftReference;

public class SoftReferenceExp {
    public static void main(String[] args) {
        HelperClass HObj = new HelperClass();
        SoftReference<HelperClass> SoftObj = new SoftReference<>(HObj);

        System.out.println ("-> Calling Display Function using strong object:");
        HObj.display();

        System.out.println ("-> Object set to null");
        HObj = null;

        HObj = SoftObj.get();
        System.out.println ("-> Calling Display Function after retrieving from soft Object");
        HObj.display();

        if(SoftObj.enqueue()){
            System.out.println(
                    "Object successfully  enqueued");
        }
        if(SoftObj.isEnqueued()){
            System.out.println(
                    "Object is enqueued");

        }
        System.out.println("Clearing the HObj refer");
        SoftObj.clear();
        if(SoftObj.isEnqueued()){
            System.out.println(
                    "Object is enqueued");

        }else {
            System.out.println(
                    "Object not enqueued");

        }






    }
}
