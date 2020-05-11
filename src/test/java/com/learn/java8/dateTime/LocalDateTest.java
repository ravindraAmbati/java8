package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/* @author ravin @date 11-05-2020 @time 08:24 */
@Slf4j
public class LocalDateTest {

    @Test
    void test() {

        log.info(
                "Local Date now: " +
                        LocalDate.now()
        );

        log.info(
                "Local Date of: " +
                        LocalDate.of(2020, 5, 11)
        );

        log.info(
                "Local Date of Month: " +
                        LocalDate.of(2020, Month.MAY, 11)
        );

        LocalDate localDate = LocalDate.of(1992, Month.JULY, 23);
        log.info(
                "Local Date of getChronology: " +
                        localDate.getChronology()
        );

        log.info(
                "Local Date of getDayOfMonth: " +
                        localDate.getDayOfMonth()
        );

        log.info(
                "Local Date of getDayOfWeek: " +
                        localDate.getDayOfWeek()
        );

        log.info(
                "Local Date of getDayOfYear: " +
                        localDate.getDayOfYear()
        );

        log.info(
                "Local Date of getMonth: " +
                        localDate.getMonth()
        );

        log.info(
                "Local Date of getEra: " +
                        localDate.getEra()
        );

        log.info(
                "Local Date of getYear: " +
                        localDate.getYear()
        );

        log.info(
                "Local Date of getLong EPOCH_DAY: " +
                        localDate.getLong(ChronoField.EPOCH_DAY)
        );

        log.info(
                "Local Date of getLong PROLEPTIC_MONTH: " +
                        localDate.getLong(ChronoField.PROLEPTIC_MONTH)
        );

        log.info(
                "Local Date of getLong YEAR_OF_ERA: " +
                        localDate.getLong(ChronoField.YEAR_OF_ERA)
        );

        log.info(
                "Local Date modify: plusDays    " +
                        localDate.plusDays(10000)
        );

        log.info(
                "Local Date modify: plusMonths    " +
                        localDate.plusMonths(1000)
        );

        log.info(
                "Local Date modify: plusWeeks    " +
                        localDate.plusWeeks(1500)
        );

        log.info(
                "Local Date modify: plusYears    " +
                        localDate.plusYears(30)
        );

        log.info(
                "Local Date modify: minusDays    " +
                        localDate.minusDays(10000)
        );

        log.info(
                "Local Date modify: minusMonths    " +
                        localDate.minusMonths(1000)
        );

        log.info(
                "Local Date modify: minusMonths    " +
                        localDate.minusWeeks(1500)
        );

        log.info(
                "Local Date modify: minusYears    " +
                        localDate.minusYears(30)
        );

        log.info(
                "Local Date modify: minus  ChronoUnit.CENTURIES  " +
                        localDate.minus(1, ChronoUnit.CENTURIES)
        );

        log.info(
                "Local Date modify: withDayOfMonth    " +
                        localDate.withDayOfMonth(9)
        );

        log.info(
                "Local Date modify: withDayOfYear    " +
                        localDate.withDayOfYear(30)
        );

        log.info(
                "Local Date modify: withMonth    " +
                        localDate.withMonth(8)
        );

        log.info(
                "Local Date modify: with TemporalAdjusters.lastDayOfYear()    " +
                        localDate.with(TemporalAdjusters.lastDayOfYear())
        );

        log.info(
                "Local Date modify: with ChronoField.DAY_OF_MONTH    " +
                        localDate.with(ChronoField.DAY_OF_MONTH, 30)
        );

        log.info(
                "Local Date modify: isLeapYear    " +
                        localDate.isLeapYear()
        );

        log.info(
                "Local Date modify: isBefore    " +
                        localDate.isBefore(LocalDate.now())
        );

        log.info(
                "Local Date modify: isAfter    " +
                        localDate.isAfter(LocalDate.now())
        );

        log.info(
                "Local Date modify: isEqual    " +
                        localDate.isEqual(LocalDate.now())
        );

        log.info(
                "Local Date modify: isSupported ChronoUnit.HOURS    " +
                        localDate.isSupported(ChronoUnit.HOURS)
        );

        log.info(
                "Local Date modify: isSupported ChronoUnit.DAYS   " +
                        localDate.isSupported(ChronoUnit.DAYS)
        );
    }
}
