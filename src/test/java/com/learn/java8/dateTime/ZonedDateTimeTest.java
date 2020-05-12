package com.learn.java8.dateTime;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Objects;

/* @author ravin @date 12-05-2020 @time 14:36 */
@Slf4j
public class ZonedDateTimeTest {

    @Test
    void test() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        log.info(
                zonedDateTime.toString()
        );
        log.info(
                zonedDateTime.getOffset().toString()
        );
        log.info(
                zonedDateTime.getZone().toString()
        );
//        ZoneId.getAvailableZoneIds()
//                .forEach(
//                        log::info
//                );
        log.info(
                Objects.toString(
                        ZoneId.getAvailableZoneIds().size()
                )
        );
        log.info("ZonedDateTime-ZonedId");
        log.info("Asia/Kabul            " +
                ZonedDateTime.now(ZoneId.of("Asia/Kabul"))
        );
        log.info("America/New_York      " +
                ZonedDateTime.now(ZoneId.of("America/New_York"))
        );
        log.info("Hongkong              " +
                ZonedDateTime.now(ZoneId.of("Hongkong"))
        );
        log.info("Asia/Katmandu         " +
                ZonedDateTime.now(ZoneId.of("Asia/Katmandu"))
        );
        log.info("ZonedDateTime-Clock-ZonedId");
        log.info("Asia/Kabul            " +
                ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Kabul")))
        );
        log.info("America/New_York      " +
                ZonedDateTime.now(Clock.system(ZoneId.of("America/New_York")))
        );
        log.info("Hongkong              " +
                ZonedDateTime.now(Clock.system(ZoneId.of("Hongkong")))
        );
        log.info("Asia/Katmandu         " +
                ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Katmandu")))
        );
        log.info("LocalDateTime");
        log.info("Asia/Kabul            " +
                LocalDateTime.now(ZoneId.of("Asia/Kabul"))
        );
        log.info("America/New_York      " +
                LocalDateTime.now(ZoneId.of("America/New_York"))
        );
        log.info("Hongkong              " +
                LocalDateTime.now(ZoneId.of("Hongkong"))
        );
        log.info("Asia/Katmandu         " +
                LocalDateTime.now(ZoneId.of("Asia/Katmandu"))
        );
        log.info("Asia/Kabul            " +
                LocalDateTime.now(Clock.system(ZoneId.of("Asia/Kabul")))
        );
        log.info("America/New_York      " +
                LocalDateTime.now(Clock.system(ZoneId.of("America/New_York")))
        );
        log.info("Hongkong              " +
                LocalDateTime.now(Clock.system(ZoneId.of("Hongkong")))
        );
        log.info("Asia/Katmandu         " +
                LocalDateTime.now(Clock.system(ZoneId.of("Asia/Katmandu")))
        );
        log.info("LocalDate");
        log.info("Asia/Kabul            " +
                LocalDate.now(ZoneId.of("Asia/Kabul"))
        );
        log.info("America/New_York      " +
                LocalDate.now(ZoneId.of("America/New_York"))
        );
        log.info("Hongkong              " +
                LocalDate.now(ZoneId.of("Hongkong"))
        );
        log.info("Asia/Katmandu         " +
                LocalDate.now(ZoneId.of("Asia/Katmandu"))
        );
        log.info("Asia/Kabul            " +
                LocalDate.now(Clock.system(ZoneId.of("Asia/Kabul")))
        );
        log.info("America/New_York      " +
                LocalDate.now(Clock.system(ZoneId.of("America/New_York")))
        );
        log.info("Hongkong              " +
                LocalDate.now(Clock.system(ZoneId.of("Hongkong")))
        );
        log.info("Asia/Katmandu         " +
                LocalDate.now(Clock.system(ZoneId.of("Asia/Katmandu")))
        );
        log.info("LocalTime");
        log.info("Asia/Kabul            " +
                LocalTime.now(ZoneId.of("Asia/Kabul"))
        );
        log.info("America/New_York      " +
                LocalTime.now(ZoneId.of("America/New_York"))
        );
        log.info("Hongkong              " +
                LocalTime.now(ZoneId.of("Hongkong"))
        );
        log.info("Asia/Katmandu         " +
                LocalTime.now(ZoneId.of("Asia/Katmandu"))
        );
        log.info("Asia/Kabul            " +
                LocalTime.now(Clock.system(ZoneId.of("Asia/Kabul")))
        );
        log.info("America/New_York      " +
                LocalTime.now(Clock.system(ZoneId.of("America/New_York")))
        );
        log.info("Hongkong              " +
                LocalTime.now(Clock.system(ZoneId.of("Hongkong")))
        );
        log.info("Asia/Katmandu         " +
                LocalTime.now(Clock.system(ZoneId.of("Asia/Katmandu")))
        );
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        log.info("localDateTime     " +
                localDateTime.toString()
        );
        Instant instant = Instant.now(Clock.system(ZoneId.systemDefault()));
        log.info("Instant      " +
                instant.toString()
        );
    }
}
