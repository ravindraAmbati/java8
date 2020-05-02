package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 15:56 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

@Slf4j
public class ConsumerImplTest {

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
