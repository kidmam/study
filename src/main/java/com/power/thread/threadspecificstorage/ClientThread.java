package com.power.thread.threadspecificstorage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientThread extends Thread {

    public ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        log.info(getName() + " BEGIN");

        for (int i = 0; i < 10; i++) {
            Log.println("i = " + 1);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Log.close();

        log.info(getName() + " END");
    }
}
