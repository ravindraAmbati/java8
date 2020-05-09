package com.learn.java8.streams.terminalOperations;

/* @author ravin @date 09-05-2020 @time 10:46 */

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
public class StreamsStudentMinByMaxByTest {

    private List<Student> students = null;
    private Comparator<Student> gpaComparator = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        gpaComparator = Comparator.comparing(Student::getGpa);
    }

    @AfterEach
    void tearDown() {
        students = null;
        gpaComparator = null;
    }

    @Test
    void printStudentMinByGradeTest() {
        log.info(
                students
                        .stream()
                        .collect(Collectors.minBy(gpaComparator))
                        .orElse(null)
                        .toString()
        );
    }

    @Test
    void printStudentMaxByGradeTest() {
        log.info(
                students
                        .stream()
                        .collect(Collectors.maxBy(gpaComparator))
                        .orElse(null)
                        .toString()
        );
    }
}
