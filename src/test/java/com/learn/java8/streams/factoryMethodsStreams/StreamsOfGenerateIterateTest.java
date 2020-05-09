package com.learn.java8.streams.factoryMethodsStreams;

/* @author ravin @date 05-05-2020 @time 20:29 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamsOfGenerateIterateTest {

    private Stream<String> stringStream = null;
    private Stream<Student> studentStream = null;
    private Stream<Integer> integerStream = null;
    private List<Student> students = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        stringStream = Stream.of(
                students.get(0).getName(),
                students.get(1).getName(),
                students.get(2).getName(),
                students.get(3).getName(),
                students.get(0).getName(),
                students.get(1).getName(),
                students.get(2).getName(),
                students.get(3).getName()
        );
        studentStream = Stream.generate(StudentBootstrap.studentSupplier);
        integerStream = Stream.iterate(1, a -> a * 2).limit(100);
    }

    @AfterEach
    void tearDown() {
        students = null;
        stringStream = null;
        studentStream = null;
        integerStream = null;
    }

    @Test
    void print() {
        log.info(
                stringStream
                        .sorted()
                        .distinct()
                        .collect(Collectors.toList())
                        .toString()
        );

        studentStream.limit(7).forEach(
                s -> log.info(
                        s.toString()
                )
        );

        integerStream
                .collect(
                        Collectors.toList()
                ).forEach(
                i -> log.info(
                        Objects.toString(i)
                )
        );

    }
}
