package com.power.study;

import static java.lang.Thread.*;

public class ThreadTest implements  Runnable {

    public static boolean autoSave = false;

    @Override
    public void run() {
        while(true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (autoSave) {
                autoSave();

            }
        }
    }

    private void autoSave() {
        System.out.println("It have been saved");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadTest());
        t.setDaemon(true);
        t.start();

        for (int i = 0; i < 20; i++) {
            sleep(1000);
            System.out.println(i);
            if ( i == 5 ) {
                autoSave = true;
            }
        }
        System.out.println("SHut down!");
    }


}
