package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

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
    }
}
