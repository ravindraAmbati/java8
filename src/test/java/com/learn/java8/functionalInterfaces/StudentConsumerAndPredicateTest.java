package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 15:56 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class StudentConsumerAndPredicateTest {

    private List<Student> students = null;
    private BiConsumer<String, List<String>> printStudentName_ActivitiesBiConsumer = null;
    private Predicate<Student> gradeGreaterThan3Predicate = null;
    private Predicate<Student> gpaGreaterThan6Predicate = null;
    private Consumer<Student> studentConsumer = null;
    private BiPredicate<Integer, Double> studentGradeGreaterThan2AndGpaGreaterThan4BiPredicate = null;
    private Consumer<Student> studentConsumer1 = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.studentListSupplierLambda.get();
        printStudentName_ActivitiesBiConsumer = (name, activities) -> log.info(name + "    :   " + activities);
        gradeGreaterThan3Predicate = s -> s.getGrade() > 3;
        gpaGreaterThan6Predicate = s -> s.getGpa() > 6;
        studentConsumer = s -> {
            if (gradeGreaterThan3Predicate.and(gpaGreaterThan6Predicate).test(s)) {
                printStudentName_ActivitiesBiConsumer.accept(s.getName(), s.getActivities());
            }
        };
        studentGradeGreaterThan2AndGpaGreaterThan4BiPredicate = (i, j) -> i > 2 && j > 4.0d;
        studentConsumer1 = s -> {
            if (studentGradeGreaterThan2AndGpaGreaterThan4BiPredicate.test(s.getGrade(), s.getGpa())) {
                printStudentName_ActivitiesBiConsumer.accept(s.getName(), s.getActivities());
            }
        };
    }

    @AfterEach
    void tearDown() {
        students = null;
        printStudentName_ActivitiesBiConsumer = null;
        gradeGreaterThan3Predicate = null;
        gpaGreaterThan6Predicate = null;
        studentConsumer = null;
        studentGradeGreaterThan2AndGpaGreaterThan4BiPredicate = null;
        studentConsumer1 = null;
    }

    @Test
    void printStudentName_ActivitiesBiConsumer_gradeGreaterThan3_gpaGreaterThan6() {
        students.forEach(s -> studentConsumer.accept(s));
    }

    @Test
    void printStudentName_ActivitiesBiConsumer_gradeGreaterThan3_gpaGreaterThan6_NoAccept() {
        students.forEach(studentConsumer);
    }

    @Test
    void printStudentName_ActivitiesBiConsumer_gradeGreaterThan2_gpaGreaterThan4() {
        students.forEach(s -> studentConsumer1.accept(s));
    }

    @Test
    void printStudentName_ActivitiesBiConsumer_gradeGreaterThan2_gpaGreaterThan4_NoAccept() {
        students.forEach(studentConsumer1);
    }
}
