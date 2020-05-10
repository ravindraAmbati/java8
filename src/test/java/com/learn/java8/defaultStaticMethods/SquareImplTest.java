package com.learn.java8.defaultStaticMethods;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
class SquareImplTest {

    private List<Integer> integers = null;
    private Square square = null;

    @BeforeEach
    void setUp() {
        integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        square = new SquareImpl();
    }

    @AfterEach
    void tearDown() {
        integers = null;
    }

    @Test
    void squaresTest() {
        log.info(
                square
                        .squares(integers)
                        .toString()
        );
        log.info(
                String.valueOf(
                        Square.size(integers)
                )
        );
    }
}