package com.learn.java8.dateTime;

/* @author ravin @date 10-05-2020 @time 21:16 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Slf4j
public class LocalDateLocalTimeLocalDateTimeTest {

    @Test
    void test() {

        log.info(
                Objects.toString(
                        LocalDate.now()
                )
        );
        log.info(
                Objects.toString(
                        LocalTime.now()
                )
        );
        log.info(
                Objects.toString(
                        LocalDateTime.now()
                )
        );
    }
}
