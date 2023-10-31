package org.example.MemoryManagement.ReferenceExp;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueExp {
    public static void main(String[] args) {
        HelperClass HObj1 = new HelperClass();
        HelperClass HObj2 = new HelperClass();
        HelperClass HObj3 = new HelperClass();
        HelperClass HObj4 = new HelperClass();

        ReferenceQueue<HelperClass> QObj = new ReferenceQueue<HelperClass>();

        WeakReference<HelperClass> WeakObj1 = new WeakReference<>(HObj1,QObj );
        WeakReference<HelperClass> WeakObj2 = new WeakReference<>(HObj3, QObj);
        System.out.println("-> Reference Queue Object :");
        System.out.println(QObj);
        WeakObj1.enqueue();
        WeakObj2.enqueue();
        if (WeakObj1.isEnqueued()){
            System.out.println("enqueued ");
        }else {
            System.out.println("Not enqueued");
        }
        System.out.println(QObj.poll());


    }
}
