package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/* @author ravin @date 12-05-2020 @time 08:33 */
@Slf4j
public class ComparingTimesDurationTest {

    @Test
    void test() {
        LocalTime localTime = LocalTime.of(8, 34, 58, 986532);
        Duration duration = Duration.between(localTime, LocalTime.now());
        log.info(
                duration.toString()
        );
        log.info(
                Duration.of(100, ChronoUnit.MINUTES).toString()
        );
        log.info(
                Duration.ofDays(10).toString()
        );
        log.info(
                Duration.ofHours(25).toString()
        );
        log.info(
                Duration.ofMillis(10000).toString()
        );
        log.info(
                Duration.ofMinutes(135).toString()
        );
        log.info(
                Duration.ofNanos(1234567890).toString()
        );
        log.info(
                Duration.ofSeconds(123, 1234567890).toString()
        );
        log.info(
                Duration.ofSeconds(123).toString()
        );
        log.info(
                Objects.toString(Duration.ofDays(10).toHours())
        );
        log.info(
                Objects.toString(Duration.ofMinutes(135).toNanos())
        );
        log.info(
                Objects.toString(Duration.ofHours(25).toMillis())
        );
        log.info(
                Objects.toString(Duration.ofMillis(10000).toMinutes())
        );
        log.info(
                Objects.toString(Duration.ofMinutes(135).toNanos())
        );
    }
}
