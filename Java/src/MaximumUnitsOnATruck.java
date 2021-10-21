//Success
package com.company;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> a[1] > b[1] ? -1 : 1);
        int units = 0;

        for(int[] box : boxTypes){
            while(box[0] > 0){
                if(truckSize == 0){
                    return units;
                }
                box[0]--;
                units += box[1];
                truckSize--;
            }
        }

        return units;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(new MaximumUnitsOnATruck().maximumUnits(boxTypes, 10));

    }
}


