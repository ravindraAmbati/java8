package com.learn.threading;

public class Incrementer implements Runnable{

    public static int i;
    public static void increment(){
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j <10; j++) {
            increment();
        }
        System.out.println("current value"+i);
    }

}
