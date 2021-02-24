package com.learn.threading.util;

public class Counter implements Runnable {

    public static int count;
    int max;
    int min;
    int incrementBy;

    public Counter(int min, int max, int incrementBy) {
        this.min = min;
        this.max = max;
        this.incrementBy = incrementBy;
        validate();
    }

    private void validate() {
        if (max < min || incrementBy == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void run() {
        count = this.min;
        while (count < this.max) {
            count = count + incrementBy;
            System.out.println("current value is " + count + " which running in " + Thread.currentThread());
        }
    }

}
