package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* @author ravin @date 12-05-2020 @time 16:01 */
@Slf4j
public class LocalDateParseFormatDateTimeFormatterTest {

    @Test
    void parse() {
        String date = "2020-05-12";
        log.info("date  " + date);
        LocalDate localDate = LocalDate.parse(date);
        log.info("localDate " + localDate);

        String date1 = "2020-05-13";
        log.info("date  " + date1);
        LocalDate localDate1 = LocalDate.parse(date1, DateTimeFormatter.ISO_DATE);
        log.info("localDate " + localDate1);

        String date2 = "20200514";
        log.info("date  " + date2);
        LocalDate localDate2 = LocalDate.parse(date2, DateTimeFormatter.BASIC_ISO_DATE);
        log.info("localDate " + localDate2);

        String date3 = "2020-05-15";
        log.info("date  " + date3);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate3 = LocalDate.parse(date3, dateTimeFormatter);
        log.info("localDate " + localDate3);

        String date4 = "2020||05||16";
        log.info("date  " + date4);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy||MM||dd");
        LocalDate localDate4 = LocalDate.parse(date4, dateTimeFormatter1);
        log.info("localDate " + localDate4);
    }

    @Test
    void formatter() {
        LocalDate localDate = LocalDate.now();
        log.info("DateTimeFormatter.ISO_DATE    " + localDate.format(DateTimeFormatter.ISO_DATE));
        log.info("DateTimeFormatter.BASIC_ISO_DATE    " + localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        log.info("DateTimeFormatter.yyyy-MM-dd    " + localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        log.info("DateTimeFormatter.yyyy||MM||dd    " + localDate.format(DateTimeFormatter.ofPattern("yyyy||MM||dd")));
        ;
    }
}
