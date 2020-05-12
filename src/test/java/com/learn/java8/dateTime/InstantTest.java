package com.learn.java8.dateTime;

/* @author ravin @date 12-05-2020 @time 09:04 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

@Slf4j
public class InstantTest {

    @Test
    void test() {
        Instant instant = Instant.now();
        log.info(
                instant.toString()
        );
        log.info(
                Instant.ofEpochSecond(0, 123465789).toString()
        );
        log.info(
                Instant.ofEpochSecond(10000).toString()
        );
        log.info(
                Instant.ofEpochMilli(1023).toString()
        );
        log.info(
                Objects.toString(
                        instant.getNano()
                )
        );
        log.info(
                Objects.toString(
                        instant.getEpochSecond()
                )
        );
        Duration duration = Duration.between(instant, Instant.now());
        log.info(
                Objects.toString(
                        duration.toNanos()
                )
        );
    }
}
