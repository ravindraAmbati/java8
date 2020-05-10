package com.learn.java8.defaultStaticMethods.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassImplABCTest {

    private ClassImplABC testClass = null;

    @BeforeEach
    void setUp() {
        testClass = new ClassImplABC();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void print() {
        testClass.methodA();
        testClass.methodB();
        testClass.methodC();
    }
}