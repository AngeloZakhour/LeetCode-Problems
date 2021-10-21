//Not Done
package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] canTake = new boolean[numCourses];

        Arrays.sort(prerequisites, Comparator.comparingInt(a -> a[0]));

        for(int[] pr : prerequisites){

        }
        return false;
    }

}
