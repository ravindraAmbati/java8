package com.learn.java8.streams.terminalOperations;

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* @author ravin @date 09-05-2020 @time 15:48 */
@Slf4j
public class StreamsStudentPartitionByTest {

    private List<Student> students = null;
    private Predicate<Student> gradePredicate = null;
    private Predicate<Student> gpaPredicate = null;
    private Predicate<Student> genderPredicate = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        gradePredicate = s -> s.getGrade() > 3;
        gpaPredicate = s -> s.getGpa() > 7.4d;
        genderPredicate = s -> s.getGender().equalsIgnoreCase("MALE");
    }

    @AfterEach
    void tearDown() {
        students = null;
        gradePredicate = null;
        gpaPredicate = null;
        genderPredicate = null;
    }

    @Test
    void partitionStudentByGrade() {
        Map<Boolean, List<Student>> map =
                students
                        .stream()
                        .collect(
                                Collectors.partitioningBy(
                                        gradePredicate
                                )
                        );
        log.info(
                students
                        .stream()
                        .collect(
                                Collectors.partitioningBy(
                                        gradePredicate
                                )
                        )
                        .toString()
        );
    }

    @Test
    void partitionStudentByGpa() {
        Map<Boolean, List<Student>> map =
                students
                        .stream()
                        .collect(
                                Collectors.partitioningBy(
                                        gpaPredicate
                                )
                        );
        log.info(
                students
                        .stream()
                        .collect(
                                Collectors.partitioningBy(
                                        gpaPredicate
                                )
                        )
                        .toString()
        );
    }

    @Test
    void partitionStudentByGender() {
        Map<Boolean, List<Student>> map =
                students
                        .stream()
                        .collect(
                                Collectors.partitioningBy(
                                        genderPredicate
                                )
                        );
        log.info(
                students
                        .stream()
                        .collect(
                                Collectors.partitioningBy(
                                        genderPredicate
                                )
                        )
                        .toString()
        );
    }
}
