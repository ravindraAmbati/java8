package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 21:26 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@Slf4j
public class StudentUnaryOperatorTest {

    private static final String MASTER = "MASTER. ";
    private static final String MISS = "MISS. ";
    private static final String MALE = "MALE";
    private List<Student> students = null;
    private Predicate<Student> studentGenderPredicate = null;
    private Consumer<Student> printStudentConsumer = null;
    private UnaryOperator<Student> studentTitleUnaryOperator = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.studentListSupplierLambda.get();
        studentGenderPredicate = s -> MALE.equalsIgnoreCase(s.getGender());
        printStudentConsumer = s -> log.info(s.toString());
        studentTitleUnaryOperator = s -> {
            if (studentGenderPredicate.test(s)) {
                s.setName(MASTER.concat(s.getName()));
            } else {
                s.setName(MISS.concat(s.getName()));
            }
            return s;
        };
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentGenderPredicate = null;
        printStudentConsumer = null;
        studentTitleUnaryOperator = null;
    }

    @Test
    void printTitlesOfTheStudents() {
        students.forEach(s -> printStudentConsumer.accept(studentTitleUnaryOperator.apply(s)));
    }
}
