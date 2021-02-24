package com.learn.threading.synchronization;

import com.learn.threading.util.Counter;

public class NonSync {

    public static void main(String[] args) {

        // non - synchronized values will be shared here
        Thread t1 = new Thread(new Counter(0, 10, 1));
        Thread t2 = new Thread(new Counter(0, 10, 1));

        t1.start();
        t2.start();

        try {
            t1.join(); // main thread will wait until this thread is completed
            t2.join(); // main thread will wait until this thread is completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // executing one thread after another - using join()
        Thread t3 = new Thread(new Counter(0, 10, 1));
        Thread t4 = new Thread(new Counter(0, 10, 1));

        t3.start();
        try {
            t3.join(); // main thread will wait until this thread is completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t4.start();
        try {
            t4.join(); // main thread will wait until this thread is completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
