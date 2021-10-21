//Successful

package com.company;

import java.util.ArrayList;

public class HappyNumber {

    public boolean isHappy(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        return isHappy(n, dp);
    }

    public boolean isHappy(int n, ArrayList<Integer> dp){
        if(n == 1) return true;

        if(dp.contains(n)){
            return false;
        }

        dp.add(n);

        n = getSumOfSquares(n);

        return isHappy(n, dp);
    }

    public int getSumOfSquares(int n){
        ArrayList<Integer> digits = new ArrayList<>();

        while(n > 0){
            digits.add(n%10);
            n /= 10;
        }

        int result = 0;
        for(Integer i : digits){
            result += i * i;
        }

        return result;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();

        System.out.println(hn.isHappy(2));
    }
}
