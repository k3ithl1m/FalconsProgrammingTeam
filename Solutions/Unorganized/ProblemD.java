import java.util.*;

public class ProblemD {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String br = sc.nextLine();
		
		int LR = 0;
		int count = 0;
		
		if (br.isEmpty()) {
			System.out.println("possible");
		} else if ((br.length() % 2) != 0) {
			System.out.println("impossible");
		} else {
			
			boolean inv = br.charAt(0) == '(';
			
			if (inv == true) {
				LR = 1;
				count++;
			}
			
			while (true) {
				if (LR < 0 || count >= br.length()) {
					break;
				} else {
					if (br.charAt(count) == '(') {
						LR++;
					} else if (br.charAt(count) == ')') {
						LR--;
					}
					count++;
				}
			}
			
			if ((count >= br.length() && LR >= 0) || dp(LR, count, br, !inv) == true) {
				System.out.println("possible");
			} else {
				System.out.println("impossible");
			}
			
		}
		
	}
	
	public static boolean dp(int LR, int count, String br, boolean inv) {
		
		if(count >= br.length()) {
			if (LR != 0) {
				return false;
			} else {
				return true;
			}
		} else {
			
			if (br.charAt(count) == '(' && inv == false) {
				LR++;
			} else if (br.charAt(count) == ')' && inv == false) {
				LR--;
			} else if (br.charAt(count) == '(' && inv == true) {
				LR--;
			} else if (br.charAt(count) == ')' && inv == true) {
				LR++;
			}
		}
		
		return false;
		
	}

}
