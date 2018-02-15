import java.util.*;
public class KnapSack {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int l = 0; l < T; l++) {

			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] A = new int[n];

			for (int i = 0; i < n; i++) {
				A[i] = sc.nextInt();

			}

			Arrays.sort(A);
			int[] ar = new int[k + 1];
			Arrays.fill(ar, 0);
			
			System.out.println(dp(ar, k, A));




		}


		sc.close();

	}



	public static int dp(int[] ar, int k, int[] A) {

		int maxVal = 0;
		if (A[0] == 1) {
			return k;
		} else {

			for (int i = 0; i < A.length; i++) { // keeps track of A[i]
				for (int j = 0; j < k + 1; j++) { // keeps track of ar[j]

					if (A[i] <= j) {
						if ( (j % A[i]) == 0) {
							ar[j] = Math.max(A[i] * (j/A[i]), ar[j]); //Compare previous value with new value if multiple
						} else {
							ar[j] = Math.max((A[i] + ar[j - A[i] ]), ar[j]);
							
						}
					}
					
					if (ar[j] > maxVal) {
						maxVal = ar[j];
					}

				}
			}
			
			return maxVal;
		}

		

	}
}
