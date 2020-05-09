package com.learn.java8.streams;

/* @author ravin @date 04-05-2020 @time 21:40 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Slf4j
public class StudentStreamsMapAndFlatMapTest {

    private List<Student> students = null;
    private Predicate<Student> gradeGreaterThan3 = null;
    private Predicate<Student> gpaGreaterThan6 = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        gradeGreaterThan3 = s -> s.getGrade() > 3;
        gpaGreaterThan6 = s -> s.getGpa() > 6.0d;
    }

    @AfterEach
    void tearDown() {
        students = null;
        gradeGreaterThan3 = null;
        gpaGreaterThan6 = null;
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

    @Test
    void printActivitiesCount() {
        log.info(Objects.toString(students.stream()
                .map(Student::getActivities)
                .flatMap(Collection::stream)
                .distinct()
                .count()));
    }

    @Test
    void printSortedActivities() {
        log.info(students.stream()
                .map(Student::getActivities)
                .flatMap(Collection::stream)
                .distinct()
                .sorted()
                .collect(toList())
                .toString());
    }

    @Test
    void printGpas() {
        log.info(students.stream()
                .map(Student::getGpa)
                .sorted()
                .distinct()
                .collect(toList())
                .toString());
    }

    @Test
    void countStudentsGradeGreaterThan3AndGpaGreaterThan7_5() {
        Long count =
                students.stream()
                        .filter(gradeGreaterThan3)
                        .filter(gpaGreaterThan6)
                        .count();
        log.info(Objects.toString(count));
    }

}
