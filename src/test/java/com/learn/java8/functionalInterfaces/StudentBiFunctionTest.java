package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 17:48 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class StudentBiFunctionTest {

    private static final String MALE = "MALE";
    private List<Student> students = null;
    private Predicate<Student> studentGpaGreaterThan8Predicate = null;
    private Predicate<Student> studentGradeGreaterThan2Predicate = null;
    private Predicate<Student> maleStudentPredicate = null;
    private Consumer<List<Student>> printStudentNameGenderGradeGpa = null;
    private BiFunction<List<Student>, Predicate<Student>, List<Student>> studentBiFunction = null;

    //todo BiFunc - studentsList, predicatesList, filteredStudentsList

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentGpaGreaterThan8Predicate = s -> s.getGpa() > 8.0d;
        studentGradeGreaterThan2Predicate = s -> s.getGrade() > 2;
        maleStudentPredicate = s -> MALE.equalsIgnoreCase(s.getGender());
        printStudentNameGenderGradeGpa = students -> students.forEach(s -> {
            log.info("----------------------------------------");
            log.info("Name:     " + s.getName());
            log.info("Gender:   " + s.getGender());
            log.info("Grade:    " + s.getGrade());
            log.info("Gpa:      " + s.getGpa());
            log.info("----------------------------------------");
        });
        studentBiFunction = (students, predicate) -> {
            List<Student> filteredList = new ArrayList<>(students.size());
            students.forEach(s -> {
                if (predicate.test(s)) {
                    filteredList.add(s);
                }
            });
            return filteredList;
        };
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentGpaGreaterThan8Predicate = null;
        studentGradeGreaterThan2Predicate = null;
        maleStudentPredicate = null;
        printStudentNameGenderGradeGpa = null;
    }

    @Test
    void printStudent() {
        printStudentNameGenderGradeGpa.accept(studentBiFunction.apply(students, studentGradeGreaterThan2Predicate));
        printStudentNameGenderGradeGpa.accept(studentBiFunction.apply(students, studentGpaGreaterThan8Predicate));
        printStudentNameGenderGradeGpa.accept(studentBiFunction.apply(students, maleStudentPredicate));
    }
}
