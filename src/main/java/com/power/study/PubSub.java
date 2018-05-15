package com.power.study;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class PubSub {

    public static void main(String[] args) {

        Publisher<Integer> pub = new Publisher<Integer>() {
            public void subscribe(Subscriber<? super Integer> subscriber) {
                subscriber.onSubscribe(new Subscription() {
                    public void request(long l) {

                    }

                    public void cancel() {

                    }
                });
            }
        };


        Subscriber<Integer> sub = new Subscriber<Integer>() {
            public void onSubscribe(Subscription subscription) {

            }

            public void onNext(Integer integer) {

            }

            public void onError(Throwable throwable) {

            }

            public void onComplete() {

            }
        };

    }
}
