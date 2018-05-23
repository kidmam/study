package com.power.fp;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Main {

    public static List<List<Integer>> subsets(List<Integer> list) {

        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }

        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());

        List<List<Integer>> subans = subsets(rest);
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();

        for ( List<Integer> list: lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    private static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2) {
        List<List<Integer>> r = new ArrayList<>(subans);
        r.addAll(subans2);
        return r;
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1, 4, 9);
        List<List<Integer>> lists = subsets(a);

        log.info(lists.toString());

        /*for ( List<Integer> list: lists) {
            for ( Integer value: list) {
                log.info( "value : " + value);
            }
        }*/
    }
}
