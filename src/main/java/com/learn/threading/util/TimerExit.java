package com.learn.threading.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExit {

    private final long millis;
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.printf("Program has been exit after %s milliseconds", millis);
            System.exit(0);
        }
    };

    public TimerExit(long millis) {
        this.millis = millis;
    }

    public void exitProgram() {
        timer.schedule(timerTask, new Date(System.currentTimeMillis() + millis));
    }
}
