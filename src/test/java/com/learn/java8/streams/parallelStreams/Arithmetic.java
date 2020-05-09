package com.learn.java8.streams.parallelStreams;

/* @author ravin @date 09-05-2020 @time 17:19 */

public class Arithmetic {

    private int input;
    private int result;

    int getResult() {
        return result;
    }

    void sum(int i) {
        result += i;
    }

    void mul(int i) {
        result *= i;
    }
}
