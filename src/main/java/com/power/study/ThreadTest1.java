package com.power.study;

public class ThreadTest1 extends Thread{

    public ThreadTest1(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
