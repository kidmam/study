package com.power.study;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Function;

public class GenericsIntersection {

    interface Hello {
        default void hello() {
            System.out.println("Hello");
        }
    }

    interface Hi {
        default void hi() {
            System.out.println("Hi");
        }
    }

    interface Printer {
        default void printer(String str) {
            System.out.println(str);
        }
    }

    interface DelegateTo<T> {
        T delegate();
    }

    interface Hello2 extends DelegateTo<String> {
        default void hello() {
            System.out.println("Hello, " + delegate());
        }
    }

    interface UpperCase extends DelegateTo<String> {
        default void upperCase() {
            System.out.println(delegate().toUpperCase());
        }
    }

    public static void main(String[] args) {
//        Function<String, String> f = new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };

//        hello(new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        });

//        hello( (String s) ->
//                return s
//             );

        //marker interface (Serializable)



        run( (DelegateTo<String> & Hello2 & UpperCase) () -> "홍길동", o -> {
            o.hello();
            o.upperCase();
        });

    }


    private static <T extends DelegateTo<S>, S> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    /*private static <T extends Function> void run(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }*/

   /* private static <T extends Function & Hello & Hi> void hello(T t) {
        t.hello();
        t.hi();
    }*/
}
