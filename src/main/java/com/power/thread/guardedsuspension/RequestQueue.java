package com.power.thread.guardedsuspension;

import java.util.LinkedList;

public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList();

    public synchronized Request getRequest() {
        while ( queue.size() <= 0 ) { //가드 조건
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.removeFirst();
    }

    public synchronized void putRequest(Request request) {
        queue.addLast(request);
        notifyAll();
    }
}
