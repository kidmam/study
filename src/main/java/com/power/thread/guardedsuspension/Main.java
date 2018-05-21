package com.power.thread.guardedsuspension;

//Guarded Suspension: 준비될 때까지 기다려요
public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 3141592L).start();
        new ServerThread(requestQueue, "Bobby", 653597L).start();
    }
}
