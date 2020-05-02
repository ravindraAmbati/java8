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
import java.util.function.Consumer;
import java.util.function.Predicate;

@Slf4j
public class StudentConsumerAndPredicateTest {

    private List<Student> students = null;
    private BiConsumer<String, List<String>> printStudentName_ActivitiesBiConsumer = null;
    private Predicate<Student> gradeGreaterThan3Predicate = null;
    private Predicate<Student> gpaGreaterThan6Predicate = null;
    private Consumer<Student> studentConsumer = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        printStudentName_ActivitiesBiConsumer = (name, activities) -> log.info(name + "    :   " + activities);
        gradeGreaterThan3Predicate = s -> s.getGrade() > 3;
        gpaGreaterThan6Predicate = s -> s.getGpa() > 6;
        studentConsumer = s -> {
            if (gradeGreaterThan3Predicate.and(gpaGreaterThan6Predicate).test(s)) {
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
    }

    @Test
    void setPrintStudentName_ActivitiesBiConsumer_gradeGreaterThan3_gpaGreaterThan6() {
        students.forEach(s -> studentConsumer.accept(s));
    }

    @Test
    void setPrintStudentName_ActivitiesBiConsumer_gradeGreaterThan3_gpaGreaterThan6_NoAccept() {
        students.forEach(studentConsumer);
    }
}
