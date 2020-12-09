//SUCCESSFUL
public class ReverseInteger {

	public static int reverse(int x) {
		int result = 0, t = x;
		boolean negative = x<0;
		
		if(x == -2147483648)
			return 0;
		
		x = Math.abs(x);
		
		while(x != 0) {
			t = x%10;
			x /= 10;
			
			if(result/100000000 >0) {
				if(result>214748364 || (result==214748364 && t > 7 && !negative) || (result==214748364 && t > 8 && negative))
					return 0;
				
				if(result==214748364 && t == 8 && negative) {
					result *= -1;
					t *= -1;
					negative = false;
				}
			}
			
			result = (result*10) + t;
			System.out.println("Result in the loop: "+result);
		}
		
		if(negative) {
			result *= -1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int x = 1147483647;
		
		int y = reverse(x);
		
		System.out.println(y);
		
	}
}
