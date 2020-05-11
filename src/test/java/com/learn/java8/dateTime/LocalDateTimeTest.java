package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/* @author ravin @date 11-05-2020 @time 20:36 */
@Slf4j
public class LocalDateTimeTest {

    @Test
    void test() {

        log.info(
                "Local Date now: " +
                        LocalDateTime.now()
        );

        log.info(
                "Local Date of: " +
                        LocalDateTime.of(LocalDate.now(), LocalTime.now())
        );

        log.info(
                "Local Date of: " +
                        LocalDateTime.of(2020, 5, 11, 12, 12)
        );

        log.info(
                "Local Date of Month: " +
                        LocalDateTime.of(2020, Month.MAY, 11, 12, 12)
        );

        LocalDateTime localDateTime = LocalDateTime.of(1992, Month.JULY, 23, 9, 18, 56, 987654);
        log.info(
                "Local Date of getChronology: " +
                        localDateTime.getChronology()
        );

        log.info(
                "Local Date of getDayOfMonth: " +
                        localDateTime.getDayOfMonth()
        );

        log.info(
                "Local Date of getDayOfWeek: " +
                        localDateTime.getDayOfWeek()
        );

        log.info(
                "Local Date of getDayOfYear: " +
                        localDateTime.getDayOfYear()
        );

        log.info(
                "Local Date of getMonth: " +
                        localDateTime.getMonth()
        );

        log.info(
                "Local Date of getYear: " +
                        localDateTime.getYear()
        );

        log.info(
                "Local Date of getLong EPOCH_DAY: " +
                        localDateTime.getLong(ChronoField.EPOCH_DAY)
        );

        log.info(
                "Local Date of getLong PROLEPTIC_MONTH: " +
                        localDateTime.getLong(ChronoField.PROLEPTIC_MONTH)
        );

        log.info(
                "Local Date of getLong YEAR_OF_ERA: " +
                        localDateTime.getLong(ChronoField.YEAR_OF_ERA)
        );

        log.info(
                "Local Date modify: plusDays    " +
                        localDateTime.plusDays(10000)
        );

        log.info(
                "Local Date modify: plusMonths    " +
                        localDateTime.plusMonths(1000)
        );

        log.info(
                "Local Date modify: plusWeeks    " +
                        localDateTime.plusWeeks(1500)
        );

        log.info(
                "Local Date modify: plusYears    " +
                        localDateTime.plusYears(30)
        );

        log.info(
                "Local Date modify: minusDays    " +
                        localDateTime.minusDays(10000)
        );

        log.info(
                "Local Date modify: minusMonths    " +
                        localDateTime.minusMonths(1000)
        );

        log.info(
                "Local Date modify: minusMonths    " +
                        localDateTime.minusWeeks(1500)
        );

        log.info(
                "Local Date modify: minusYears    " +
                        localDateTime.minusYears(30)
        );

        log.info(
                "Local Date modify: minus  ChronoUnit.CENTURIES  " +
                        localDateTime.minus(1, ChronoUnit.CENTURIES)
        );

        log.info(
                "Local Date modify: withDayOfMonth    " +
                        localDateTime.withDayOfMonth(9)
        );

        log.info(
                "Local Date modify: withDayOfYear    " +
                        localDateTime.withDayOfYear(30)
        );

        log.info(
                "Local Date modify: withMonth    " +
                        localDateTime.withMonth(8)
        );

        log.info(
                "Local Date modify: with TemporalAdjusters.lastDayOfYear()    " +
                        localDateTime.with(TemporalAdjusters.lastDayOfYear())
        );

        log.info(
                "Local Date modify: with ChronoField.DAY_OF_MONTH    " +
                        localDateTime.with(ChronoField.DAY_OF_MONTH, 30)
        );

        log.info(
                "Local Date modify: isBefore    " +
                        localDateTime.isBefore(LocalDateTime.now())
        );

        log.info(
                "Local Date modify: isAfter    " +
                        localDateTime.isAfter(LocalDateTime.now())
        );

        log.info(
                "Local Date modify: isEqual    " +
                        localDateTime.isEqual(LocalDateTime.now())
        );

        log.info(
                "Local Date modify: isSupported ChronoUnit.HOURS    " +
                        localDateTime.isSupported(ChronoUnit.HOURS)
        );

        log.info(
                "Local Date modify: isSupported ChronoUnit.DAYS   " +
                        localDateTime.isSupported(ChronoUnit.DAYS)
        );
        log.info(
                "Local Time of get ChronoField.CLOCK_HOUR_OF_DAY: " +
                        localDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY)
        );

        log.info(
                "Local Time of getHour: " +
                        localDateTime.getHour()
        );

        log.info(
                "Local Time of get ChronoField.HOUR_OF_DAY: " +
                        localDateTime.getLong(ChronoField.HOUR_OF_DAY)
        );

        log.info(
                "Local Time of getNano: " +
                        localDateTime.getNano()
        );

        log.info(
                "Local Time of getSecond: " +
                        localDateTime.getSecond()
        );

        log.info(
                "Local Time of toString: " +
                        localDateTime.toString()
        );

        log.info(
                "Local Time of isAfter: " +
                        localDateTime.isAfter(LocalDateTime.now())
        );

        log.info(
                "Local Time of isBefore: " +
                        localDateTime.isBefore(LocalDateTime.now())
        );

        log.info(
                "Local Time of isSupported ChronoField.PROLEPTIC_MONTH: " +
                        localDateTime.isSupported(ChronoField.PROLEPTIC_MONTH)
        );

        log.info(
                "Local Time of isSupported ChronoField.NANO_OF_DAY: " +
                        localDateTime.isSupported(ChronoField.NANO_OF_DAY)
        );

        log.info(
                "Local Time modify: plusHours    " +
                        localDateTime.plusHours(1)
        );

        log.info(
                "Local Time modify: plusMinutes    " +
                        localDateTime.plusMinutes(100)
        );

        log.info(
                "Local Time modify: plusNanos    " +
                        localDateTime.plusNanos(150000)
        );

        log.info(
                "Local Time modify: plusSeconds    " +
                        localDateTime.plusSeconds(3000)
        );

        log.info(
                "Local Time modify: minusHours    " +
                        localDateTime.minusHours(1)
        );

        log.info(
                "Local Time modify: minusMinutes    " +
                        localDateTime.minusMinutes(100)
        );

        log.info(
                "Local Time modify: minusMonths    " +
                        localDateTime.minusSeconds(1500)
        );

        log.info(
                "Local Time modify: minusYears    " +
                        localDateTime.minusNanos(30000)
        );

        log.info(
                "Local Time modify: minus  ChronoUnit.MINUTES  " +
                        localDateTime.minus(100, ChronoUnit.MINUTES)
        );

        log.info(
                "Local Time modify: withHour    " +
                        localDateTime.withHour(9)
        );

        log.info(
                "Local Time modify: withMinute    " +
                        localDateTime.withMinute(30)
        );

        log.info(
                "Local Time modify: withSecond    " +
                        localDateTime.withSecond(8)
        );

        log.info(
                "Local Time modify: with ChronoField.HOUR_OF_DAY    " +
                        localDateTime.with(ChronoField.HOUR_OF_DAY, 10)
        );
    }
}
