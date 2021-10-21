//Successful
package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class KCLosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        double[][] distances = new double[points.length][2];

        for(int i =0; i < points.length; i++){
            distances[i][0] = i;
            distances[i][1] = Math.sqrt((Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
        }

        Arrays.sort(distances, Comparator.comparingDouble(a -> a[1]));

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = points[(int)distances[i][0]];
        }

        return result;
    }
}
