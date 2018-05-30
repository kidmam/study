package com.power.til;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.LinkedHashSet;

@Slf4j
public class LinkdedHashSet {

    public static void main(String[] args) {

        LinkedHashSet<String> al = new LinkedHashSet<>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        Iterator<String> itr=al.iterator();
        while(itr.hasNext()){
            log.info(itr.next());
        }

    }
}
