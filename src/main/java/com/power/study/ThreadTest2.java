package com.power.study;

import java.util.Iterator;
import java.util.Map;

public class ThreadTest2 extends Thread {
    public ThreadTest2(String name) {
        super(name);
    }

    @Override
    public void run() {
        Map<Thread, StackTraceElement[]> map = getAllStackTraces();
        Iterator<Thread> it = map.keySet().iterator();
        int x = 0;

        while(it.hasNext()) {
            Object obj = it.next();
            Thread t = (Thread) obj;

            StackTraceElement[] ste = map.get(obj);
            System.out.println("[" + (++x) + "] name : " + t.getName() + ", group : " + t.getThreadGroup().getName() + ", isDaemon : " + t.isDaemon() );

            for (int i = 0; i < ste.length; i++) {
                System.out.println(ste[i]);
            }
            System.out.println();
        }
    }
}
