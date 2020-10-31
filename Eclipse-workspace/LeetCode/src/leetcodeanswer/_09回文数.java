package leetcodeanswer;

public class _09回文数 {
	public static void main(String[] args) {

		int x = 121;
		Solution09 solution09 = new Solution09();
		if (solution09.isPalindrome(x)) {
			System.out.println("Num is RevertedNum");
		}

	}
}

class Solution09 {
	public boolean isPalindrome(int x) {

		String str = x + "";
		int left = 0;
		int right = str.length()-1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;

	}
}

//class Solution09 {
//	public boolean isPalindrome(int x) {
//
//		// 这里注意判断条件,对于尾数为0的数字，只有首位数字也为零才可以
//		// 故只有0满足，需要将其他数据排除。
//		if (x < 0 || x % 10 == 0 && x != 0) {
//			return false;
//		}
//		int reverted = 0;
//
//		while (x > reverted) {
//			reverted = reverted * 10 + x % 10;
//			x /= 10;
//		}
//
//		return x == reverted || x == reverted / 10;
//	}
//}