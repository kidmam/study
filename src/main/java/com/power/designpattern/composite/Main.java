package com.power.designpattern.composite;

public class Main {

    public static void main(String[] args) throws FileTreatmentExcetion {
        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        rootDir.add(binDir);
        rootDir.printList();
    }
}
