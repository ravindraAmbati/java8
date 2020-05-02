package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 15:56 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class StudentConsumerTest {

    List<Student> students = null;
    Consumer<Student> printStudentConsumer = null;
    Consumer<Student> uppercaseStudentNameConsumer = null;
    Consumer<Student> printStudentActivitiesConsumer = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        printStudentConsumer = (s) -> log.info(s.toString());
        uppercaseStudentNameConsumer = (s) -> log.info(s.getName().toUpperCase());
        printStudentActivitiesConsumer = (s) -> log.info(s.getActivities().toString());
    }

    @AfterEach
    void tearDown() {
        students = null;
        printStudentConsumer = null;
        uppercaseStudentNameConsumer = null;
        printStudentActivitiesConsumer = null;
    }

    @Test
    void print() {
        students.forEach(printStudentConsumer);
    }

    @Test
    void printStudentName_uppercase() {
        students.forEach(uppercaseStudentNameConsumer);
    }

    @Test
    void printStudentName_uppercase_activities() {
        students.forEach(uppercaseStudentNameConsumer.andThen(printStudentActivitiesConsumer)); // consumer chaining
    }

    @Test
    void printStudentName_uppercase_activities_gpaGreaterThan8() {
        students.forEach(
                (student) -> {
                    if (student.getGpa() > 8) {
                        uppercaseStudentNameConsumer.andThen(printStudentActivitiesConsumer).accept(student);
                    }
                });
    }

    @Test
    void printStudentName_uppercase_activities_gpaGreaterThan6_gradeGreaterThan3() {
        students.forEach(
                (student) -> {
                    if (student.getGpa() > 6 && student.getGrade() > 3) {
                        uppercaseStudentNameConsumer.andThen(printStudentActivitiesConsumer).accept(student);
                    }
                });
    }
}
