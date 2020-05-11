package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/* @author ravin @date 11-05-2020 @time 17:05 */
@Slf4j
public class LocalTimeTest {

    @Test
    void test() {

        log.info(
                "Local Time now: " +
                        LocalTime.now()
        );

        log.info(
                "Local Time of: " +
                        LocalTime.of(17, 5, 11)
        );

        log.info(
                "Local Time of Month: " +
                        LocalTime.of(17, 5, 11, 9999)
        );

        LocalTime localTime = LocalTime.of(17, 5, 12, 235);
        log.info(
                "Local Time of get ChronoField.CLOCK_HOUR_OF_DAY: " +
                        localTime.get(ChronoField.CLOCK_HOUR_OF_DAY)
        );

        log.info(
                "Local Time of getHour: " +
                        localTime.getHour()
        );

        log.info(
                "Local Time of get ChronoField.HOUR_OF_DAY: " +
                        localTime.getLong(ChronoField.HOUR_OF_DAY)
        );

        log.info(
                "Local Time of getNano: " +
                        localTime.getNano()
        );

        log.info(
                "Local Time of getSecond: " +
                        localTime.getSecond()
        );

        log.info(
                "Local Time of toString: " +
                        localTime.toString()
        );

        log.info(
                "Local Time of isAfter: " +
                        localTime.isAfter(LocalTime.now())
        );

        log.info(
                "Local Time of isBefore: " +
                        localTime.isBefore(LocalTime.now())
        );

        log.info(
                "Local Time of isSupported ChronoField.PROLEPTIC_MONTH: " +
                        localTime.isSupported(ChronoField.PROLEPTIC_MONTH)
        );

        log.info(
                "Local Time of isSupported ChronoField.NANO_OF_DAY: " +
                        localTime.isSupported(ChronoField.NANO_OF_DAY)
        );

        log.info(
                "Local Time modify: plusHours    " +
                        localTime.plusHours(1)
        );

        log.info(
                "Local Time modify: plusMinutes    " +
                        localTime.plusMinutes(100)
        );

        log.info(
                "Local Time modify: plusNanos    " +
                        localTime.plusNanos(150000)
        );

        log.info(
                "Local Time modify: plusSeconds    " +
                        localTime.plusSeconds(3000)
        );

        log.info(
                "Local Time modify: minusHours    " +
                        localTime.minusHours(1)
        );

        log.info(
                "Local Time modify: minusMinutes    " +
                        localTime.minusMinutes(100)
        );

        log.info(
                "Local Time modify: minusMonths    " +
                        localTime.minusSeconds(1500)
        );

        log.info(
                "Local Time modify: minusYears    " +
                        localTime.minusNanos(30000)
        );

        log.info(
                "Local Time modify: minus  ChronoUnit.MINUTES  " +
                        localTime.minus(100, ChronoUnit.MINUTES)
        );

        log.info(
                "Local Time modify: withHour    " +
                        localTime.withHour(9)
        );

        log.info(
                "Local Time modify: withMinute    " +
                        localTime.withMinute(30)
        );

        log.info(
                "Local Time modify: withSecond    " +
                        localTime.withSecond(8)
        );

        log.info(
                "Local Time modify: with ChronoField.HOUR_OF_DAY    " +
                        localTime.with(ChronoField.HOUR_OF_DAY, 10)
        );

        log.info(
                "Local Time modify: isBefore    " +
                        localTime.isBefore(LocalTime.now())
        );

        log.info(
                "Local Time modify: isAfter    " +
                        localTime.isAfter(LocalTime.now())
        );

    }
}
