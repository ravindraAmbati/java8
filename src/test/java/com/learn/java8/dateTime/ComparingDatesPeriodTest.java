package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/* @author ravin @date 12-05-2020 @time 08:15 */
@Slf4j
public class ComparingDatesPeriodTest {

    @Test
    void test() {
        LocalDate localDate = LocalDate.of(1992, 7, 23);
        Period period = localDate.until(LocalDate.now());
        log.info(
                period.toString()
        );
        Period age = Period.between(localDate, LocalDate.now());
        log.info(
                age.toString()
        );
        log.info(
                Period.of(10, 10, 10).toString()
        );
        log.info(
                Period.ofDays(10).toString()
        );
        log.info(
                Period.ofMonths(10).toString()
        );
        log.info(
                Period.ofYears(10).toString()
        );
        log.info(
                Period.ofWeeks(10).toString()
        );
        log.info(
                Objects.toString(
                        Period.ofYears(10).toTotalMonths()
                )
        );

    }
}
