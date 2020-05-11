package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/* @author ravin @date 11-05-2020 @time 20:47 */
@Slf4j
public class LocalDateAndLocalTimeToLocalDateTimeAndViceVersaTest {

    @Test
    void test() {
        LocalDate localDate = LocalDate.now();
        log.info(
                "Local Date:    " +
                        localDate
        );

        log.info(
                "Local Date atTime:LocalDateTime    " +
                        localDate.atTime(10, 51, 59, 987654)
        );

        LocalTime localTime = LocalTime.now();
        log.info(
                "Local Time:    " +
                        localTime
        );

        log.info(
                "Local Time atDate:LocalDateTime    " +
                        localTime.atDate(LocalDate.now())
        );

        LocalDateTime localDateTime = LocalDateTime.now();

        log.info(
                "Local Date Time:    " +
                        localDateTime
        );

        log.info(
                "Local Date Time toLocalDate:LocalDate    " +
                        localDateTime.toLocalDate()
        );

        log.info(
                "Local Date Time toLocalTime:LocalTime    " +
                        localDateTime.toLocalTime()
        );
    }
}
