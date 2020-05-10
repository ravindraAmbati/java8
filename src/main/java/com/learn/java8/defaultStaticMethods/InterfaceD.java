package com.learn.java8.defaultStaticMethods;

/* @author ravin @date 10-05-2020 @time 20:55 */

public interface InterfaceD {

    default void methodA() {
        System.out.println("methodC " + this.getClass().getSimpleName());
    }
}
