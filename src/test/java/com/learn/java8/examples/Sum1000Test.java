package com.learn.java8.examples;

/* @author ravin @date 02-05-2020 @time 15:56 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

@Slf4j
public class Sum1000Test {

    @Test
    void sum1000_Java7() {
        int sum = 0;
        int i = 0;
        while (i <= 1000) {
            sum += i;
            i++;
        }
        log.info("sum of first 1000 numbers : " + sum);
    }

    @Test
    void sum1000() {
        log.info("sum of first 1000 numbers : " + IntStream.rangeClosed(0, 1000).sum());
    }
}
