package com.learn.java8.optionals;

/* @author ravin @date 09-05-2020 @time 17:51 */

import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

@Slf4j
public class StudentOptionalTest {

    private Student student = null;
    private Optional<Student> studentOptional = null;

    @BeforeEach
    void setUp() {
        student = new Student();
//        student.setName("I am ");
        studentOptional = Optional.of(student);
    }

    @AfterEach
    void tearDown() {
        student = null;
        studentOptional = Optional.empty();
    }

    @Test
    void studentOptionalTest() {
        log.info(
                studentOptional
                        .get()
                        .toString()
        );
        log.info(
                studentOptional
                        .get()
                        .getName()
        );
        Optional<String> stringOptional = Optional.empty();
        if (studentOptional.isPresent()) {
            stringOptional = Optional.ofNullable(studentOptional.get().getName());
        }
        stringOptional.ifPresent(s -> log.info(
                Objects.toString(
                        s
                                .length()
                )
        ));

    }
}
