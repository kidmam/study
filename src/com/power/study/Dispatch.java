package com.power.study;

import java.util.Arrays;
import java.util.List;

public class Dispatch {

    /*static class Service {

        //static dispatch
        void run() {
            System.out.println("run()");
        }

        //static dispatch
        void run(String msg) {
            System.out.println("run(" + msg + ")");
        }
    }*/

    static abstract class Service {
        abstract void run();
    }

    static class MyService1 extends Service {

        @Override
        void run() {
            System.out.println("run1");
        }
    }

    static class MyService2 extends Service {

        @Override
        void run() {
            System.out.println("run2");
        }
    }

    public static void main(String[] args) {
        //new Service().run();
        //new Service().run("Dispatch");

        MyService1 svc1 = new MyService1();
        svc1.run();

        MyService2 svc2 = new MyService2();
        svc2.run();

        Service svc = new MyService1();
        //dynamic dispatch
        svc.run(); //receiver parameter

        List<Service> serviceList = Arrays.asList(new MyService1(), new MyService2());
        //serviceList.forEach(s -> s.run());
        serviceList.forEach(Service::run);

        /*
        Method Signature
         (name, parameter types)

        Method Type
         (return type, method type parameter, method argument types, exception) => Method Reference
         */
    }
}
