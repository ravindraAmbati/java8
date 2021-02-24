package com.learn.threading.daemon;

public class DaemonRunnable implements Runnable {

    @Override
    public void run() {
        try {
            // infinite loop
            while (true) {
                System.out.println("Daemon thread is running...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
