package com.company;

//SUCCESSFUL
public class PlusOne {

	public static int[] plusOne(int[] digits) {
		int index = digits.length-1;
		int[] result = new int[digits.length];
		
		do {
			if(digits[index]==9) {
				result[index] =0;
				index--;
				if(index==-1) {
					result = new int[digits.length+1];
					result[0] = 1;
					break;
				}
				continue;
			}
			else {
				result[index] = digits[index]+1;
				index--;
				break;
			}
		}
		while(index>=0);
		
		while(index>=0) {
			result[index] = digits[index];
			index--;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] digits = {9};
		
		int[] solution = plusOne(digits);
		
		for(int i: solution) {
			System.out.print(i);
		}
	}
}
