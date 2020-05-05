package com.learn.java8.streams;

/* @author ravin @date 05-05-2020 @time 19:43 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class StudentStreamsFindAnyFindFirst {

    private List<Student> students = null;
    private Predicate<Student> studentPredicate = null;


    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentPredicate = s -> s.getGrade() >= 3;

    }

    @AfterEach
    void tearDown() {
        students = null;
        studentPredicate = null;
    }

    @Test
    void printStudents() {
        log.info(
                String.valueOf(
                        students.stream()
                                .sorted(Comparator.comparingDouble(Student::getGpa))
                                .findAny()
                                .orElse(null)
                )
        );

        log.info(
                String.valueOf(
                        students.stream()
                                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                                .findFirst()
                                .orElse(null)
                )
        );
        log.info(
                String.valueOf(
                        students.stream()
                                .sorted(Comparator.comparingDouble(Student::getGpa))
                                .findFirst()
                                .orElse(null)
                )
        );

        log.info(
                String.valueOf(
                        students.stream()
                                .findAny()
                                .orElse(null)
                )
        );

        log.info(
                String.valueOf(
                        students.stream()
                                .findFirst()
                                .orElse(null)
                )
        );
        log.info(
                String.valueOf(
                        students.stream()
                                .findFirst()
                                .orElse(null)
                )
        );
    }
}
