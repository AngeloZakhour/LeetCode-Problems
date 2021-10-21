//Successful
package com.company;

public class RobotBoundedInCircle {

    public static boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dirX = 0, dirY = 1;

        for(char c : instructions.toCharArray()){
            int temp;
            switch (c) {
                case 'L' -> {
                    temp = dirY;
                    dirY = dirX;
                    dirX = -temp;
                }
                case 'R' -> {
                    temp = dirX;
                    dirX = dirY;
                    dirY = -temp;
                }
                case 'G' -> {
                    x += dirX;
                    y += dirY;
                }
            }
        }

        if((x==0 && y==0) || (dirX != 0 || dirY != 1)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
