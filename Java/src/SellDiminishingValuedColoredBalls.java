package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int index = inventory.length - 1;
        long profits = 0;

        while(true){
            if(index == inventory.length -1 && index == 0){
                while(orders>0){
                    profits += inventory[index]--;
                    orders--;
                }
                break;
            }
            else if(index == inventory.length -1){
                while(inventory[index] > inventory[index -1] && orders > 0 && inventory[index] > 0){
                    profits += inventory[index]--;
                    orders--;
                }

                if(orders == 0) break;
                else index--;
            }
            else if(index == 0){
                while(inventory[index] >= inventory[index + 1] && orders > 0 && inventory[index] > 0){
                    profits += inventory[index]--;
                    orders--;
                }

                if(orders == 0) break;
                else index = inventory.length -1;
            }
            else{
                while(inventory[index] > inventory[index - 1] && inventory[index] >= inventory[index + 1] && orders > 0 && inventory[index] > 0){
                    profits += inventory[index]--;
                    orders--;
                }

                if(orders == 0) break;
                else index = inventory[index - 1] == inventory[index + 1] ? index-1: index +1;
            }
        }

        return (int)(profits%1000000007);
    }
}
