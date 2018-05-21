package com.power.thread.guardedsuspension;

import java.util.Random;

public class ServerThread extends Thread {

    private Random random;
    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, Long seed) {
        super(name);
        this.requestQueue = requestQueue;
        random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
    }
}
