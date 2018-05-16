package com.power.study;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SchedulerEx {

    public static void main(String[] args) {

        Publisher<Integer> pub = sub -> {
            sub.onSubscribe(new Subscription() {
                @Override
                public void request(long l) {
                    log.debug("request()");
                    sub.onNext(1);
                    sub.onNext(2);
                    sub.onNext(3);
                    sub.onNext(4);
                    sub.onNext(5);
                    sub.onComplete();
                }

                @Override
                public void cancel() {

                }
            });

        };
        //pub

        Publisher<Integer> subOnPub = sub -> {
            //pub.subscribe(sub);
            ExecutorService es = Executors.newSingleThreadExecutor( new CustomizableThreadFactory() {
                @Override
                public String getThreadNamePrefix() {
                    return "subOn-";
                }
            });

            /*es.execute(new Runnable() {
                @Override
                public void run() {
                    pub.subscribe(sub);
                }
            });*/

            es.execute( () -> pub.subscribe(sub));
        };

        Publisher<Integer> pubOnsub = sub -> {
            subOnPub.subscribe(new Subscriber<Integer>() {
                ExecutorService es = Executors.newSingleThreadExecutor( new CustomizableThreadFactory() {
                    @Override
                    public String getThreadNamePrefix() {
                        return "pubOn-";
                    }
                });

                @Override
                public void onSubscribe(Subscription s) {
                    sub.onSubscribe(s);
                }

                @Override
                public void onNext(Integer integer) {
                    es.execute( () -> sub.onNext(integer) );
                }

                @Override
                public void onError(Throwable throwable) {
                    es.execute( () ->sub.onError(throwable) );
                }

                @Override
                public void onComplete() {
                    es.execute( () ->sub.onComplete() );
                }
            });

        };

        //sub
        pubOnsub.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                log.debug("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer i) {
                log.debug("onNext:{}", i);

            }

            @Override
            public void onError(Throwable t) {
                log.debug("onError:{}", t);

            }

            @Override
            public void onComplete() {
                log.debug("onComplete");

            }
        });

        System.out.println("Exit");
    }
}
