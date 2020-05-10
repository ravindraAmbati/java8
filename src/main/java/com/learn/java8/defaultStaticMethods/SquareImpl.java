package com.learn.java8.defaultStaticMethods;

/* @author ravin @date 10-05-2020 @time 20:15 */

import java.util.List;
import java.util.stream.Collectors;

public class SquareImpl implements Square {

    public List<Integer> squares(List<Integer> integers) {
        System.out.println("Inside squares of SquareImpl");
        return integers
                .stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
    }
}
