package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumAreaOfCakeAfterHorizontalAndVerticalCuts {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxGapHorizontalLines = 0; // use long in place of int to avoid overflow
        long maxGapVerticalLines = 0;

        long mod = 1000000007;

        for(int i = 0; i < horizontalCuts.length; i++) {
            maxGapHorizontalLines = Math.max(maxGapHorizontalLines, i == 0 ? (long)horizontalCuts[i] : (long)horizontalCuts[i] - (long)horizontalCuts[i - 1]);
        }

        maxGapHorizontalLines = Math.max(maxGapHorizontalLines, (long)h - (long)horizontalCuts[horizontalCuts.length - 1]); // when above FOR loop ends, we will have  MAX upto the last entry of the array but the gap between last entry of array till the end of cake height is considered by this line


        for(int i = 0; i < verticalCuts.length; i++) {
            maxGapVerticalLines = Math.max(maxGapVerticalLines, i == 0 ? (long)verticalCuts[i] : (long)verticalCuts[i] - (long)verticalCuts[i - 1]);
        }

        maxGapVerticalLines = Math.max(maxGapVerticalLines, (long)w - (long)verticalCuts[verticalCuts.length - 1]);

        return (int)((maxGapHorizontalLines * maxGapVerticalLines) % mod);
    }

    public static void main(String[] args) {

    }
}
