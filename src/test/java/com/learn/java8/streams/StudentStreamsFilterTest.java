package com.learn.java8.streams;

/* @author ravin @date 05-05-2020 @time 10:23 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

@Slf4j
public class StudentStreamsFilterTest {

    private static final String MALE = "MALE";
    private List<Student> students = null;
    private Predicate<Student> gradeGreaterThan3 = null;
    private Predicate<Student> gpaGreaterThan6 = null;
    private Predicate<Student> genderMale = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        gradeGreaterThan3 = s -> s.getGrade() > 3;
        gpaGreaterThan6 = s -> s.getGpa() > 6.0d;
        genderMale = s -> MALE.equalsIgnoreCase(s.getGender());

    }

    @AfterEach
    void tearDown() {
        students = null;
        gradeGreaterThan3 = null;
        gpaGreaterThan6 = null;
    }

    @Test
    void printMaleStudents() {
        log.info(
                students.stream()
                        .filter(genderMale)
                        .collect(toList())
                        .toString()
        );
    }

    @Test
    void printGpaGreaterThan6Students() {
        log.info(
                students.stream()
                        .filter(gpaGreaterThan6)
                        .collect(toList())
                        .toString()
        );
    }

    @Test
    void printGradeGreaterThan3Students() {
        log.info(
                students.stream()
                        .filter(gradeGreaterThan3)
                        .collect(toList())
                        .toString()
        );
    }

    @Test
    void printFemaleStudents() {
        log.info(
                students.stream()
                        .filter(genderMale.negate())
                        .collect(toList())
                        .toString()
        );
    }

    @Test
    void printFemaleGradeGreaterThan3GpaGreaterThan6Students() {
        log.info(
                students.stream()
                        .filter(genderMale.negate())
                        .filter(gradeGreaterThan3)
                        .filter(gpaGreaterThan6)
                        .collect(toList())
                        .toString()
        );
    }
}
