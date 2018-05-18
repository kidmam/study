package com.power.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class LoadTest {

    static AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        ExecutorService es = Executors.newFixedThreadPool(101);

        RestTemplate rt = new RestTemplate();
        String url = "http://localhost:8080/rest";

        CyclicBarrier barrier = new CyclicBarrier(100); //스레드 동기화

        //StopWatch main = new StopWatch();
        //main.start();

        for ( int i=0; i < 100; i++) {
            /*es.execute( () -> {
                int idx = counter.addAndGet(1);
                log.info("Thread {}", idx);

                StopWatch sw = new StopWatch();
                sw.start();

                rt.getForObject( url, String.class);

                sw.stop();
                log.info("Elapsed: {} {}", idx, sw.getTotalTimeSeconds());
            });*/

            es.submit( () -> {
                int idx = counter.addAndGet(1);

                barrier.await();

                log.info("Thread {}", idx);

                StopWatch sw = new StopWatch();
                sw.start();

                rt.getForObject( url, String.class);

                sw.stop();
                log.info("Elapsed: {} {}", idx, sw.getTotalTimeSeconds());

                return null;
            });
        }

        barrier.await();

        StopWatch main = new StopWatch();
        main.start();

        es.shutdown();
        es.awaitTermination(100, TimeUnit.SECONDS);

        main.stop();
        log.info("Total {}", main.getTotalTimeSeconds());


    }
}
