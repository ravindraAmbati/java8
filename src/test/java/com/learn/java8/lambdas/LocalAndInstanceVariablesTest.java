package com.learn.java8.lambdas;

/* @author ravin @date 03-05-2020 @time 19:53 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

@Slf4j
public class LocalAndInstanceVariablesTest {

    private String instanceVariable = " string1 ";
    private Consumer<String> printString1 = null;
    private Consumer<String> printString2 = null;
    private Consumer<String> printString3 = null;
    private Consumer<String> printString4 = null;

    @BeforeEach
    void setUp() {
        String localVariable = " string2 ";

        // can access local variable
        printString1 = str1 -> {
            log.info(str1.concat(localVariable)); // can be used but not to assign
            instanceVariable = " sample "; // can be used and can assign a new value
        };

        // can access local variable
        printString2 = str2 -> {
            log.info(str2.concat(instanceVariable));
//            localVariable  = " localVariable"; // localVariable cannot be assigned
        };

        // cannot use localVariable as lambda parameters
//        printString3 = localVariable -> {
//            log.info(localVariable.concat(instanceVariable));
//        };

        // can use instanceVariable as lambda parameters
        printString4 = instanceVariable -> {
            log.info(instanceVariable.concat(instanceVariable));
        };
    }

    @AfterEach
    void tearDown() {
        instanceVariable = " string1 ";
        printString1 = null;
        printString2 = null;
        printString3 = null;
        printString4 = null;
    }

    @Test
    void printString() {
        printString1.accept("Max");
        printString2.accept("Well");
//        printString3.accept("Max");
        printString4.accept("Well");
    }
}
