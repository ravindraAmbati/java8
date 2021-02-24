package com.learn.threading.daemon;

public class WorkerRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Worker thread is running...");
    }
}
