package com.power.designpattern.adapter;

public class Main {
    //이미 제공되어 있는 것과 필요한 것 사이의 차이를 없애주는 디자인 패턴
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
