package com.learn.java8.methodReferences;

/* @author ravin @date 03-05-2020 @time 07:45 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
public class MethodReferenceImplTest {

    private BiFunction<String, String, String> appendStringBiFunctionLambda = null;
    private BiFunction<String, String, String> appendStringBiFunctionMethodReference = null;
    private Function<String, String> toUpperCaseFunctionLambda = null;
    private Function<String, String> toUpperCaseFunctionMethodReference = null;
    private Consumer<String> printLambda = null;
    private Consumer<String> printMethodReference = null;

    @BeforeEach
    void setUp() {
        appendStringBiFunctionLambda = (s1, s2) -> s1.concat(s2);
        appendStringBiFunctionMethodReference = String::concat;
        toUpperCaseFunctionLambda = s -> s.toUpperCase();
        toUpperCaseFunctionMethodReference = String::toUpperCase;
        printLambda = s -> log.info(s);
        printMethodReference = log::info;
    }

    @AfterEach
    void tearDown() {
        appendStringBiFunctionLambda = null;
        appendStringBiFunctionMethodReference = null;
        toUpperCaseFunctionLambda = null;
        toUpperCaseFunctionMethodReference = null;
        printLambda = null;
        printMethodReference = null;
    }

    @Test
    void appendStrLambda() {
        printLambda.accept(appendStringBiFunctionLambda.apply("Mr. ", "Bean"));
        printMethodReference.accept(appendStringBiFunctionMethodReference.apply("Mr. ", "Bean"));
    }

    @Test
    void toUpperCaseLambda() {
        printLambda.accept(toUpperCaseFunctionLambda.apply("mr. incredible"));
        printMethodReference.accept(toUpperCaseFunctionMethodReference.apply("mr. incredible"));
    }
}
