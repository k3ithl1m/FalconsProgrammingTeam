import java.util.*;

public class MandragoraForest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			
			int N = sc.nextInt();
			int[] ar = new int[N];
			
			for (int j = 0; j < ar.length; j++) {
				ar[j] = sc.nextInt();
			}
			
			Arrays.sort(ar);
			
			int s = ar.length;
			long m = 0;
			long previous = 0;
			long p = 0;
			
			while(s > 0) {
				
				m = m + ar[s - 1];
				
				p = s * m;
				s--;
				
				if (p >= previous) {
					previous = p;
				} else { 
					
					break;
				}
				
				
			}
			
			System.out.println(previous);
		}
		
		sc.close();
		
	}
	
}
