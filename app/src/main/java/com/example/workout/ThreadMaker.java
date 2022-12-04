package com.example.workout;

public class ThreadMaker {
    public static void background(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
