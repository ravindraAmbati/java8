package com.learn.java8.defaultStaticMethods;

/* @author ravin @date 10-05-2020 @time 20:09 */

import java.util.List;
import java.util.stream.Collectors;

public interface Square {

    static long size(List<Integer> integers) {
        System.out.println("Inside squares of Square");
        return integers
                .size();
    }

    default List<Integer> squares(List<Integer> integers) {
        System.out.println("Inside squares of Square");
        return integers
                .stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
    }
}
