package com.learn.threading.util;

public class SyncCounter implements Runnable {

    public static int count;
    static int max;
    static int min;
    static int incrementBy;

    public SyncCounter(int min, int max, int incrementBy) {
        SyncCounter.min = min;
        SyncCounter.max = max;
        SyncCounter.incrementBy = incrementBy;
        validate();
    }

    private synchronized static void syncIncrement() {
        count = min;
        while (count < max) {
            count = count + incrementBy;
            System.out.println("current value is " + count + " which running in " + Thread.currentThread());
        }
    }

    private void validate() {
        if (max < min || incrementBy == 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void run() {
        syncIncrement();
    }

}
