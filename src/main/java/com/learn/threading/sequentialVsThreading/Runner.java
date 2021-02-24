package com.learn.threading.sequentialVsThreading;

public class Runner {
    String name;

    public Runner(String name) {
        this.name = name;
    }

    public void execute() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + "-" + i + " running in " + Thread.currentThread().getName());
        }
    }
}
