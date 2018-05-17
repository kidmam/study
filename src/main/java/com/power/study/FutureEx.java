package com.power.study;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.*;

@Slf4j
public class FutureEx {

    interface SuccessCallback {
        void onSuccess(String result);
    }

    interface ExceptionCallback {
        void onError(Throwable t);
    }

    public static class CallbackFutureTask extends FutureTask<String > {
        SuccessCallback sc;
        ExceptionCallback ec;

        public CallbackFutureTask(Callable<String> callable, SuccessCallback sc, ExceptionCallback ec) {
            super(callable);

            //if ( sc == null ) throw null;

            this.sc = Objects.requireNonNull(sc);
            this.ec = Objects.requireNonNull(ec);
        }

        @Override
        protected void done() {
            try {
                sc.onSuccess(get());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                ec.onError(e.getCause());
            }
        }
    }

    //비동기 작업
    //Future
    //CallBack
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newCachedThreadPool();

        /*es.execute( () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("Hello");
        });*/

        CallbackFutureTask f = new CallbackFutureTask( () -> {
            Thread.sleep(2000);
            if (1==1) throw new RuntimeException("Async ERROR!!");

            log.debug("Async");
            return "Helllo";
        }, s -> System.out.println(s), e -> System.out.println(e.getMessage()));

        /*FutureTask<String> ft = new FutureTask<String>( () -> {
            Thread.sleep(2000);
            log.debug("Async");
            return "Helllo";
        }) {
            @Override
            protected void done() {
                try {
                    System.out.println(get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };*/

        es.execute(f);
        es.shutdown();

        /*Future<String> f = es.submit( () -> {
            Thread.sleep(2000);
            log.debug("Async");
            return "Helllo";
        });*/

        /*System.out.println(f.isDone());
        Thread.sleep(2100);

        log.debug("Exit");
        System.out.println(f.isDone());
        System.out.println(f.get()); //Future get은 Blocking*/

    }
}
