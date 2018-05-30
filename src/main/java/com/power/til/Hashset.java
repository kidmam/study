package com.power.til;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

    public static void main(String[] args) {

        HashSet<String> set=new HashSet<>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        for ( String val: set) {
            System.out.println("val => " + val);
        }

        set.forEach( v -> System.out.println("Value -> " + v));
    }
}
