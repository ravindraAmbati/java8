package com.learn.threading.deadLock;

import com.learn.threading.util.TimerExit;

public class SimpleDeadLock {

    public static void main(String[] args) {

        // program will exit after 5000 milliseconds
        TimerExit timerExit = new TimerExit(5000);
        timerExit.exitProgram();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(-1);
    }
}
