package leetcodeanswer;

import java.util.Arrays;

public class _151��ת�ַ���ĵ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a good   example";
		Solution151 sl = new Solution151();
		System.out.println(sl.reverseWords(s));

	}

}



class Solution151 {
	public String reverseWords(String s) {

		String[] str = s.trim().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i].equals("")) {
				continue;
			} else {
				if (i == 0) {
					sb.append(str[i]);
				} else {
					sb.append(str[i] + " ");
				}

			}

		}
		System.out.println(sb.toString());

		return new String(sb);
	}
}

//String���ַ���������StringBuilder��append���Ĳ�𼫴�String������ʱ��
//class Solution151 {
//public String reverseWords(String s) {
//
//	String[] str = s.trim().split(" ");
//	String ans = "";
//	System.out.println(Arrays.deepToString(str));
//	for (int i = str.length - 1; i >= 0; i--) {
//		if (!str[i].equals("")) {
//			if(i==0) {
//				ans=ans+str[i];
//			}else {
//				ans=ans+str[i]+"+";
//			}
//		}
//
//	}
//
//	return ans;
//}
//}