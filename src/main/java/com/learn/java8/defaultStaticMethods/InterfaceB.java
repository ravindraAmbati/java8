package com.learn.java8.defaultStaticMethods;

/* @author ravin @date 10-05-2020 @time 20:55 */

public interface InterfaceB extends InterfaceA {

    default void methodB() {
        System.out.println("methodB of InterfaceB   " + this.getClass().getSimpleName());
    }

    default void methodA() {
        System.out.println("methodA of InterfaceB   " + this.getClass().getSimpleName());
    }
}
