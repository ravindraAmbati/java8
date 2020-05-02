package com.learn.java8.lambdas;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

@Slf4j
public class ComparatorImplTest {

    private Comparator<Integer> integerComparator = null;

    @BeforeEach
    void setUp() {
        integerComparator = null;
    }

    @AfterEach
    void tearDown() {
        integerComparator = null;
    }

    @Test
    void compare_Java7(){
        integerComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        log.info("compare_Java7 "+integerComparator.compare(2,3));
    }

    @Test
    void compare(){
        integerComparator = (Integer o1, Integer o2) -> {
            return o1.compareTo(o2);
        };
        log.info("compare "+integerComparator.compare(2,3));
    }

    @Test
    void compare_SingleLine(){
        integerComparator = (Integer o1, Integer o2) ->  o1.compareTo(o2);
        log.info("compare_SingleLine "+integerComparator.compare(2,3));
    }

    @Test
    void compare_SingleLine_NoParameterTypes(){
        integerComparator = (o1, o2) ->  o1.compareTo(o2);
        log.info("compare_SingleLine_NoParameterTypes "+integerComparator.compare(2,3));
    }

    @Test
    void compare_SingleLine_MethodReference(){
        integerComparator = Integer::compareTo;
        log.info("compare_SingleLine_MethodReference "+integerComparator.compare(2,3));
    }
}
