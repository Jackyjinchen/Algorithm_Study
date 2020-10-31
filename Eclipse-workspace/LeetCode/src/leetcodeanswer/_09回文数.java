package leetcodeanswer;

public class _09������ {
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
//		// ����ע���ж�����,����β��Ϊ0�����֣�ֻ����λ����ҲΪ��ſ���
//		// ��ֻ��0���㣬��Ҫ�����������ų���
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