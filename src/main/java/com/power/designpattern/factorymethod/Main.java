package com.power.designpattern.factorymethod;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product card1 = factory.createProduct("홍길동");
        Product card2 = factory.createProduct("이순신");
        Product card3 = factory.createProduct("강감찬");

        card1.use();
        card2.use();
        card3.use();

        for (String owner: ((IDCardFactory) factory).getOwners()) {
            System.out.println("사용자는 " + owner);
        }

    }
}
