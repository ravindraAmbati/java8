package com.learn.java8.optionals;

/* @author ravin @date 09-05-2020 @time 19:13 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

@Slf4j
public class OptionalOrElseOrElseGetOrElseThrowTest {

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
    void optionalOrElseTest() {
        stringOptional = Optional.of("HELLO");

        log.info(Objects.toString(stringOptional));
        log.info(stringOptional.orElse("EMPTY"));

        stringOptional = Optional.ofNullable(null);

        log.info(Objects.toString(stringOptional));
        log.info(stringOptional.orElse("EMPTY"));

        stringOptional = Optional.empty();

        log.info(Objects.toString(stringOptional));
        log.info(stringOptional.orElse("EMPTY"));
    }

    @Test
    void optionalOrElseGetTest() {
        stringOptional = Optional.of("HELLO");

        log.info(Objects.toString(stringOptional));
        log.info(stringOptional.orElseGet(() -> "EMPTY"));

        stringOptional = Optional.ofNullable(null);

        log.info(Objects.toString(stringOptional));
        log.info(stringOptional.orElseGet(() -> "EMPTY"));

        stringOptional = Optional.empty();

        log.info(Objects.toString(stringOptional));
        log.info(stringOptional.orElseGet(() -> "EMPTY"));
    }

    @Test
    void optionalEmptyTest() {
        stringOptional = Optional.of("HELLO");

        log.info(Objects.toString(stringOptional));
        log.info(stringOptional.orElseThrow(() -> new RuntimeException("EMPTY")));

        stringOptional = Optional.ofNullable(null);

        log.info(Objects.toString(stringOptional));
        try {
            log.info(stringOptional.orElseThrow(() -> new RuntimeException("EMPTY")));
        } catch (RuntimeException runtimeException) {
            log.error("Exception caught is thrown by orElseThrow");
            log.error(runtimeException.getMessage());
        }


        stringOptional = Optional.empty();

        log.info(Objects.toString(stringOptional));
        try {
            log.info(stringOptional.orElseThrow(() -> new RuntimeException("EMPTY")));
        } catch (RuntimeException runtimeException1) {
            log.error("Exception caught is thrown by orElseThrow");
            log.error(runtimeException1.getMessage());
        }
    }
}
