package leetcodeanswer;

public class _05最长回文子串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "babad";
		Solution05 solution = new Solution05();
		System.out.println(solution.longestPalindrome(str));

	}

}

class Solution05 {
	public String longestPalindrome(String s) {
		//注意要加一句如果为空String需要返回""
		if(s==null||s.length()<1)return "";
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int len1 = Expend(s, i, i);
			int len2 = Expend(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start=i-(len-1)/2;
				end=i+len/2;
			}

		}
		//注意返回值，左闭右开，end需要+1
		return s.substring(start, end+1);

	}

	public int Expend(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		// 返回的是回文的长度
		return right - left - 1;
	}

}