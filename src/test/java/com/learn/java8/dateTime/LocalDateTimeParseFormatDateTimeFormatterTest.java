package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* @author ravin @date 12-05-2020 @dateTime 16:23 */
@Slf4j
public class LocalDateTimeParseFormatDateTimeFormatterTest {

    @Test
    void parse() {
        String dateTime = "2020-05-12T16:15:06";
        log.info("dateTime  " + dateTime);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        log.info("localTime " + localDateTime);

        String dateTime1 = "2020-05-12T17:15:06";
        log.info("dateTime  " + dateTime1);
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime1, DateTimeFormatter.ISO_DATE_TIME);
        log.info("localTime " + localDateTime1);

        String dateTime2 = "2020::05::12 20::05::15";
        log.info("dateTime  " + dateTime2);
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime2, DateTimeFormatter.ofPattern("yyyy::MM::dd HH::mm::ss"));
        log.info("localTime " + localDateTime2);

        String dateTime3 = "2020-05-12 20-05-15";
        log.info("dateTime  " + dateTime3);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH-mm-ss");
        LocalDateTime localDateTime3 = LocalDateTime.parse(dateTime3, dateTimeFormatter);
        log.info("localTime " + localDateTime3);

        String dateTime4 = "2020|05|12 21||05||16";
        log.info("dateTime  " + dateTime4);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy|MM|dd HH||mm||ss");
        LocalDateTime localTime4 = LocalDateTime.parse(dateTime4, dateTimeFormatter1);
        log.info("localTime " + localTime4);
    }

    @Test
    void formatter() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("DateTimeFormatter.ISO_DATE_TIME                           " + localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        log.info("DateTimeFormatter.yyyy:::MM:::dd HH::mm::ss               " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy:::MM:::dd HH::mm::ss")));
        log.info("DateTimeFormatter.yyy-MM-dd HH-mm-ss                      " + localDateTime.format(DateTimeFormatter.ofPattern("yyy-MM-dd HH-mm-ss")));
        log.info("DateTimeFormatter.yyyy|MM|dd HH||mm||ss                   " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy|MM|dd HH||mm||ss")));
        log.info("DateTimeFormatter.ISO_DATE                                " + localDateTime.format(DateTimeFormatter.ISO_TIME));
        log.info("DateTimeFormatter.ISO_DATE                                " + localDateTime.format(DateTimeFormatter.ofPattern("HH::mm::ss")));
        log.info("DateTimeFormatter.ISO_DATE                                " + localDateTime.format(DateTimeFormatter.ofPattern("HH-mm-ss")));
        log.info("DateTimeFormatter.ISO_DATE                                " + localDateTime.format(DateTimeFormatter.ofPattern("HH||mm||ss")));
        log.info("DateTimeFormatter.ISO_DATE                                " + localDateTime.format(DateTimeFormatter.ISO_DATE));
        log.info("DateTimeFormatter.BASIC_ISO_DATE                          " + localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
        log.info("DateTimeFormatter.yyyy-MM-dd                              " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        log.info("DateTimeFormatter.yyyy||MM||dd                            " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy||MM||dd")));
    }
}
