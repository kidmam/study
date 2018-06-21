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

    static void TowerOfHanoi(int n, char frompeg, char topeg, char auxpeg) {
        if ( n == 1 ) {
            System.out.println("Move disk 1 from peg" + frompeg + " to peg " + topeg);
            return;
        }
        TowerOfHanoi(n-1, frompeg, auxpeg, topeg);
        System.out.println("Move disk 1 from peg" + frompeg + " to peg " + topeg);
        TowerOfHanoi(n-1, auxpeg, topeg, frompeg);
    }


    public static void main(String[] args) {
        Main m = new Main();
        log.info(Integer.toString(m.Fact(4)));

        m.Print(10);

        TowerOfHanoi(10, 'A', 'B', 'C');
    }
}
