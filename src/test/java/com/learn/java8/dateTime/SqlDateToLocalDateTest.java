package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

/* @author ravin @date 12-05-2020 @time 15:35 */
@Slf4j
public class SqlDateToLocalDateTest {
    @Test
    void test() {
        Date date = new Date(System.currentTimeMillis());
        log.info(
                "date   " +
                        date
        );
        LocalDate localDate = date.toLocalDate();
        log.info(
                "localDate  " +
                        localDate
        );
        Date date1 = Date.valueOf(localDate);
        log.info(
                "date1  " +
                        date1
        );
    }
}
