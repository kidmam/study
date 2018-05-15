package com.power.study;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class PubSub {

    public static void main(String[] args) {

        Publisher<Integer> pub = iterPub();


        Subscriber<Integer> sub = new Subscriber<Integer>() {
            public void onSubscribe(Subscription s) {
                log.debug("onSubscribe");
                s.request(Long.MAX_VALUE);
            }

            public void onNext(Integer i) {
                log.debug("onNext", i);

            }

            public void onError(Throwable t) {
                log.debug("onError");
            }

            public void onComplete() {
                log.debug("onComplete");
            }
        };

        pub.subscribe(sub);
    }

    private static Publisher<Integer> iterPub() {
        return new Publisher<Integer>() {
            Iterable<Integer> iter = Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList());

            public void subscribe(Subscriber<? super Integer> sub) {
                sub.onSubscribe(new Subscription() {
                    public void request(long l) {
                        try {
                            iter.forEach( s -> sub.onNext(s));
                            sub.onComplete();
                        } catch (Throwable t) {
                            sub.onError(t);
                        }

                    }

                    public void cancel() {

                    }
                });
            }
        };
    }
}
