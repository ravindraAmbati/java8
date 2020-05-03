package com.learn.java8.methodReferences;

/* @author ravin @date 03-05-2020 @time 08:35 */

import com.learn.java8.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class ConstructorMethodReferenceTest {

    //        Student student  = Student::new; // Invalid - Compilation Error

    private Consumer<Student> printStudent = null;
    private Supplier<Student> studentSupplierLambda = null;
    private Supplier<Student> studentSupplierMethodReference = null;
    private Function<String, Student> studentWithNameFunctionLambda = null;
    private Function<String, Student> studentWithNameFunctionMethodReference = null;
    private BiFunction<String, Integer, Student> studentWithNameAndGradeBiFunctionLambda = null;
    private BiFunction<String, Integer, Student> studentWithNameAndGradeBiFunctionMethodReference = null;

    @BeforeEach
    void setUp() {
        printStudent = s -> log.info(s.toString());
        studentSupplierLambda = () -> new Student();
        studentSupplierMethodReference = Student::new;
        studentWithNameFunctionLambda = (n) -> new Student(n);
        studentWithNameFunctionMethodReference = Student::new;
        studentWithNameAndGradeBiFunctionLambda = (n, g) -> new Student(n, g);
        studentWithNameAndGradeBiFunctionMethodReference = Student::new;
    }

    @AfterEach
    void tearDown() {
        printStudent = null;
        studentSupplierLambda = null;
        studentSupplierMethodReference = null;
        studentWithNameFunctionLambda = null;
        studentWithNameFunctionMethodReference = null;
        studentWithNameAndGradeBiFunctionLambda = null;
        studentWithNameAndGradeBiFunctionMethodReference = null;
    }

    @Test
    void printNewStudent() {
        printStudent.accept(studentSupplierLambda.get());
        printStudent.accept(studentSupplierMethodReference.get());
        printStudent.accept(studentWithNameFunctionLambda.apply("Max"));
        printStudent.accept(studentWithNameFunctionMethodReference.apply("Well"));
        printStudent.accept(studentWithNameAndGradeBiFunctionLambda.apply("Captain", 7));
        printStudent.accept(studentWithNameAndGradeBiFunctionMethodReference.apply("American", 8));
    }

}
