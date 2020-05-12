package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/* @author ravin @date 12-05-2020 @time 15:32 */
@Slf4j
public class DateToLocalDateTest {
    @Test
    void test() {
        Date date = new Date();
        log.info(
                "date   " +
                        date
        );
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        log.info(
                "localDate  " +
                        localDate
        );
        Date date1 = Date.from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        log.info(
                "date1   " +
                        date1
        );
    }
}
