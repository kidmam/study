package com.power.designpattern.bridge;

public class Main {

    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, World"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, World"));

        d1.display();
        d2.display();
        d3.display();

        d3.multiDisplay(3);
    }
}
