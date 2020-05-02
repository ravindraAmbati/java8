package com.learn.java8.lambdasAndFunctionalInterfaces;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

@Slf4j
public class BiConsumerImpl {

    private BiConsumer<Integer, Integer> additionBiConsumer = null;
    private BiConsumer<Integer, Integer> differenceBiConsumer = null;
    private BiConsumer<Integer, Integer> timesBiConsumer = null;
    private BiConsumer<Integer, Integer> divisionBiConsumer = null;

    @BeforeEach
    void setUp() {
        additionBiConsumer = (i, j) -> log.info("addition of " + i + " and " + j + "    is  " + (i + j));
        differenceBiConsumer = (i, j) -> {
            if (i.equals(j)) {
                log.warn("difference of " + i + " and " + j + " is Zero");
            } else if (i > j) {
                log.info("difference of " + i + " and " + j + " is  " + (i - j));
            } else {
                log.info("difference of " + i + " and " + j + " is  " + (j - i));
            }
        };
        timesBiConsumer = (i, j) -> {
            if (i == 0 || j == 0) {
                log.warn("times of " + i + " and " + j + " is Zero");
            } else {
                log.info("times of " + i + " and " + j + "  is  " + (i * j));
            }
        };

        divisionBiConsumer = (i, j) -> {
            if (j == 0) {
                log.info("division of " + i + " and " + j);
                log.error("cannot be operate");
            } else {
                log.info("division of " + i + " and " + j + "  is   " + (i / j));
            }
        };
    }

    @AfterEach
    void tearDown() {
        additionBiConsumer = null;
        differenceBiConsumer = null;
        timesBiConsumer = null;
        divisionBiConsumer = null;
    }

    @Test
    void add() {
        additionBiConsumer.accept(1, 2);
    }

    @Test
    void diff() {
        differenceBiConsumer.accept(3, 8);
        differenceBiConsumer.accept(8, 3);
        differenceBiConsumer.accept(7, 7);
    }

    @Test
    void mul() {
        timesBiConsumer.accept(0, 4);
        timesBiConsumer.accept(10, 0);
        timesBiConsumer.accept(10, 10);
    }

    @Test
    void div() {
        divisionBiConsumer.accept(0, 4);
        divisionBiConsumer.accept(10, 0);
        divisionBiConsumer.accept(10, 10);
        divisionBiConsumer.accept(100, 10);
        divisionBiConsumer.accept(100, 1000);
    }

    @Test
    void allOperations() {
        additionBiConsumer.andThen(differenceBiConsumer).andThen(timesBiConsumer).andThen(divisionBiConsumer).accept(123, 107);
    }
}
