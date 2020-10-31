package leetcodeanswer;

public class _32最长有效括号 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ")()())";
		Solution32 sl = new Solution32();
		System.out.println(sl.longestValidParentheses(s));

	}

}

//动态规划思想
//因为数组中只有(和)两种字符，判断字符的上一位
//有效括号字串需要找到)才行

class Solution32 {
	public int longestValidParentheses(String s) {
		int maxlen = 0;
		int[] dp = new int[s.length()];

		for (int i = 1; i < dp.length; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;// 判断此()之前是否是完整有效括号串
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;

				}
			}
			maxlen = Math.max(maxlen, dp[i]);
		}

		return maxlen;

	}
}