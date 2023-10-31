package org.example.MemoryManagement.ReferenceExp;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
//-----------------------------------------------------------------------------------------------------------------
//Weak Reference: It does not survive after the next garbage collection process.
//-----------------------------------------------------------------------------------------------------------------
//org.example.MemoryManagement.ReferenceExp.HelperClass@6d03e736
//org.example.MemoryManagement.ReferenceExp.HelperClass@6d03e736
//Object successfully enqueued
//Object is enqueued
//Object cleared
//the weakObj is Null , arbage collector cleared the object at this reference.
//java.lang.NullPointerException: Cannot invoke "Object.toString()" because "weakObj" is null
//Object not enqueued

public class WeakReferenceExp {

    public static void main(String[] args) {
        HelperClass HObj = new HelperClass();

        ReferenceQueue<HelperClass> qObj = new ReferenceQueue<HelperClass>();
        WeakReference<HelperClass> WeakRef = new WeakReference<>(HObj,qObj);
        //This method is used to get the object to which this reference refers.
        // It returns null if either java code or garbage collector cleared the object at this reference.
        HelperClass g = WeakRef.get();

        System.out.println(HObj.toString());
        System.out.println(g.toString());

        if (WeakRef.enqueue()) { //This method adds this object to its registered queue.
            System.out.println(
                    "Object successfully enqueued");
        }
        else {
            System.out.println("Object not enqueued");
        }

        if(WeakRef.isEnqueued()){//This method is used to know if this reference object is registered with any queue or not.
            System.out.println(
                    "Object is enqueued");

        }else{
            System.out.println("Object not enqueued");


        }
        //This method prevents this object from being enqueued by clearing this reference object.
        WeakRef.clear();

        System.out.println("Object cleared");
        HelperClass weakObj = WeakRef.get();
        try{
            System.out.println(weakObj.toString());
        }catch (NullPointerException e){
            System.out.println("the weakObj is Null , arbage collector cleared the " +
                    "object at this reference.\n" + e);


        }


        // trying to enqueue after clearing
        if (WeakRef.enqueue()) {
            System.out.println(
                    "Object successfully enqueued");
        }
        else {
            System.out.println("Object not enqueued");
        }


    }
}
