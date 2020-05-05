package com.learn.java8.streams;

/* @author ravin @date 04-05-2020 @time 21:40 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Slf4j
public class StudentMapAndFlatMapStreams {

    private List<Student> students = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
    }

    @AfterEach
    void tearDown() {
        students = null;
    }

    @Test
    void printStudentNames() {
        log.info(students.stream()
                .map(Student::getName)
                .collect(toList())
                .toString());
    }

    @Test
    void printStudentNameAndTheirActivities() {
        log.info(students.stream()
                .map(s -> {
                    Map<String, List<String>> map = new HashMap<String, List<String>>();
                    map.put(s.getName(), s.getActivities());
                    return map;
                })
                .collect(toList())
                .toString());
    }

    @Test
    void printActivities() {
        log.info(students.stream()
                .map(Student::getActivities)
                .flatMap(Collection::stream)
                .distinct()
                .collect(toList())
                .toString());
    }

}
