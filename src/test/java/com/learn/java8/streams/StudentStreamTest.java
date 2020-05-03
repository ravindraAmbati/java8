package com.learn.java8.streams;

/* @author ravin @date 03-05-2020 @time 20:22 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class StudentStreamTest {

    private List<Student> students = null;
    private Map<String, List<String>> studentNameAndActivitiesMap = null;
    private Predicate<Student> gradeGreaterThan3 = null;
    private Map<String, List<String>> studentNameAndActivitiesGradeGreaterThan3Map = null;
    private Predicate<Student> gpaGreaterThan6 = null;
    private Map<String, List<String>> studentNameAndActivitiesGradeGreaterThan3GpaGreaterThan6Map = null;
    private List<String> studentDistinctActivities = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentNameAndActivitiesMap = students
                .stream()
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        gradeGreaterThan3 = s -> s.getGrade() > 3;
        studentNameAndActivitiesGradeGreaterThan3Map = students
                .stream()
                .filter(gradeGreaterThan3)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        gpaGreaterThan6 = s -> s.getGpa() > 6.0d;
        studentNameAndActivitiesGradeGreaterThan3GpaGreaterThan6Map = students
                .stream()
                .filter(gradeGreaterThan3)
                .filter(gpaGreaterThan6)
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        studentDistinctActivities = students
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

    }

    @AfterEach
    void tearDown() {
        students = null;
        studentNameAndActivitiesMap = null;
        gradeGreaterThan3 = null;
        studentNameAndActivitiesGradeGreaterThan3Map = null;
        gpaGreaterThan6 = null;
        studentNameAndActivitiesGradeGreaterThan3GpaGreaterThan6Map = null;
        studentDistinctActivities = null;
    }

    @Test
    void printStudentNameAndActivities() {
        log.info(studentNameAndActivitiesMap.toString());
    }

    @Test
    void printStudentNameAndActivitiesGradeGreaterThan3Map() {
        log.info(studentNameAndActivitiesGradeGreaterThan3Map.toString());
    }

    @Test
    void printStudentNameAndActivitiesGradeGreaterThan3GpaGreaterThan6Map() {
        log.info(studentNameAndActivitiesGradeGreaterThan3GpaGreaterThan6Map.toString());
    }

    @Test
    void printDistinctActivitiesMap() {
        log.info(studentDistinctActivities.toString());
    }
}
