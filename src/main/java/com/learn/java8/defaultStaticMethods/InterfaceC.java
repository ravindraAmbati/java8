package com.learn.java8.defaultStaticMethods;

/* @author ravin @date 10-05-2020 @time 20:55 */

public interface InterfaceC {

    default void methodC() {
        System.out.println("methodC of InterfaceC   " + this.getClass().getSimpleName());
    }
}
