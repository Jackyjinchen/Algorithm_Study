package leetcodeanswer;

public class _50Pow幂函数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 34.00515;
		int n = -3;
		Solution50 sl = new Solution50();
		System.out.println(sl.myPow(x, n));

	}

}



//通过二分计算可实现log次计算幂指数
class Solution50 {
	public double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		return fastPow(x, N);

	}
	public double fastPow(double x, long n) {
		if (n == 0) {
			return 1.0;
		}
		double half = fastPow(x, n / 2);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}

	}
}