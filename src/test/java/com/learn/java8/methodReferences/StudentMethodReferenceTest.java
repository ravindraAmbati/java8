package com.learn.java8.methodReferences;

/* @author ravin @date 03-05-2020 @time 08:14 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class StudentMethodReferenceTest {

    private List<Student> students = null;
    private Consumer<Student> printLambda = null;
    private Consumer<Student> getActivitiesMethodReference = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.studentListSupplierMethodReference.get();
        printLambda = s -> log.info(s.toString());
        getActivitiesMethodReference = Student::printActivities;
    }

    @AfterEach
    void tearDown() {
        students = null;
        printLambda = null;
        getActivitiesMethodReference = null;
    }

    @Test
    void printStudent() {
        students.forEach(s -> printLambda.accept(s));
        students.forEach(printLambda);
    }

    @Test
    void printActivities() {
        students.forEach(s -> getActivitiesMethodReference.accept(s));
        students.forEach(getActivitiesMethodReference);
    }
}
