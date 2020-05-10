package com.learn.java8.defaultStaticMethods;

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/* @author ravin @date 10-05-2020 @time 10:17 */
@Slf4j
public class DefaultMethodsTest {

    private List<String> names = null;
    private List<String> namesNull = null;

    @BeforeEach
    void setUp() {
        names = StudentBootstrap.getStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        namesNull = Arrays.asList("Log", "Mike", "Tech", "Intel", null);
    }

    @AfterEach
    void tearDown() {
        names = null;
        namesNull = null;
    }

    @Test
    void collectionsSortTest() {
        log.info(names.toString());
        Collections.sort(names);
        log.info(names.toString());
    }

    @Test
    void listSortTest() {
        log.info(names.toString());
        names.sort(Comparator.naturalOrder());
        log.info(names.toString());
        names.sort(Comparator.reverseOrder());
        log.info(names.toString());
    }

    @Test
    void sortNullsFirstTest() {
        log.info(namesNull.toString());
        namesNull.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        log.info(namesNull.toString());
        namesNull.sort(Comparator.nullsFirst(Comparator.reverseOrder()));
    }

    @Test
    void sortNullsLastTest() {
        log.info(namesNull.toString());
        namesNull.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        log.info(namesNull.toString());
        namesNull.sort(Comparator.nullsLast(Comparator.reverseOrder()));
    }
}
