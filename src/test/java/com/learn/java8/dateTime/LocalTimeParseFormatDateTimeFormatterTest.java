package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* @author ravin @time 12-05-2020 @time 16:14 */
@Slf4j
public class LocalTimeParseFormatDateTimeFormatterTest {

    @Test
    void parse() {
        String time = "16:15:06";
        log.info("time  " + time);
        LocalTime localTime = LocalTime.parse(time);
        log.info("localTime " + localTime);

        String time1 = "17:15:06";
        log.info("time  " + time1);
        LocalTime localTime1 = LocalTime.parse(time1, DateTimeFormatter.ISO_TIME);
        log.info("localTime " + localTime1);

        String time2 = "20::05::15";
        log.info("time  " + time2);
        LocalTime localTime2 = LocalTime.parse(time2, DateTimeFormatter.ofPattern("HH::mm::ss"));
        log.info("localTime " + localTime2);

        String time3 = "20-05-15";
        log.info("time  " + time3);
        DateTimeFormatter timeTimeFormatter = DateTimeFormatter.ofPattern("HH-mm-ss");
        LocalTime localTime3 = LocalTime.parse(time3, timeTimeFormatter);
        log.info("localTime " + localTime3);

        String time4 = "21||05||16";
        log.info("time  " + time4);
        DateTimeFormatter timeTimeFormatter1 = DateTimeFormatter.ofPattern("HH||mm||ss");
        LocalTime localTime4 = LocalTime.parse(time4, timeTimeFormatter1);
        log.info("localTime " + localTime4);
    }

    @Test
    void formatter() {
        LocalTime localTime = LocalTime.now();
        log.info("DateTimeFormatter.ISO_DATE    " + localTime.format(DateTimeFormatter.ISO_TIME));
        log.info("DateTimeFormatter.ISO_DATE    " + localTime.format(DateTimeFormatter.ofPattern("HH::mm::ss")));
        log.info("DateTimeFormatter.ISO_DATE    " + localTime.format(DateTimeFormatter.ofPattern("HH-mm-ss")));
        log.info("DateTimeFormatter.ISO_DATE    " + localTime.format(DateTimeFormatter.ofPattern("HH||mm||ss")));
        ;
    }
}
