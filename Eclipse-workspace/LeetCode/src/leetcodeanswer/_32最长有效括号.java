package leetcodeanswer;

public class _32���Ч���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ")()())";
		Solution32 sl = new Solution32();
		System.out.println(sl.longestValidParentheses(s));

	}

}

//��̬�滮˼��
//��Ϊ������ֻ��(��)�����ַ����ж��ַ�����һλ
//��Ч�����ִ���Ҫ�ҵ�)����

class Solution32 {
	public int longestValidParentheses(String s) {
		int maxlen = 0;
		int[] dp = new int[s.length()];

		for (int i = 1; i < dp.length; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;// �жϴ�()֮ǰ�Ƿ���������Ч���Ŵ�
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;

				}
			}
			maxlen = Math.max(maxlen, dp[i]);
		}

		return maxlen;

	}
}