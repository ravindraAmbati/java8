package com.learn.java8.methodReferences;

/* @author ravin @date 03-05-2020 @time 08:35 */

import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
public class ConsumerConstructorMethodReference {

    private Consumer<Student> printStudent = null;
    private Supplier<Student> getNewStudentLambda = null;
    private Supplier<Student> getNewStudentMethodReference = null;

    @BeforeEach
    void setUp() {
        getNewStudentLambda = () -> new Student();
        getNewStudentMethodReference = Student::new;
        printStudent = s -> log.info(s.toString());

    }

    @AfterEach
    void tearDown() {
        getNewStudentLambda = null;
        getNewStudentMethodReference = null;
        printStudent = null;
    }

    @Test
    void printNewStudent() {
        printStudent.accept(getNewStudentLambda.get());
        printStudent.accept(getNewStudentMethodReference.get());
    }

}
