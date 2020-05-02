package com.learn.java8.lambdasAndFunctionalInterfaces;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

@Slf4j
public class ConsumerImpl {

    Consumer<String> uppercaseStringConsumer = null;

    @BeforeEach
    void setUp() {
        uppercaseStringConsumer = null;
    }

    @AfterEach
    void tearDown() {
        uppercaseStringConsumer = null;
    }

    @Test
    void accept() {
        uppercaseStringConsumer = s -> log.info(s.toUpperCase());
        uppercaseStringConsumer.accept("java8");
    }

}
