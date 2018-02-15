import java.util.*;

public class TheCoinChangeProblem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int N = sc.nextInt();
		
		int[] ar = new int[N];
		
		for (int i = 0; i < N; i++) {
			ar[i] = sc.nextInt();
		}
		
		int count = 0;
		Arrays.sort(ar);
		int[] ways = new int[N];
		
	}
	
	
	public static int sol(int[] ar, int C, int count, int[] ways) {
		if (C == 0) return 0;
		if (C > 0) {
			for (int i = 0; i < ar.length; i++) { 
				
			}
		}
		
		
		return 0; 
	}
	
}
