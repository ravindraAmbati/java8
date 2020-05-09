package com.learn.java8.streams.parallelStreams;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.IntStream;

/* @author ravin @date 09-05-2020 @time 16:20 */
@Slf4j
public class ParallelStreamsTest {

    private long startTime = 0L;
    private long endTime = 0L;
    private Arithmetic arithmeticOperation = null;

    @BeforeEach
    void setUp() {
        log.info("Available Processors in this machine  " + Runtime.getRuntime().availableProcessors());
        startTime = System.currentTimeMillis();
        arithmeticOperation = new Arithmetic();
    }

    @AfterEach
    void tearDown() {
        endTime = System.currentTimeMillis();
        log.info("total ms taken:" + (endTime - startTime));
        startTime = 0L;
        endTime = 0L;
        arithmeticOperation = null;
    }

    @Test
    void streams() {
        int i = 0;
        while (i < 100) {
            IntStream
                    .rangeClosed(0, 100000)
                    .summaryStatistics();
            i++;
        }
        log.info(
                IntStream
                        .rangeClosed(0, 100000)
                        .summaryStatistics()
                        .toString()
        );

    }

    @Test
    void parallelStreams() {
        int i = 0;
        while (i < 100) {
            IntStream
                    .rangeClosed(0, 100000)
                    .parallel()
                    .summaryStatistics();
            i++;
        }

        log.info(
                IntStream
                        .rangeClosed(0, 100000)
                        .parallel()
                        .summaryStatistics()
                        .toString()
        );
    }

    @Test
    void streamsBoxed() {

        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(0, 100000)
                                .boxed()
                                .reduce(0, (a, b) -> a + b)
                )
        );
    }

    @Test
    void parallelStreamsBoxed() {

        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(0, 100000)
                                .parallel()
                                .boxed()
                                .reduce(0, (a, b) -> a + b)
                )
        );
    }

    @Test
    void streamsArithmetic() {
        IntStream
                .rangeClosed(0, 100000)
                .forEach(
                        i -> arithmeticOperation.sum(i)
                );
        log.info(
                Objects.toString(
                        arithmeticOperation.getResult()
                )
        );
        IntStream
                .rangeClosed(1, 19)
                .forEach(
                        i -> arithmeticOperation.mul(i)
                );
        log.info(
                Objects.toString(
                        arithmeticOperation.getResult()
                )
        );
    }

    @Test
    void parallelStreamsArithmetic() {
        IntStream
                .rangeClosed(0, 100000)
                .parallel()
                .forEach(
                        i -> arithmeticOperation.sum(i)
                );
        log.info(
                Objects.toString(
                        arithmeticOperation.getResult()
                )
        );
        IntStream
                .rangeClosed(1, 19)
                .parallel()
                .forEach(
                        i -> arithmeticOperation.mul(i)
                );
        log.info(
                Objects.toString(
                        arithmeticOperation.getResult()
                )
        );
    }
}
