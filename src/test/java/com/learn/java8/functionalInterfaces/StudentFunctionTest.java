package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 17:01 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class StudentFunctionTest {

    private static final String TITLE_MASTER = "MASTER. ";
    private static final String TITLE_MISS = "Miss. ";
    private static final String MALE = "MALE";
    private static final String MAILDOMAIN = "@domain.com";
    private List<Student> students = null;
    private Function<Student, String> studentTitleFunction = null;
    private Predicate<Student> grade4Predicate = null;
    private Function<String, String> emailIdFunction = null;
    private Function<List<Student>, Map<String, String>> studenteMailIdFunction = null;
    private Consumer<Map<String, String>> printName_eMailId = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        studentTitleFunction = s -> {
            if (MALE.equalsIgnoreCase(s.getGender())) {
                return TITLE_MASTER.concat(s.getName());
            } else {
                return TITLE_MISS.concat(s.getName());
            }
        };
        grade4Predicate = s -> s.getGrade() == 4;
        emailIdFunction = s -> s.concat(MAILDOMAIN);
        studenteMailIdFunction = students -> {
            Map<String, String> mailIds = new HashMap<>(students.size());
            students.forEach(s -> {
                if (grade4Predicate.test(s)) {
                    mailIds.put(s.getName(), emailIdFunction.apply(s.getName()));
                }
            });
            return mailIds;
        };
        printName_eMailId = m -> {
            m.forEach((s, s2) -> {
                log.info("Name of the Student: " + s + " || " + "eMailId of the Student: " + s2);
            });
        };
    }

    @AfterEach
    void tearDown() {
        students = null;
        studentTitleFunction = null;
        grade4Predicate = null;
        emailIdFunction = null;
        studenteMailIdFunction = null;
    }

    @Test
    void printStudentTitles() {
        students.forEach(s -> log.info(studentTitleFunction.apply(s)));
    }

    @Test
    void printStudentMailIds_Grade4() {
        printName_eMailId.accept(studenteMailIdFunction.apply(students));
    }
}
