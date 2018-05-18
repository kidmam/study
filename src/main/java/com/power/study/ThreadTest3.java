package com.power.study;

public class ThreadTest3 {

    public static void main(String[] args) {
        ThreadTest1 t = new ThreadTest1("First Thread");
        ThreadTest2 t2 = new ThreadTest2("Second Thread");

        t.start();
        t2.start();;
    }
}
