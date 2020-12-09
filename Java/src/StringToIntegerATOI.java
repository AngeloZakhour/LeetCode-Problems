//NOT DONE BUT DOABLE JUST LONG. PROBLEM SIMILAR TO REVERSE INTEGER
public class StringToIntegerATOI {

	public static int myAtoi(String str) {
		if(str.length()==0)
			return 0;
		
		str = str.trim();
		int index = 0;
		int result;
		String s = "";
		
		if(str.charAt(0) == '-' || str.charAt(0) == '+') {
			s += str.charAt(0);
			index++;
		}
		
		while(index < str.length() && (int)str.charAt(index) >= 48 && (int)str.charAt(index) <= 57) {
			s += str.charAt(index);
			index++;
		}
			
		if(s.length() == 0 || (s.length()==1 && s.equals("-")) || (s.length()==1 && s.equals("+")))
			return 0;
		
		if(s.length() > 10) {
			
		}
		result = Integer.parseInt(s);
	
		
		
		return result;	
	}
	
	public static void main(String[] args) {
		String str = "-91283472332";
		
		System.out.println(myAtoi(str));
	}
}
