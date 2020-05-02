package com.learn.java8.functionalInterfaces;

/* @author ravin @date 02-05-2020 @time 16:14 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BiPredicateImplTest {

    private BiPredicate<Integer, Integer> arithmeticBiPredicate = null;

    @BeforeEach
    void setUp() {
        arithmeticBiPredicate = (i, j) -> i + j > 0 && i - j > 0 && i * j > 0 && i / j > 0;
    }

    @AfterEach
    void tearDown() {
        arithmeticBiPredicate = null;
    }

    @Test
    void operations() {
        assertTrue(arithmeticBiPredicate.test(3, 1));
        assertFalse(arithmeticBiPredicate.test(1, -2));
        assertFalse(arithmeticBiPredicate.test(1, 1));
        assertFalse(arithmeticBiPredicate.test(0, 1));
        assertFalse(arithmeticBiPredicate.test(2, 0));
    }


}
