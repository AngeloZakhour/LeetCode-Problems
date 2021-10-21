package com.company;

//SUCCESSFUL
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		/*int maxArea = 0;
		int area;
		
		for(int i=0; i<height.length; i++) {
			for(int j=i+1; j<height.length; j++) {
				area = Math.min(height[i], height[j])*(j-i);
				
				if(area > maxArea)
					maxArea = area;
			}
		}
		
		return maxArea;*/
		
		//More efficient way of doing it
		int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        
        return maxarea;
	}
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		
		System.out.println(maxArea(height));
	}
}
