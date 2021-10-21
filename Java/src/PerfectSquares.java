//#279
package com.company;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    public int numSquares(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(((Math.sqrt(n) * 100) % 100) == 0) return 1;

        List<Integer> squares = getSquares(n);

        int[][] counts = new int[n][squares.size()];

        for(Integer i : squares){

        }

        return 0;
    }

    public List<Integer> getSquares(int n){

        List<Integer> list = new ArrayList<Integer>();

        for(int i=1; i*i<n; i++){
            list.add(i*i);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(10000));
    }
}
