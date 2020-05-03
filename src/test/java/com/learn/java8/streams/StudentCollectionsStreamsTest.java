package com.learn.java8.streams;

/* @author ravin @date 03-05-2020 @time 21:02 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
public class StudentCollectionsStreamsTest {

    private List<Student> students = null;
    private Function<Student, List<String>> studentActivityListFunction = null;
    private Predicate<Student> gradeGreaterThan3 = null;
    private Predicate<Student> gpaGreaterThan6 = null;
    private Stream<Student> studentGradeGreaterThan3Stream = null;
    private Stream<Student> studentGpaGreaterThan7Stream = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.studentListSupplierMethodReference.get();
        studentActivityListFunction = Student::getActivities;
        gradeGreaterThan3 = s -> s.getGrade() > 3;
        gpaGreaterThan6 = s -> s.getGpa() > 6.0d;
        studentGradeGreaterThan3Stream = students.stream().filter(gradeGreaterThan3);
        studentGpaGreaterThan7Stream = studentGradeGreaterThan3Stream.filter(gpaGreaterThan6);

    }

    @AfterEach
    void tearDown() {
        students = null;
        studentActivityListFunction = null;
        gradeGreaterThan3 = null;
        gpaGreaterThan6 = null;
        studentGradeGreaterThan3Stream = null;
        studentGpaGreaterThan7Stream = null;
    }

    @Test
    void print() {
        // add or remove operations can be done on collections only
//        students.forEach(s->{
//            List<String> activities = studentActivityListFunction.apply(s);
//            activities.add("ADDED");
//            activities.remove(0);
//            activities.remove(1);
//            log.info(activities.toString());
//        });

        List<String> activities = new ArrayList<>(StudentBootstrap.getStudents().get(0).getActivities());
        activities.add("ADDED");
        activities.remove(0);
        activities.remove(1);
        log.info(activities.toString());

        // add or remove operations cannot be done on streams
//        students.stream().add
//        students.stream().re

        // can get particular object
        log.info(students.get(3).toString());

        // cannot get any particular object
//        log.info(students.stream().get);

        // Streams are lazy performed - intermediate operations cannot be performed if terminal operations are not performed
        //intermediate operations are filters
        //terminal operations are collect
        //Collections are eagerly construct
        //Stream are lazy construct only invoke if terminal operations
        // Collections are travers multiple times
        // Stream are travers only once
        // Collections iterate external
        // Stream iterate internal
        log.info("-----------------------");
        log.info("-----------------------");
        for (Student s : students) {
            if (s.getGrade() > 3) {
                log.info(s.toString());
            }
        }
        log.info("-----------------------");
        for (Student s : students) {
            if (s.getGpa() > 7.0d) {
                log.info(s.toString());
            }
        }
        log.info("-----------------------");
        log.info("-----------------------");
//        studentGradeGreaterThan3Stream.collect(Collectors.toList()).forEach(s->log.info(s.toString())); // it has been closed or stopped
        students.stream().filter(gradeGreaterThan3).forEach(s -> log.info(s.toString()));
        log.info("-----------------------");
        studentGpaGreaterThan7Stream.forEach(s -> log.info(s.toString()));
    }
}
