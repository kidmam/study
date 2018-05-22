package com.power.thread.readwritelock;

import lombok.extern.slf4j.Slf4j;

import java.util.SortedMap;
import java.util.TreeMap;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Boolean.parseBoolean("True");

        SortedMap<String, String> map = new TreeMap<>();
        map.put("2222", "gh2");
        map.put("3333", "gh3");
        map.put("4444", "gh4");
        map.put("1111", "gh1");
        map.put("5555", "gh5");

        map.forEach( (k, v) -> System.out.println(k + " | " + v) );

    }
}
