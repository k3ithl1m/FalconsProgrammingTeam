import java.util.*;

public class atoi {
	
	public static int atoi(String str) {
		
		int res = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			
			res = res*10 + str.charAt(i) - '0'; //res*10 increases current number one place forward
			
			System.out.println(str.charAt(i));
			
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		
		String abc = "123";
		int num = atoi(abc);
		System.out.println(num);
	}

}
