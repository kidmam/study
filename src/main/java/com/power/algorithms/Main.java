package com.power.algorithms;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    int Fact(int n) {
        if ( n == 0 )
            return 1;
        else if ( n == 1 )
            return 1;
        else
            return n * Fact( n - 1 );
    }

    int Print(int n) {
        if ( n == 0 )
            return 0;
        else {
            System.out.println(n);
            return Print( n - 1 );
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        log.info(Integer.toString(m.Fact(5)));

        m.Print(10);
    }
}
