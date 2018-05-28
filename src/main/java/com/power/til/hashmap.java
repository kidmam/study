package com.power.til;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class hashmap {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Kotlin");

        Iterator<Integer> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            Integer key = keys.next();
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
        }

        for( Integer key : map.keySet() ){
            System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        //

        Map<Employee, String> map2 = new HashMap<>();
        map2.put(new Employee(1, "Raemsh"), "Java");
        map2.put(new Employee(2, "Sathish"), "Angular");

        for (Map.Entry<Employee, String> entry : map2.entrySet()) {
            Employee employee = entry.getKey();
            log.info(employee.getName());
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        map2.forEach( (k, v) -> log.info(k.getName() + " " + v));

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach( (k, v) -> System.out.println("Item : " + k + " Count : " + v));
        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });

        List<String> itemsList = new ArrayList<>();
        itemsList.add("A");
        itemsList.add("B");
        itemsList.add("C");
        for ( String item : itemsList) {
            log.info(item);
        }

        //lambda
        itemsList.forEach( item -> log.info(item));

        ////method reference
        itemsList.forEach(System.out::println);

        //Stream and filter
        itemsList.stream()
                .filter( s -> s.contains("B"))
                .forEach(System.out::println);

    }
}
