package com.power.rxjava;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;

import java.util.concurrent.TimeUnit;

@Slf4j
public class rxJava {

    public static void main(String[] args) {
        /*Observable
                .timer(1, TimeUnit.SECONDS)
                .subscribe( (Long zero) -> log.info("zero => " + zero.toString()));

        Observable
                .interval(1_000_000 / 60, TimeUnit.MICROSECONDS)
                .subscribe( (Long i) -> log.info("i => " + i.toString()));*/

        log.info("Start");

        Observable<String> strings = Observable.just("He#123llo");
        //Observable<String> filtered = strings.filter( s -> s.startsWith("#"));
        strings.subscribe(s -> log.info("s = " + s));

        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable<String> observable = Observable.from(letters);

        //final String result = "";
        observable.subscribe(
                i -> log.info( "i => " + i),  //OnNext
                Throwable::printStackTrace, //OnError
                () -> log.info("_Completed") //OnCompleted
        );
        //log.info("result = " + result);

        log.info("End");
    }
}
