package com.learn.java8.lambdasAndFunctionalInterfaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PredicateImplTest {

    private Predicate<Integer> evenNumberPredicate = null;
    private Predicate<Integer> divisibleBy5Predicate = null;

    @BeforeEach
    void setUp() {
        evenNumberPredicate = i -> i % 2 == 0;
        divisibleBy5Predicate = i -> i % 5 == 0;
    }

    @AfterEach
    void tearDown() {
        evenNumberPredicate = null;
        divisibleBy5Predicate = null;
    }

    @Test
    void evenNum() {
        assertTrue(evenNumberPredicate.test(756));
        assertFalse(evenNumberPredicate.test(757));
    }

    @Test
    void oddNum() {
        assertTrue(evenNumberPredicate.negate().test(109));
        assertFalse(evenNumberPredicate.negate().test(108));
    }

    @Test
    void evenNumOrDivisibleBy5() {
        assertTrue(divisibleBy5Predicate.or(evenNumberPredicate).test(55));
        assertTrue(divisibleBy5Predicate.or(evenNumberPredicate).test(54));
        assertFalse(divisibleBy5Predicate.or(evenNumberPredicate).test(57));
    }


    @Test
    void oddNumAndDivisibleBy5() {
        assertTrue(evenNumberPredicate.negate().and(divisibleBy5Predicate).test(105));
        assertFalse(evenNumberPredicate.negate().and(divisibleBy5Predicate).test(110));
        assertFalse(evenNumberPredicate.negate().and(divisibleBy5Predicate).test(107));
    }
}
