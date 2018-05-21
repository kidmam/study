package com.power.thread;

public class CPUCores {

    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU cores: " + processors);
    }
}
