package com.power.study;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.instance;
        Singleton2 singleton2 = Singleton2.getInstance();

        Singleton3.INSTANCE.getName();
    }
}
