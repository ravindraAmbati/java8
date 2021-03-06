package com.learn.java8.lambdas;

/* @author ravin @date 02-05-2020 @time 15:56 */

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class RunnableImplTest {

    @Test
    void runImpl_Java7() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("runImpl_Java7");
            }
        };
        new Thread(runnable).start();
    }

    @Test
    void runImplInThread_Java7() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("runImpl_Java7 in thread");
            }
        }).start();
    }

    @Test
    void runImpl() {
        Runnable runnable = () -> {
            log.info("runImpl");
        };
        new Thread(runnable).start();
    }

    @Test
    void runImplInThread() {
        new Thread(() -> {
            log.info("runImpl in thread");
        }).start();
    }

    @Test
    void runImplInThreadSingleLine() {
        new Thread(() -> log.info("runImpl in thread in single line")).start();
    }

    @Test
    void runImplInThreadMultiLine() {
        new Thread(() -> {
            log.info("runImpl ");
            log.info("in thread ");
            log.info("in single line");
        }).start();
    }
}
