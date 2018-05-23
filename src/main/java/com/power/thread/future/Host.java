package com.power.thread.future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Host {

    public Data request(final int count, final char c) {
        //System.out.println("request(" + count + ", " + c + ") BEGIN");
        log.info("request(" + count + ", " + c + ") BEGIN");
        final FutureData future = new FutureData();

        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                future.setRealData(realData);
            }
        }.start();

        log.info("request(" + count + ", " + c + ") END");
        return future;
    }
}
