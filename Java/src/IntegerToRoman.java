package com.company;

//SUCCESSFUL
public class IntegerToRoman {

	public static String intToRoman(int num) {
		String result="";
		
		switch(num/1000) {
		case 1: result+="M";break;
		case 2: result+="MM";break;
		case 3: result+="MMM";break;
		}
		
		switch((num/100)%10) {
		case 1: result+="C";break;
		case 2: result+="CC";break;
		case 3: result+="CCC";break;
		case 4: result+="CD";break;
		case 5: result+="D";break;
		case 6: result+="DC";break;
		case 7: result+="DCC";break;
		case 8: result+="DCCC";break;
		case 9: result+="CM";break;
		}
		
		switch((num/10)%10) {
		case 1: result+="X";break;
		case 2: result+="XX";break;
		case 3: result+="XXX";break;
		case 4: result+="XL";break;
		case 5: result+="L";break;
		case 6: result+="LX";break;
		case 7: result+="LXX";break;
		case 8: result+="LXXX";break;
		case 9: result+="XC";break;
		}
		
		switch(num%10) {
		case 1: result+="I";break;
		case 2: result+="II";break;
		case 3: result+="III";break;
		case 4: result+="IV";break;
		case 5: result+="V";break;
		case 6: result+="VI";break;
		case 7: result+="VII";break;
		case 8: result+="VIII";break;
		case 9: result+="IX";break;
		}
		
		return result;
		
		
	}
	
	public static void main(String[] args) {
		int num = 1994;
		
		System.out.println(intToRoman(num));
	}
}
