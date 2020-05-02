package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 15:56 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Slf4j
public class StudentPredicateTest {

    private List<Student> students = null;
    private Predicate<Student> gradeGreaterThan3Predicate = null;
    private Predicate<Student> gpaGreaterThan6Predicate = null;
    private Predicate<Student> malePredicate = null;
    private Predicate<Student> singingActivityPredicate = null;
    private Predicate<Student> cookingActivityPredicate = null;

    @BeforeEach
    void setUp() {
        students = StudentBootstrap.getStudents();
        gradeGreaterThan3Predicate = s -> s.getGrade() > 3;
        gpaGreaterThan6Predicate = s -> s.getGpa() > 6;
        malePredicate = s -> s.getGender().equalsIgnoreCase("MALE");
        singingActivityPredicate = s -> {
            List<Boolean> flags = new ArrayList<>();
            s.getActivities().forEach(a -> {
                flags.add(a.equalsIgnoreCase("SINGING"));
            });
            return flags.contains(Boolean.TRUE);
        };
        cookingActivityPredicate = s -> {
            List<Boolean> flags = new ArrayList<>();
            s.getActivities().forEach(a -> {
                flags.add(a.equalsIgnoreCase("COOKING"));
            });
            return flags.contains(Boolean.TRUE);
        };
    }

    @AfterEach
    void tearDown() {
        students = null;
        gradeGreaterThan3Predicate = null;
        gpaGreaterThan6Predicate = null;
        malePredicate = null;
        singingActivityPredicate = null;
        cookingActivityPredicate = null;

    }

    @Test
    void printGradeGreaterThan3_Students() {
        students.forEach(s -> {
            if (gradeGreaterThan3Predicate.test(s)) {
                log.info(s.toString());
            }
        });
    }

    @Test
    void printGpaGreaterThan6_Students() {
        students.forEach(s -> {
            if (gpaGreaterThan6Predicate.test(s)) {
                log.info(s.toString());
            }
        });
    }

    @Test
    void printGpaGreaterThan6_GradeGreaterThan3_Students() {
        students.forEach(s -> {
            if (gpaGreaterThan6Predicate.and(gradeGreaterThan3Predicate).test(s)) {
                log.info(s.toString());
            }
        });
    }

    @Test
    void printMale_GpaGreaterThan6_GradeGreaterThan3_Students() {
        students.forEach(s -> {
            if (malePredicate.and(gpaGreaterThan6Predicate).and(gradeGreaterThan3Predicate).test(s)) {
                log.info(s.toString());
            }
        });
    }

    @Test
    void printSingingOrCookingActivityStudents() {
        students.forEach(s -> {
            if (singingActivityPredicate.or(cookingActivityPredicate).test(s)) {
                log.info(s.toString());
            }
        });
    }
}
