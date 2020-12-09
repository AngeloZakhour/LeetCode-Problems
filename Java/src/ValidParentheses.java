//SUCCESSFUL
public class ValidParentheses {

	public static boolean isValid(String s) {
		if(s.length() == 0)
			return true;
		
		char[] stack = new char[s.length()];
		int stackIndex = 0;
		char c;
		
		for(int i=0; i<s.length() && stackIndex<stack.length; i++) {
			c = s.charAt(i);
			if(c == '(' || c == '[' || c == '{') {
				stack[stackIndex] = s.charAt(i);
				stackIndex++;
				continue;
			}
			if(c == ')') {
				if(stackIndex == 0 || stack[stackIndex-1] != '(')
					return false;
				else {
					stackIndex--;
					continue;
				}
			}
			if(c == '}') {
				if(stackIndex == 0 || stack[stackIndex-1] != '{')
					return false;
				else {
					stackIndex--;
					continue;
				}
			}
			if(c == ']') {
				if(stackIndex == 0 || stack[stackIndex-1] != '[')
					return false;
				else {
					stackIndex--;
					continue;
				}
			}	
		}
		
		if(stackIndex != 0) 
			return false;
		
		return true;
		
	}
	
	public static void main(String[] args) {
		String s = "";

		System.out.println(isValid(s));
	}
}
