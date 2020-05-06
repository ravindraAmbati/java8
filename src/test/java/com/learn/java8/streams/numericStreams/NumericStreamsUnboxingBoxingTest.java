package com.learn.java8.streams.numericStreams;

/* @author ravin @date 06-05-2020 @time 09:03 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Slf4j
public class NumericStreamsUnboxingBoxingTest {

    private List<Integer> integers = null;
    private List<Long> longs = null;
    private List<Double> doubles = null;

    @BeforeEach
    void setUp() {
        integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        longs = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        doubles = Arrays.asList(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d, 10d);
    }

    @AfterEach
    void tearDown() {
        integers = null;
        longs = null;
        doubles = null;
    }

    @Test
    void printInt() {
        log.info(
                IntStream
                        .rangeClosed(1, 10)
                        .boxed()
                        .collect(Collectors.toList())
                        .toString()
        );
        log.info(
                integers
                        .stream()
                        .mapToInt(i -> i.intValue())
                        .summaryStatistics()
                        .toString()
        );
    }

    @Test
    void printLong() {
        log.info(
                LongStream
                        .rangeClosed(1, 10)
                        .boxed()
                        .collect(Collectors.toList())
                        .toString()
        );
        log.info(
                longs
                        .stream()
                        .mapToLong(i -> i.longValue())
                        .summaryStatistics()
                        .toString()
        );
    }

    @Test
    void printDouble() {
        log.info(
                LongStream
                        .rangeClosed(1, 10)
                        .asDoubleStream()
                        .boxed()
                        .collect(Collectors.toList())
                        .toString()
        );
        log.info(
                doubles
                        .stream()
                        .mapToDouble(i -> i.doubleValue())
                        .summaryStatistics()
                        .toString()
        );
    }
}
