package com.power.thread.threadspecificstorage;

public class M {

    public static void main(String[] args) {

        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
