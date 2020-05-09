package com.learn.java8.streams.terminalOperations;

/* @author ravin @date 09-05-2020 @time 11:28 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StreamsStudentSummingDoubleAverageDoubleTest {

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
    void printStudentSumGpaTest() {
        log.info(
                String.valueOf(
                        students
                                .stream()
                                .collect(Collectors.summingDouble(Student::getGpa))
                )
        );
    }

    @Test
    void printStudentAvgGpaTest() {
        log.info(
                String.valueOf(
                        students
                                .stream()
                                .collect(Collectors.averagingDouble(Student::getGpa))
                )
        );
    }
}
