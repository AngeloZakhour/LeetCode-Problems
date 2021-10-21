package com.company;

//SUCCESSFUL
public class ZigZagConversion {
	public static String convert(String s, int numRows) {
		if(numRows == 1 || s.length()<=2 || numRows >= s.length()) {
			return s;
		}
		
		int extRowSkip = (numRows*2)-2;
		int primSkip = extRowSkip-2;
		int secSkip = 2;
		boolean extremeRows = true, useSecSkip = true;
		int startingIndex=0, currentIndex=0;
		String result = "";
		
		while(startingIndex < numRows && startingIndex >= s.length()) {
			result += s.charAt(startingIndex);
			System.out.println("Row: "+startingIndex);
			System.out.println("result beginning of loop: "+result);
			
			if(extremeRows) {
				currentIndex = startingIndex + extRowSkip;
			}else {
				currentIndex = startingIndex + primSkip;
				useSecSkip = true;
			}
			System.out.println("Index before innerloop: "+currentIndex);
			while(currentIndex < s.length()) {
				result += s.charAt(currentIndex);
				System.out.println("result beginning of innerloop: "+result);
				
				if(extremeRows) {
					currentIndex += extRowSkip;
				}
				else if(useSecSkip){
					currentIndex += secSkip;
					useSecSkip = false;
				}
				else {
					currentIndex += primSkip;
					useSecSkip = true;
				}
			}
			
			if(!extremeRows) {
				primSkip -= 2;
				secSkip += 2;
			}
			
			startingIndex++;
			if(startingIndex == numRows-1)
				extremeRows = true;
			else
				extremeRows = false;
			
		}
		
		return result;	
	}
	
	public static void main(String[] args) {
		String s = "PAYPAL";
		
		System.out.println(convert(s, 8));
		
		//"PAYPALISHIRING"
		//"PAHNAPLSIIGYIR"
		
		/*
		 * P A H N
		 * APLSIIG
		 * Y I R
		 */
		
	}
}
