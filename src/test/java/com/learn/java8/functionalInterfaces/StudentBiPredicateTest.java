package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 16:29 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiPredicate;

@Slf4j
public class StudentBiPredicateTest {

    private List<Student> students = null;
    private BiPredicate<Integer, Double> studentGradeGreaterThan3AndGpaGreaterThan6BiPredicate = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentGradeGreaterThan3AndGpaGreaterThan6BiPredicate = (i, j) -> i > 3 && j > 6.0d;
    }

    @AfterEach
    void tearDown() {
        studentGradeGreaterThan3AndGpaGreaterThan6BiPredicate = null;
        students = null;
    }

    @Test
    void printStudents() {
        students.forEach(s -> {
            if (studentGradeGreaterThan3AndGpaGreaterThan6BiPredicate.test(s.getGrade(), s.getGpa())) {
                log.info(s.toString());
            }
        });
    }
}
