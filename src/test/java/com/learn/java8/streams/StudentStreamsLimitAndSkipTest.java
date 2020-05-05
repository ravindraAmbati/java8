package com.learn.java8.streams;

/* @author ravin @date 05-05-2020 @time 17:50 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

@Slf4j
public class StudentStreamsLimitAndSkipTest {

    private static final String MALE = "MALE";
    private List<Student> students = null;
    private BinaryOperator<Student> maxBinaryOperator = null;
    private BinaryOperator<Student> minBinaryOperator = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        maxBinaryOperator = (s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2;
        minBinaryOperator = (s1, s2) -> s1.getGpa() > s2.getGpa() ? s2 : s1;
    }

    @AfterEach
    void tearDown() {
        students = null;
        maxBinaryOperator = null;
        minBinaryOperator = null;
    }

    @Test
    void printMaxGpaLambda() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .skip(5)
                        .reduce(0d, (a, b) -> a > b ? a : b)
                        .toString()
        );
    }

    @Test
    void printMinGpaLambda() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .limit(5)
                        .reduce(11d, (a, b) -> a < b ? a : b)
                        .toString()
        );
    }

    @Test
    void printMaxGpaMethodReference() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .skip(5)
                        .reduce(0d, Double::max)
                        .toString()
        );
    }

    @Test
    void printMinGpaMethodReference() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .skip(5)
                        .reduce(11d, Double::min)
                        .toString()
        );
    }

    @Test
    void printTotalGpa() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .limit(5)
                        .reduce(0d, Double::sum)
                        .toString()
        );
    }

    @Test
    void printAvgGpa() {
        Double total = students.stream()
                .map(Student::getGpa)
                .sorted()
                .skip(5)
                .reduce(0d, Double::sum);

        long count = students.stream()
                .map(Student::getGpa)
                .sorted()
                .skip(5)
                .count();
        log.info(String.valueOf(total / count));
    }

    @Test
    void printMaxGpaLambdaWithoutIdentity() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .limit(5)
                        .reduce((a, b) -> a > b ? a : b)
                        .orElse(0d)
                        .toString()
        );
    }

    @Test
    void printMinGpaLambdaWithoutIdentity() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .skip(5)
                        .reduce((a, b) -> a < b ? a : b)
                        .orElse(0d)
                        .toString()
        );
    }

    @Test
    void printMaxGpaMethodReferenceWithoutIdentity() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .limit(5)
                        .reduce(Double::max)
                        .orElse(0d)
                        .toString()
        );
    }

    @Test
    void printMinGpaMethodReferenceWithoutIdentity() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .skip(5)
                        .reduce(Double::min)
                        .orElse(0d)
                        .toString()
        );
    }

    @Test
    void printTotalGpaWithoutIdentity() {
        log.info(
                students.stream()
                        .map(Student::getGpa)
                        .sorted()
                        .limit(5)
                        .reduce(Double::sum)
                        .orElse(0d)
                        .toString()
        );
    }

    @Test
    void printAvgGpaWithoutIdentity() {
        Optional<Double> total = students.stream()
                .map(Student::getGpa)
                .sorted()
                .skip(5)
                .reduce(Double::sum);

        Long count = students.stream()
                .map(Student::getGpa)
                .sorted()
                .skip(5)
                .count();
        log.info(String.valueOf(total.orElse(0d) / count));
    }

    @Test
    void printStudentMinGpaAndMaxGpa() {
        log.info(students
                .stream()
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .skip(5)
                .reduce(new Student("", 0d), maxBinaryOperator)
                .toString());
        log.info(students
                .stream()
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .skip(5)
                .reduce(new Student("", 11d), minBinaryOperator)
                .toString());
        log.info(students
                .stream()
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .skip(5)
                .reduce(maxBinaryOperator)
                .orElse(new Student())
                .toString());
        log.info(students
                .stream()
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .skip(5)
                .reduce(minBinaryOperator)
                .orElse(new Student())
                .toString());
    }
}
