//solution works but is too time consuming

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestTimeToBuyandSellStockwithCooldown {
//    public static int[][] sellingProfits = null;
//    public static int[] totals = null;
//
//    public static int maxProfit(int[] prices) {
//        if(prices.length == 1) return 0;
//        if(alwaysDecreasing(prices)) return 0;
//
//        sellingProfits = new int[prices.length][];
//        sellingProfits[0] = new int[]{0};
//
//        totals = new int[prices.length];
//        totals[0] = 0;
//
//        for(int i=1; i<prices.length; i++){
//            sellingProfits[i] = new int[i];
//
//            for(int j = 0; j<sellingProfits[i].length; j++){
//                sellingProfits[i][j] = prices[i] - prices[j];
//            }
//        }
//
//
//        return recursiveProfits(prices.length - 1);
//    }
//
//    public static int recursiveProfits(int currentIndex){
//        int maxSellingTotal = 0;
//        int skippingTotal = 0;
//
//        for(int i = sellingProfits[currentIndex].length -1; i >=0; i--){
//            int sellingTotal = sellingProfits[currentIndex][i];
//
//            if(i - 2 >= 0){
//                sellingTotal += recursiveProfits(i - 2);
//            }
//            maxSellingTotal = Math.max(sellingTotal, maxSellingTotal);
//        }
//
//        if(currentIndex - 1 >= 0){
//            skippingTotal += recursiveProfits(currentIndex - 1);
//        }
//
//        return Math.max(maxSellingTotal, skippingTotal);
//    }
//
//
//    public static boolean alwaysDecreasing(int[] prices){
//
//        for(int i=1; i<prices.length; i++){
//            if(prices[i] > prices[i-1]){
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static int maxProfit(int[] prices) {
        HashMap<String, Integer> dp = new HashMap<>();
        //0 to indicate buy, 1 to indicate sell
        return maxProfit(0, 0, prices, dp);
    }
    public static int maxProfit(int idx, int buyOrSell, int[] prices, HashMap<String, Integer> dp){
        if(idx >= prices.length) return 0;

        int profit = 0;
        //preparing unique key for memoisation
        String key = idx + "key" + buyOrSell;
        //checking that result has been calculated earlier or not
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        if(buyOrSell == 0){
            //idx+1 because it is possible to sell next day, 1 because next day is sell
            int buy = maxProfit(idx+1, 1, prices, dp) - prices[idx];
            int noBuy = maxProfit(idx+1, 0, prices, dp);
            profit = Math.max(buy, noBuy);
        }else{
            //idx+2 because next day is cooldown, 0 because next to next day is buy
            int sell = maxProfit(idx+2, 0, prices, dp) + prices[idx];
            int noSell = maxProfit(idx+1, 1, prices, dp);
            profit = Math.max(sell, noSell);
        }
        dp.put(key, profit);
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
}
