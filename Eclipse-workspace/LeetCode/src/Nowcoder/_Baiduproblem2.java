package Nowcoder;

import java.util.Scanner;

public class _Baiduproblem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		while (sc.hasNextInt()) {
		int n = sc.nextInt();

		long a[] = new long[n+5];
		long count[] = new long[n+5];
		long sum = 0, ans = 0;
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		while (flag) {
			flag = false;
			sum = 0;
			for (int i = 0; i <= n; i++) {
				count[i] = a[i] / n;
				a[i] = a[i] % n;
				sum = sum + count[i];
			}
			ans += sum;
			for (int i = 0; i <= n; i++) {
				a[i] += sum - count[i];
				if (a[i] >= n)
					flag = true;
			}

		}
		System.out.println(ans);
//		}
	}
}