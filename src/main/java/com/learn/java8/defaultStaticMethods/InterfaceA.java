package com.learn.java8.defaultStaticMethods;

/* @author ravin @date 10-05-2020 @time 20:55 */

public interface InterfaceA {

    default void methodA() {
        System.out.println("methodA of InterfaceA   " + this.getClass().getSimpleName());
    }
}
