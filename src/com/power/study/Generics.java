package com.power.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(max(list));

        reverse(list);
        System.out.println(list);
    }

    /*private static <T extends Comparable<T>> T max(List<T> list) {
        return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b).get();
    }*/

    //super : 하위 한정(경계) -> output, extends : 상위 한정(경계) -> input
    private static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        return list.stream().reduce((a,b) -> a.compareTo(b) > 0 ? a : b).get();
    }

//    static <T> void reverse(List<T> list) {
//        List<T> temp = new ArrayList<>(list);
//        for (int i=0; i < list.size(); i++ ) {
//            list.set(i, temp.get(list.size() - i - 1));
//        }
//    }

    static void reverse(List<?> list) {
//        List<?> temp = new ArrayList<>(list);
//        for (int i=0; i < list.size(); i++ ) {
//            list.set(i, temp.get(list.size() - i - 1));
//        }
        
        reverseHelper(list);
    }

    private static <T> void reverseHelper(List<T> list) {
        List<T> temp = new ArrayList<>(list);
        for (int i=0; i < list.size(); i++ ) {
            list.set(i, temp.get(list.size() - i - 1));
        }

    }
}
