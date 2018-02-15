/**
 * Code forces Competition 462 Problem A codeforces.com/contest/934
 */
import java.util.*;

public class CF462A {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), m = sc.nextInt();
		long[] ar = new long[n];
		long[] b = new long[m];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextLong();
		}
		
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextLong();
		}
		long ans =Long.MIN_VALUE;
		long[] aa = new long[n];
		for (int i = 0; i < n; i++) {
			ans = Long.MIN_VALUE;
			
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, ar[i] * b[j]);
			}
			aa[i] = ans;
		}
		Arrays.sort(aa);
		
		System.out.println(aa[n-2]);
		
		sc.close();
	}
}
