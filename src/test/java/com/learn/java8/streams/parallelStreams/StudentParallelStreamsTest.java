package com.learn.java8.streams.parallelStreams;

/* @author ravin @date 09-05-2020 @time 16:51 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.joining;

@Slf4j
public class StudentParallelStreamsTest {

    private long startTime = 0L;
    private long endTime = 0L;
    private List<Student> students = null;

    @BeforeEach
    void setUp() {
        log.info("Available Processors in this machine  " + Runtime.getRuntime().availableProcessors());
        startTime = System.currentTimeMillis();
        students = StudentBootstrap.getStudents();
    }

    @AfterEach
    void tearDown() {
        endTime = System.currentTimeMillis();
        log.info("total ms taken:" + (endTime - startTime));
        startTime = 0L;
        endTime = 0L;
        students = null;
    }

    @Test
    void streams() {
        log.info(
                students
                        .stream()
                        .map(Student::getActivities)
                        .flatMap(Collection::stream)
                        .distinct()
                        .sorted()
                        .collect(joining("||", "[", "]"))
        );

    }

    @Test
    void parallelStreams() {
        log.info(
                students
                        .stream()
                        .parallel()
                        .map(Student::getActivities)
                        .flatMap(Collection::parallelStream)
                        .distinct()
                        .sorted()
                        .collect(joining("||", "[", "]"))
        );

    }
}
