package com.learn.java8.methodReferences;

/* @author ravin @date 03-05-2020 @time 08:58 */

import com.learn.java8.bootstrap.StudentBootstrap;
import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

@Slf4j
public class RefactorMethodReference {

    private Student s = null;
    private Predicate<Student> maleStudentPredicateLambda = null;
    private Predicate<Student> maleStudentPredicateMethodReference = null;

    private static boolean isMaleStudent(Student s) {
        return s.getGender().equalsIgnoreCase("MALE");
    }

    @BeforeEach
    void setUp() {
        s = StudentBootstrap.studentSupplier.get();
        maleStudentPredicateLambda = s -> s.getGender().equalsIgnoreCase("MALE");
        maleStudentPredicateMethodReference = RefactorMethodReference::isMaleStudent;
    }

    @AfterEach
    void tearDown() {
        s = null;
        maleStudentPredicateLambda = null;
        maleStudentPredicateMethodReference = null;
    }

    @Test
    void isMaleStudent() {
        log.info(String.valueOf(maleStudentPredicateLambda.test(s)));
        log.info(String.valueOf(maleStudentPredicateMethodReference.test(s)));
        log.info(String.valueOf(maleStudentPredicateLambda));
        log.info(String.valueOf(maleStudentPredicateMethodReference));
    }
}
