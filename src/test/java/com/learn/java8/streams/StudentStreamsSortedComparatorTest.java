package com.learn.java8.streams;

/* @author ravin @date 05-05-2020 @time 09:57 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StudentStreamsSortedComparatorTest {

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
    void printStudentsSortedByName() {
        log.info(
                students.stream()
                        .sorted(Comparator.comparing(Student::getName))
                        .collect(Collectors.toList())
                        .toString()
        );
    }

    @Test
    void printStudentsSortedByNameAndGrade() {
        log.info(
                students.stream()
                        .sorted(Comparator.comparing(Student::getName))
                        .sorted(Comparator.comparing(Student::getGrade))
                        .collect(Collectors.toList())
                        .toString()
        );
    }

    @Test
    void printStudentsSortedByGpaAscLambda() {
        log.info(
                students.stream()
                        .sorted((o1, o2) -> {
                            return Double.compare(o1.getGpa(), o2.getGpa());
                        })
                        .collect(Collectors.toList())
                        .toString()
        );
    }

    @Test
    void printStudentsSortedByGpaDescLambda() {
        log.info(
                students.stream()
                        .sorted((o1, o2) -> {
                            return Double.compare(o2.getGpa(), o1.getGpa());
                        })
                        .collect(Collectors.toList())
                        .toString()
        );
    }

    @Test
    void printStudentsSortedByGpaAscMethodReference() {
        log.info(
                students.stream()
                        .sorted(Comparator.comparing(Student::getGpa))
                        .collect(Collectors.toList())
                        .toString()
        );
    }

    @Test
    void printStudentsSortedByGpaDescMethodReference() {
        log.info(
                students.stream()
                        .sorted(Comparator.comparing(Student::getGpa).reversed())
                        .collect(Collectors.toList())
                        .toString()
        );
    }

    @Test
    void printStudentsMaxGpa() {
        log.info(
                students.stream()
                        .max(Comparator.comparingDouble(Student::getGpa))
                        .toString()
        );
    }

    @Test
    void printStudentsMinGpa() {
        log.info(
                students.stream()
                        .min(Comparator.comparingDouble(Student::getGpa))
                        .toString()
        );
    }
}
