package com.power.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintThread extends Thread {
    private String message;

    public PrintThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            //System.out.println(message);
            log.info(message);
        }
    }
}
