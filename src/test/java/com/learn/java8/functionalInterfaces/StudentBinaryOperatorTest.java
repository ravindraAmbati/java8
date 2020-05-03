package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 21:41 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

@Slf4j
public class StudentBinaryOperatorTest {

    private static final String MASTER = "MASTER. ";
    private static final String MISS = "MISS. ";
    private static final String MALE = "MALE";
    private List<Student> students = null;
    private BiPredicate<Student, Student> studentPredicate = null;
    private Consumer<Student> printStudentConsumer = null;
    private BinaryOperator<Student> studentBinaryOperator = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.studentListSupplierLambda.get();
        studentPredicate = (s1, s2) -> s1.getName().equalsIgnoreCase(s2.getName());
        printStudentConsumer = s -> log.info((null != s) ? s.toString() : "EMPTY");
        studentBinaryOperator = (s1, s2) -> studentPredicate.test(s1, s2) ? s1 : null;
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentPredicate = null;
        printStudentConsumer = null;
        studentBinaryOperator = null;
    }

    @Test
    void printTitlesOfTheStudents() {
        students.forEach(s -> printStudentConsumer.accept(studentBinaryOperator.apply(s, Student.builder().name("Leo").build())));
    }
}
