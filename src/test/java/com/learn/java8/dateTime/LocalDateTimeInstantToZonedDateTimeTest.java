package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;

/* @author ravin @date 12-05-2020 @time 15:15 */
@Slf4j
public class LocalDateTimeInstantToZonedDateTimeTest {
    @Test
    void test() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(
                "localDateTime  " +
                        localDateTime
        );
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Kabul"));
        log.info(
                "zonedDateTime  Asia/Kabul  " +
                        zonedDateTime
        );
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHoursMinutes(-5, -30));
        log.info(
                "offsetDateTime  -5:30  " +
                        offsetDateTime
        );
        Instant instant = Instant.now();
        log.info(
                "instant    " +
                        instant
        );
        ZonedDateTime zonedDateTimeInstant = instant.atZone(ZoneId.of("Asia/Kabul"));
        log.info(
                "instant    zonedDateTime  Asia/Kabul   " +
                        zonedDateTime
        );
        OffsetDateTime offsetDateTimeInstant = instant.atOffset(ZoneOffset.ofHoursMinutes(-5, -30));
        log.info(
                "instant    offsetDateTime  -5:30   " +
                        offsetDateTime
        );
    }
}
