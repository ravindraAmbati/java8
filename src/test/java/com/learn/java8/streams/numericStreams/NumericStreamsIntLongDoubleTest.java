package com.learn.java8.streams.numericStreams;

/* @author ravin @date 06-05-2020 @time 08:29 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Slf4j
public class NumericStreamsIntLongDoubleTest {

    @Test
    void printIntStream() {
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .average()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .average()
                                .orElse(0)
                )
        );
//        IntStream
//                .rangeClosed(1,100)
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
//        IntStream
//                .range(1,100)
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
        log.info(
                IntStream
                        .rangeClosed(1, 100)
                        .summaryStatistics()
                        .toString()
        );
        log.info(
                IntStream
                        .range(1, 100)
                        .summaryStatistics()
                        .toString()
        );
    }

    @Test
    void printLongStream() {
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .average()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .average()
                                .orElse(0)
                )
        );
//        LongStream
//                .rangeClosed(1,100)
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
//        LongStream
//                .range(1,100)
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
        log.info(
                LongStream
                        .rangeClosed(1, 100)
                        .summaryStatistics()
                        .toString()
        );
        log.info(
                LongStream
                        .range(1, 100)
                        .summaryStatistics()
                        .toString()
        );
    }

    @Test
    void printFromLongToDoubleStream() {
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .asDoubleStream()
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .asDoubleStream()
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .asDoubleStream()
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .asDoubleStream()
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .average()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        LongStream
                                .range(1, 100)
                                .asDoubleStream()
                                .average()
                                .orElse(0)
                )
        );
//        LongStream
//                .rangeClosed(1,100)
//        .asDoubleStream()
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
//        LongStream
//                .range(1,100)
//                .asDoubleStream()
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
        log.info(
                LongStream
                        .rangeClosed(1, 100)
                        .asDoubleStream()
                        .summaryStatistics()
                        .toString()
        );
        log.info(
                LongStream
                        .range(1, 100)
                        .asDoubleStream()
                        .summaryStatistics()
                        .toString()
        );
    }

    @Test
    void printFromIntToDoubleStream() {
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .asDoubleStream()
                                .count()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .asDoubleStream()
                                .sum()
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .asDoubleStream()
                                .min()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .asDoubleStream()
                                .max()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .rangeClosed(1, 100)
                                .asDoubleStream()
                                .average()
                                .orElse(0)
                )
        );
        log.info(
                Objects.toString(
                        IntStream
                                .range(1, 100)
                                .asDoubleStream()
                                .average()
                                .orElse(0)
                )
        );
//        IntStream
//                .rangeClosed(1,100)
//        .asDoubleStream()
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
//        IntStream
//                .range(1,100)
//                .asDoubleStream()
//                .forEach(
//                        i -> log.info(Objects.toString(i))
//                );
        log.info(
                IntStream
                        .rangeClosed(1, 100)
                        .asDoubleStream()
                        .summaryStatistics()
                        .toString()
        );
        log.info(
                IntStream
                        .range(1, 100)
                        .asDoubleStream()
                        .summaryStatistics()
                        .toString()
        );
    }
}
