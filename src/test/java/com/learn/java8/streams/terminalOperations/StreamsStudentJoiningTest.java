package com.learn.java8.streams.terminalOperations;

/* @author ravin @date 07-05-2020 @time 20:25 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.joining;

@Slf4j
public class StreamsStudentJoiningTest {

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
    void print() {

        log.info(
                students
                        .stream()
                        .map(Student::getName)
                        .collect(joining())
        );
        log.info(
                students
                        .stream()
                        .map(Student::getName)
                        .collect(joining("||"))
        );
        log.info(
                students
                        .stream()
                        .map(Student::getName)
                        .collect(joining(",", "[", "]"))
        );

    }
}
