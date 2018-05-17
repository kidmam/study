package com.power.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class LoadTest {

    static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {

        ExecutorService ec = Executors.newFixedThreadPool(100);

        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8080/rest";

        StopWatch main = new StopWatch();
        main.start();

        for ( int i=0; i < 100; i++) {
            ec.execute( () -> {
                int idx = counter.addAndGet(1);
                log.info("Thread {}", idx);

                StopWatch sw = new StopWatch();
                sw.start();

                rt.getForObject( url, String.class);

                sw.stop();
                log.info("Elapsed: {} {}", idx, sw.getTotalTimeSeconds());
            });
        }

        main.stop();
        log.info("Total {}", main.getTotalTimeSeconds());
    }
}
