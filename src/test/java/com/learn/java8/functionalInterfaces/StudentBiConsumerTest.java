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

@Slf4j
public class StudentBiConsumerTest {

    private List<Student> students = null;
    private BiConsumer<String, List<String>> studentName_ActivitiesBiConsumer = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.studentListSupplier.get();
        studentName_ActivitiesBiConsumer = (name, activities) -> log.info(name + "    :   " + activities);
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentName_ActivitiesBiConsumer = null;
    }

    @Test
    void printStudentActivities() {
        students.forEach(s -> studentName_ActivitiesBiConsumer.accept(s.getName(), s.getActivities()));
    }
}
