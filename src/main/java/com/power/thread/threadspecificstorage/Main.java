package com.power.thread.threadspecificstorage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("BEGIN");

        for (int i = 0; i < 10 ; i++) {
            Log.println("main i = " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.close();

        log.info("END");
    }
}
