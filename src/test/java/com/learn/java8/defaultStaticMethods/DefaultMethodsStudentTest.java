package com.learn.java8.defaultStaticMethods;

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/* @author ravin @date 10-05-2020 @time 10:46 */
@Slf4j
public class DefaultMethodsStudentTest {

    private List<Student> students = null;
    private Consumer<Student> studentConsumer = null;
    private Comparator<Student> nameComparator = null;
    private Comparator<Student> genderComparator = null;
    private Comparator<Student> gradeComparator = null;
    private Comparator<Student> gpaComparator = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentConsumer = s -> log.info(s.toString());
        nameComparator = Comparator.comparing(Student::getName);
        genderComparator = Comparator.comparing(Student::getGender);
        gradeComparator = Comparator.comparingInt(Student::getGrade);
        gpaComparator = Comparator.comparingDouble(Student::getGpa);
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentConsumer = null;
        nameComparator = null;
        genderComparator = null;
        gradeComparator = null;
        gpaComparator = null;
    }

    @Test
    void sortStudentsByName() {
        students.sort(nameComparator);
        students.forEach(studentConsumer);
    }

    @Test
    void sortStudentsByGender() {
        students.sort(genderComparator);
        students.forEach(studentConsumer);
    }

    @Test
    void sortStudentsByGrade() {
        students.sort(gradeComparator);
        students.forEach(studentConsumer);
    }

    @Test
    void sortStudentsByGpa() {
        students.sort(gpaComparator);
        students.forEach(studentConsumer);
    }

    @Test
    void sortStudentsByGpaReversed() {
        students.sort(gpaComparator.reversed());
        students.forEach(studentConsumer);
    }

    @Test
    void sortStudentsByGenderGradeGpaReversed() {
        students.sort(genderComparator.thenComparing(gradeComparator).thenComparing(gpaComparator.reversed()));
        students.forEach(studentConsumer);
    }

    @Test
    void sortStudentsByGpaReversedGenderGrade() {
        students.sort(gpaComparator.reversed().thenComparing(genderComparator));
        students.forEach(studentConsumer);
    }
}
