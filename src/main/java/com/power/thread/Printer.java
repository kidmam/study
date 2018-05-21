package com.power.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Printer implements Runnable {

    private String message;

    public Printer(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            //System.out.println(message);
            log.info(message);
        }
    }
}
