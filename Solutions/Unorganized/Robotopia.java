import java.util.*;

public class Robotopia {

	public static int n1 = 0, n2 = 0, nt = 0;
	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int z = 0; z < n; z++) {
			
			int l1 = sc.nextInt(), a1 = sc.nextInt(), l2 = sc.nextInt(),
					a2 = sc.nextInt(), lt = sc.nextInt(), at = sc.nextInt();
			
			n1 = l1 + a1;
			n2 = l2 + a2;
			nt = lt + at;
			
			int nm[] = new int[2];
			int i = 0, j = 0;
			nm[0] = i; nm[1] = j;
			
			
			while (true) {
				
				if (((nm[0] * n1) + (nm[1] * n2) == nt)) {
					count++;
					nm[0] = i; nm[1] = j;
				} else {
					
					
					
				}
				
			}
			
		}
	}
	
}
