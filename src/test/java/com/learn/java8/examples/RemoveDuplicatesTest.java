package com.learn.java8.examples;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RemoveDuplicatesTest {

    private List<Integer> source = null;
    private List<Integer> target = null;

    @BeforeEach
    void setUp() {
        source = Arrays.asList(1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 7, 6, 5, 4, 3, 8, 9, 10);
        target = new ArrayList<Integer>(10);
    }

    @AfterEach
    void tearDown() {
        source = null;
        target = null;
    }

    @Test
    void removeDuplicatesFromList_Java7() {
        for (Integer temp : source) {
            if (!target.contains(temp)) {
                target.add(temp);
            }
        }
        log.info("Removed Duplicates from the list of ints: " + target);
    }

    @Test
    void removeDuplicatesFromList() {
        target = source.stream().distinct().collect(Collectors.toList());
        log.info("Removed Duplicates from the list of ints: " + target);
    }
}
