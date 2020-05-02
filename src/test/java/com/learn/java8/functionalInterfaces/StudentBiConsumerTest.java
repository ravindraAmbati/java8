package com.learn.java8.functionalInterfaces;

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiConsumer;

@Slf4j
public class StudentBiConsumerTest {

    private List<Student> students = null;
    private BiConsumer<String, List<String>> studentBiConsumer = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentBiConsumer = (name, activities) -> log.info(name + "    :   " + activities);
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentBiConsumer = null;
    }

    @Test
    void printStudentActivities() {
        students.forEach(s -> studentBiConsumer.accept(s.getName(), s.getActivities()));
    }
}
