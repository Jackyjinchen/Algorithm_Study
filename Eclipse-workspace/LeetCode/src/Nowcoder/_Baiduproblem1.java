package Nowcoder;

import java.util.Scanner;

public class _Baiduproblem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 sl = new Solution1();
		Scanner in = new Scanner(System.in);
		int b = in.nextInt();
		int ans = sl.lcm(b, b - 1);
		for (int i = b; i >= 1; i--) {
			for (int j = b - 1; j >= 1; j--) {
				ans = Math.max(sl.lcm(i, j), ans);
			}
		}
		System.out.println(ans);
	}

}

class Solution1 {

	public int gcd(int a, int b) {
		int ans = 0;
		ans = (b == 0 ? a : gcd(b, a % b));

		return ans;
	}

	public int lcm(int a, int b) {
		int gcd = gcd(a, b);
		int ans = (a / gcd * b) - gcd;
		return ans;
	}

}
