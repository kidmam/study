package com.power.thread.immutable;

import com.power.thread.PrintThread;

public class Main {

    public static void main(String[] args) {

        Person alice = new Person("Alice", "Alaska");

        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }
}
