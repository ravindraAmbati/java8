package com.learn.java8.optionals;

/* @author ravin @date 09-05-2020 @time 18:28 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

@Slf4j
public class OptionalOfEmptyOfNullableTest {

    private Optional<String> stringOptional = null;

    @BeforeEach
    void setUp() {
        stringOptional = null;
    }

    @AfterEach
    void tearDown() {
        stringOptional = null;
    }

    @Test
    void optionalOfTest() {
        stringOptional = Optional.of("HELLO");

        log.info(Objects.toString(stringOptional));
        log.info(Objects.toString(stringOptional.isPresent()));
        stringOptional.ifPresent(log::info);

        stringOptional = Optional.of("");

        log.info(Objects.toString(stringOptional));
        log.info(Objects.toString(stringOptional.isPresent()));
        stringOptional.ifPresent(log::info);
    }

    @Test
    void optionalOfNullableTest() {
        stringOptional = Optional.ofNullable("HELLO");

        log.info(Objects.toString(stringOptional));
        log.info(Objects.toString(stringOptional.isPresent()));
        stringOptional.ifPresent(log::info);

        stringOptional = Optional.ofNullable("");

        log.info(Objects.toString(stringOptional));
        log.info(Objects.toString(stringOptional.isPresent()));
        stringOptional.ifPresent(log::info);

        stringOptional = Optional.ofNullable(null);

        log.info(Objects.toString(stringOptional));
        log.info(Objects.toString(stringOptional.isPresent()));
        stringOptional.ifPresent(log::info);
    }

    @Test
    void optionalEmptyTest() {
        stringOptional = Optional.empty();

        log.info(Objects.toString(stringOptional));
        log.info(Objects.toString(stringOptional.isPresent()));
        stringOptional.ifPresent(log::info);
    }
}
