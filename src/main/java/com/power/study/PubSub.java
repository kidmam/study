package com.power.study;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Slf4j
public class PubSub {

    public static void main(String[] args) {
        Publisher<Integer> pub = iterPub(Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList()));

        //Publisher<Integer> mapPub = mapPub(pub, s -> s * 10);
        //Publisher<Integer> mapPub2 = mapPub(mapPub, s -> -s);

        //mapPub2.subscribe(logSub());

        Publisher<Integer> sumPub = sumPub(pub);
        sumPub.subscribe(logSub());
    }

    private static Publisher<Integer> reducePub(Publisher<Integer> pub, int init, BiFunction<Integer, Integer, Integer> bf) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> sub) {

                pub.subscribe(new DelegateSub(sub) {
                    int result = 0;

                    @Override
                    public void onNext(Integer i) {
                        result = bf.apply(result, i);
                    }

                    @Override
                    public void onComplete() {
                        sub.onNext(result);
                        sub.onComplete();
                    }
                });

            }
        };
    }

    private static Publisher<Integer> sumPub(Publisher<Integer> pub) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> sub) {
                pub.subscribe(new DelegateSub(sub) {
                    int sum = 0;

                    @Override
                    public void onNext(Integer i) {
                        sum += 1;
                    }

                    @Override
                    public void onComplete() {
                        sub.onNext(sum);
                        sub.onComplete();
                    }
                });
            }
        };

    }

    private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> f) {
        return new Publisher<Integer>() {
            @Override
            public void subscribe(Subscriber<? super Integer> sub) {
                pub.subscribe(new DelegateSub(sub) {

                    @Override
                    public void onNext(Integer i) {
                        sub.onNext(f.apply(i));
                    }
                });

            }
        };
    }

    private static Subscriber<Integer> logSub() {
        return new Subscriber<Integer>() {
            public void onSubscribe(Subscription s) {
                log.debug("onSubscribe:");
                s.request(Long.MAX_VALUE);
            }

            public void onNext(Integer i) {
                log.debug("onNext:", i);

            }

            public void onError(Throwable t) {
                log.debug("onError");
            }

            public void onComplete() {
                log.debug("onComplete:");
            }
        };
    }

    private static Publisher<Integer> iterPub(final List<Integer> iter) {
        return new Publisher<Integer>() {
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
