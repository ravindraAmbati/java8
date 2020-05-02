package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 22:41 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
public class StudentSupplierTest {

    private Supplier<Student> studentSupplier = null;
    private Supplier<List<Student>> studentListSupplier = null;

    @BeforeEach
    void setUp() {
        studentSupplier = () -> Student.builder().build();
        studentListSupplier = () -> StudentBootstrap.getStudents();
    }

    @AfterEach
    void tearDown() {
        studentSupplier = null;
    }

    @Test
    void studentSupplier() {
        log.info(studentSupplier.get().toString());
    }

    @Test
    void studentListSupplier() {
        studentListSupplier.get().forEach(s -> log.info(s.toString()));
    }
}
