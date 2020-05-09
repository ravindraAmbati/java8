package com.learn.java8.streams.terminalOperations;

/* @author ravin @date 09-05-2020 @time 11:40 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class StreamsStudentGroupingByTest {

    private List<Student> students = null;
    private Map<String, List<Student>> studentsMapGroupedByGender = null;
    private Map<Integer, List<Student>> studentsMapGroupedByGrade = null;
    private Map<Double, List<Student>> studentsMapGroupedByGpa = null;
    private Map<String, List<Student>> studentsMapGroupedByActivity = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentsMapGroupedByGender = null;
        studentsMapGroupedByGrade = null;
        studentsMapGroupedByGpa = null;
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentsMapGroupedByGender = null;
        studentsMapGroupedByGrade = null;
        studentsMapGroupedByGpa = null;
    }

    @Test
    void groupStudentsByGenderTest() {
        studentsMapGroupedByGender = students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender)
                );
        log.info(
                students
                        .stream()
                        .collect(Collectors.groupingBy(Student::getGender))
                        .toString()
        );
    }

    @Test
    void groupStudentsByGradeTest() {
        studentsMapGroupedByGrade = students
                .stream()
                .collect(Collectors.groupingBy(Student::getGrade)
                );
        log.info(
                students
                        .stream()
                        .collect(Collectors.groupingBy(Student::getGrade))
                        .toString()
        );
    }

    @Test
    void groupStudentsByGpaTest() {
        studentsMapGroupedByGpa = students
                .stream()
                .collect(Collectors.groupingBy(Student::getGpa)
                );
        log.info(
                students
                        .stream()
                        .collect(Collectors.groupingBy(Student::getGpa))
                        .toString()
        );
    }
}
