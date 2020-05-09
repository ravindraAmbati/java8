package com.learn.java8.streams.parallelStreams;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/* @author ravin @date 09-05-2020 @time 16:20 */
@Slf4j
public class ParallelStreamsTest {

    private long startTime = 0L;
    private long endTime = 0L;

    @BeforeEach
    void setUp() {
        log.info("Available Processors in this machine  " + Runtime.getRuntime().availableProcessors());
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    void tearDown() {
        endTime = System.currentTimeMillis();
        log.info("total ms taken:" + (endTime - startTime));
        startTime = 0L;
        endTime = 0L;
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
}
