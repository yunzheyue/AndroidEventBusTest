package com.example.app1.handler;

public abstract class HandlerThread {

    private final String name;

    public HandlerThread(String name) {
        this.name=name;
    }

    public synchronized void start() {
    }
}
