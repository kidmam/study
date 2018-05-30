package com.power.rxjava;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
public class rxjavaTest {

    static <T> Observable<T> just(T x) {
        return Observable.create(subscriber -> {
            subscriber.onNext(x);
            subscriber.onCompleted();
        });
    }

    static <T> Observable<T> delayed(T x) {
        return Observable.create(
                subscriber -> {
                    Runnable r = () -> {
                        sleep(10, SECONDS);
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(x);
                            subscriber.onCompleted();
                        }
                    };
                    new Thread(r).start();
                });
    }

    static void sleep(int timeout, TimeUnit unit) {
        try {
            unit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        log.info("Before");

        Observable
                .range(5, 3)
                .subscribe(i -> log.info("i -> " + i));

        log.info("After");

// rxjava 1.3.8
//      Observable<Integer> ints = Observable
//              .create(new Observable.OnSubscribe<Integer>() {
//                  @Override
//                  public void call(Subscriber<? super Integer> subscriber) {
//                      log.info("Create");
//                      subscriber.onNext(5);
//                      subscriber.onNext(6);
//                      subscriber.onNext(7);
//                      subscriber.onCompleted();
//                      log.info("Completed");
//                  }
//              });

//        Observable<Integer> ints = Observable
//                .create(subscriber -> {
//                    log.info("Create");
//                    subscriber.onNext(5);
//                    subscriber.onNext(6);
//                    subscriber.onNext(7);
//                    subscriber.onComplete();
//                    log.info("Completed");
//                });

        Observable<Integer> ints = Observable
                .<Integer>create(subscriber -> {
                    log.info("Create");
                    subscriber.onNext(5);
                    subscriber.onNext(6);
                    subscriber.onNext(7);
                    subscriber.onCompleted();
                    log.info("Completed");
                }).cache();

        log.info("Start");
        ints.subscribe(i -> log.info("Element A: " + i));
        ints.subscribe(i -> log.info("Element B: " + i));
        log.info("Exit");

        Observable<String> strJust = just("Hello, World");
        strJust.subscribe(s -> log.info(s));


    }
}
