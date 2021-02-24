package com.learn.threading.daemon;

public class App {

    public static void main(String[] args) {

        Thread daemon = new Thread(new DaemonRunnable());
        if (!daemon.isDaemon()) {
            daemon.setDaemon(true);
        }

        Thread worker = new Thread(new WorkerRunnable());

        daemon.start();
        worker.start();
    }
}
