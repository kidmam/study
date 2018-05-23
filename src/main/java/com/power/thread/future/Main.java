package com.power.thread.future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    //Future 패턴은 시간이 걸리는 처리를 포함하고 있는 보통의 클래스에 대해서 교환권을 만들어 주고 멀티 쓰레드화해서 수행 능력을 높이는 패턴
    public static void main(String[] args) {
        //System.out.println("main BEGIN");
        log.info("main BEGIN");

        Host host = new Host();

        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        //System.out.println("main OtherJob BEGIN");
        log.info("main OtherJob BEGIN");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println("main OtherJob END");
        log.info("main OtherJob END");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());

        //System.out.println("main END");
        log.info("main END");
    }
}
