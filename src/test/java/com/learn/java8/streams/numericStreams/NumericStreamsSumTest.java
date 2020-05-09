package com.learn.java8.streams.numericStreams;

/* @author ravin @date 06-05-2020 @time 08:08 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

@Slf4j
public class NumericStreamsSumTest {

    private List<Integer> integers = null;

    @BeforeEach
    void setUp() {
        integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @AfterEach
    void tearDown() {
        integers = null;
    }

    @Test
    void print() {
        log.info(
                Objects.toString(
                        integers.stream()
                                .reduce(0, (a, b) -> a + b)
                )
        );
        log.info(
                Objects.toString(
                        integers.stream()
                                .reduce(0, Integer::sum)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 10)
                                .sum()
                )
        );
    }

}
