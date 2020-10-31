package leetcodeanswer;

public class _29Á½ÊýÏà³ý {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution29 sl = new Solution29();
		int ans = sl.divide(-123231, 1);
		System.out.println(ans);

	}

}

class Solution29 {
	public int divide(int dividend, int divisor) {
		boolean sign = (dividend > 0) ^ (divisor > 0);
		int ans = 0;
		dividend = -Math.abs(dividend);
		divisor = -Math.abs(divisor);
		while (dividend <= divisor) {
			int temp = divisor;
			int count = -1;
			while (dividend <= (temp << 1)) {
				if (temp <= (Integer.MIN_VALUE >> 1))
					break;
				temp = temp << 1;
				count = count << 1;
			}
			ans += count;
			dividend -= temp;

		}
		if (!sign) {
			if (ans <= Integer.MIN_VALUE)
				return Integer.MAX_VALUE;
			ans = -ans;
		}

		return ans;

	}
}