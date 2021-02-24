package com.learn.threading.sequentialVsThreading;

public class App {

    public static void main(String[] args) {

        // creating runners
        Runner r1 = new Runner("Runner1");
        Runner r2 = new Runner("Runner2");

        System.out.println("Start --- Sequential Execution");
        // sequential executions
        r1.execute();
        r2.execute();
        System.out.println("End --- Sequential Execution");

        // creating threads
        Thread t1 = new Thread(() -> {
            r1.execute();
        });
        Thread t2 = new Thread(() -> {
            r2.execute();
        });

        System.out.println("Start --- Thread Execution");
        // thread executions
        t1.start();
        t2.start();

        System.out.println("End --- Thread Execution");
    }
}
