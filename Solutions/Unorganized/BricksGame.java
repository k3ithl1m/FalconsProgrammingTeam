import java.util.*;

public class BricksGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int z = 0; z < T; z++) {
			int N = sc.nextInt();
			int[] ar = new int[N];
			
			for (int l = 0; l < N; l++) {
				ar[l] = sc.nextInt();
			}
			
			long[][] cache = new long[N][2];
			for (int i = 0; i < cache.length; i++)
				Arrays.fill(cache[i], -1);
			
			System.out.println(dp(0, 0, Turn.MYTURN, ar, cache));
		}
		
		sc.close();
	}
	
	public static long dp(int i, int score, Turn t, int[] ar, long[][] cache) {
		
		if (i >= ar.length) return score;
		
		System.out.println("i : " + i + "    score : " + score + "    turn: " + t);
		
		long hold1 = 0, hold2 = 0, hold3 = 0, temp = 0;
		
		int turn_val = 0;
		if (t == Turn.HISTURN) turn_val = 1;
		
		//if (cache[i][turn_val] == -1) {
			if (t == Turn.MYTURN) {
				
				hold1 = dp(i+1, score + ar[i], Turn.HISTURN, ar, cache);
				if (i < ar.length - 1) hold2 = dp(i+2, score + ar[i] + ar[i+1], Turn.HISTURN, ar, cache);
				if (i < ar.length - 2) hold3 = dp(i+3, score + ar[i] + ar[i+1] + ar[i+2], Turn.HISTURN, ar, cache);
				
				temp = Math.max(Math.max(hold1, hold2), hold3);
				// System.out.println("cache["+i+"][" + turn_val + "]: " + cache[i][turn_val] + "   turn: M");
			} else {
			
				hold1 = dp(i+1, score, Turn.MYTURN, ar, cache);
				hold2 = dp(i+2, score, Turn.MYTURN, ar, cache);
				hold3 = dp(i+3, score, Turn.MYTURN, ar, cache);
				
				temp = Math.min(Math.min(hold1, hold2), hold3);
				// System.out.println("cache["+i+"][" + turn_val + "]: " + cache[i][turn_val] + "   turn: H");
			}
	//	}
		
		// return cache[i];
		if (t == Turn.MYTURN)
			cache[i][turn_val] = Math.max(cache[i][turn_val], temp);
		else if (cache[i][turn_val] != -1)
			cache[i][turn_val] = Math.min(cache[i][turn_val], temp);
		else 
			cache[i][turn_val] = Math.min(Long.MAX_VALUE, temp);
		
		return cache[i][turn_val];
		
	}
}

enum Turn { MYTURN, HISTURN; }
