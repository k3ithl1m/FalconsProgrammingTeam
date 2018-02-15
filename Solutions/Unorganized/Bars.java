import java.util.*;

public class Bars {

	public static int next = 0;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {

			int n = sc.nextInt();
			int p = sc.nextInt();

			if (n <= 0) {
				System.out.println("YES");
			} else {

				int[] ar = new int[p];
				int[] cache = new int[2 ^ p];
				Arrays.fill(cache, -1);

				for (int j = 0; j < p; j++) {
					ar[j] = sc.nextInt();
				}

				if (func(ar, n, 0, cache, p) == true) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}

				Arrays.fill(cache, -1);
				next = 0;

			}

		}

		sc.close();

	}

	public static boolean func(int[] ar, int n, int start, int[] cache, int p) {

		int N = 0;

		if (ar[start] == n) {

			return true;

		} else {

			if (cache[0] != -1) {

				int loop = next;
				for (int i = 0; i < loop; i++) {

					if (cache[i] != -1) {

						N = cache[i] + ar[start];

						if (N == n) {
							return true;
						} else {
							next++;
							cache[next] = N;

						}

					}

				}

				if (start + 1 < p)
					func(ar, n, start + 1, cache, p);

			} else {
				cache[0] = ar[start];
				next++;
				func(ar, n, start + 1, cache, p);
			}
			return false;
		}

	}


}
//
//1
//25
//4
//10 12 5 15
//925
//10
//45 15 120 500 235 58 6 12 175 70
//120
//5
//25 25 25 25 25
//0
//2
//13 567
