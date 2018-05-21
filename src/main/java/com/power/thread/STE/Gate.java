package com.power.thread.STE;
//Single Threaded Execution: 하나의 쓰레드에 의한 실행

import sun.awt.Mutex;

import java.util.concurrent.locks.ReentrantLock;

public class Gate {
    private int counter = 0;
    private String name = "NoBody";
    private String address = "NoWhere";

    //ReentrantLock lock = new ReentrantLock();

    //private final Mutex mutex = new Mutex();

    public synchronized void pass(String name, String address) {
        //synchronized (this) {
        //lock.lock();
            this.counter++;
            this.name = name;
            this.address = address;
            check();
            //lock.unlock();
        //}
    }

    public synchronized String toString() {
        //synchronized (this) {
        //lock.lock();
        try {
            return "No. " + counter + ": " + name + " , " + address;
        } finally {
            //lock.unlock();
        }
        //}
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("****** Broken ********* " + toString());
        }
    }

}
