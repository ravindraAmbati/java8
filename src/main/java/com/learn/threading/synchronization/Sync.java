package com.learn.threading.synchronization;

import com.learn.threading.util.SyncCounter;

public class Sync {

    public static void main(String[] args) {

        // synchronized values will not share
        // executing one thread after another - without using join()
        Thread t1 = new Thread(new SyncCounter(0, 10, 1));
        Thread t2 = new Thread(new SyncCounter(0, 10, 1));

        t1.start();
        t2.start();

        try {
            t1.join(); // main thread will wait until t1 is completed
            t2.join(); // main thread will wait until t2 is completed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
