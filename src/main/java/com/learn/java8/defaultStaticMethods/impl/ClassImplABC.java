package com.learn.java8.defaultStaticMethods.impl;

/* @author ravin @date 10-05-2020 @time 20:58 */

import com.learn.java8.defaultStaticMethods.InterfaceA;
import com.learn.java8.defaultStaticMethods.InterfaceB;
import com.learn.java8.defaultStaticMethods.InterfaceC;

public class ClassImplABC implements InterfaceA, InterfaceB, InterfaceC {

    @Override
    public void methodA() {
        System.out.println("methodA of ClassImplABC   " + this.getClass().getSimpleName());
    }
}
