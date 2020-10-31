package leetcodeanswer;


public class _43字符串相乘 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "9133", num2 = "50";
		Solution43 sl = new Solution43();
//		sl.multiply(num1, num2);
		System.out.println(sl.multiply(num1, num2));
//		System.out.println(num1.toCharArray()[1]);

	}

}

//尝试改进 不需要逆序，剩下了大量StringBuilder浪费的空间
class Solution43 {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
            return "0";

		int n1len = num1.length();
		int n2len = num2.length();
		int carry = 0, temp = 0;
		String ans = "";

		for (int i = 0; i < n1len + n2len - 1; i++) {
			temp = carry;
			for (int j = Math.min(n2len - 1, i), k = i - j; j >= 0 && k < n1len; j--, k++) {
				temp += ((num1.charAt(n1len-1-k) - '0') * (num2.charAt(n2len-1-j) - '0'));
			}
			ans = (temp % 10) + "" + ans;
			carry = temp / 10;
		}
		if (carry != 0)
			ans = carry + "" + ans;
		return ans;
	}
}




////需要把字符串逆序，可以改进不逆序直接操作
//class Solution43 {
//	public String multiply(String num1, String num2) {
//		if (num1 == "0" || num2 == "0")
//			return "0";
//		StringBuilder str1 = new StringBuilder(num1);
//		StringBuilder str2 = new StringBuilder(num2);
//		str1 = str1.reverse();
//		str2 = str2.reverse();
//		int n1len = num1.length();
//		int n2len = num2.length();
//		int carry = 0, temp = 0;
//		String ans = "";
//
//		for (int i = 0; i < n1len + n2len - 1; i++) {
//			temp = carry;
//			for (int j = Math.min(n2len - 1, i), k = i - j; j >= 0 && k < n1len; j--, k++) {
//				temp += ((str1.charAt(k) - '0') * (str2.charAt(j) - '0'));
//			}
//			ans = (temp % 10) + "" + ans;
//			carry = temp / 10;
//		}
//		if (carry != 0)
//			ans = carry + "" + ans;
//		return ans;
//	}
//}

