package com.power.thread.balking;

public class Main {

    public static void main(String[] args) {
        Host host = new Host(1000);

        try {
            System.out.println("execute BEGIN");
            host.execute();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
