package com.learn.java8.defaultStaticMethods.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassImplADTest {

    private ClassImplAD testClass = null;

    @BeforeEach
    void setUp() {
        testClass = new ClassImplAD();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void methodA() {
        testClass.methodA();
    }
}