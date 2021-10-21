package com.company;

//SUCCESSFUL
public class StringToIntegerATOI {

	public static int myAtoi(String str) {
		int sign;
		long temp_result;

		str = str.trim();

		if(str.length() == 0){
			return 0;
		}

		if(str.charAt(0) == '-'){
			sign = -1;
			str = str.substring(1);
		}
		else if(str.charAt(0) == '+'){
			sign = 1;
			str = str.substring(1);
		}
		else{
			sign = 1;
		}

		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c < 48 || c > 57){
				str = str.substring(0, i);
				break;
			}
		}

		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) != '0' || i+1 == str.length()){
				str = str.substring(i);
				break;
			}

		}

		if(str.length() > 10){
			if(sign == -1){
				return -2147483648;
			}
			else{
				return 2147483647;
			}
		}

		if(str.length() == 0){
			return 0;
		}

		temp_result = Long.parseLong(str) * sign;

		if (temp_result > 2147483647){
			return 2147483647;
		}
		else if(temp_result < -2147483648){
			return -2147483648;
		}
		else{
			return (int)temp_result;
		}
	}
	
	public static void main(String[] args) {
		String str = "-91283472332";
		
		System.out.println(myAtoi(str));
	}
}
