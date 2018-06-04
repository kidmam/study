package com.power.designpattern.templatemethod;

public class Main {

    public static void main(String[] args) {
        AbstractDisplay charDisplay = new CharDisplay('a');
        charDisplay.display();

        AbstractDisplay stringDisplay = new StringDisplay("Hello, World");
        stringDisplay.display();
    }

}
