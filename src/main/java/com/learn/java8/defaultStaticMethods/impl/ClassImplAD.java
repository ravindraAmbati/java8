package com.learn.java8.defaultStaticMethods.impl;

/* @author ravin @date 10-05-2020 @time 21:04 */

import com.learn.java8.defaultStaticMethods.InterfaceA;
import com.learn.java8.defaultStaticMethods.InterfaceD;

public class ClassImplAD implements InterfaceA, InterfaceD {
    @Override
    public void methodA() {
        System.out.println("in ClassImplAD");
    }
}
