package KMP;

public class violenceMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1="¹è¹è¹ÈÉĞ¹è¹ÈÄãÉĞ¹èÉĞ¹è¹ÈÄãÉĞ¹è¹ÈÄãÉĞ¹èÄãºÃ";
		String str2="ÉĞ¹è¹ÈÄãÉĞ ¹èÄã";
		System.out.println(violencematch(str1, str2));
		
		
	}

	public static int violencematch(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();

		int s1Len = s1.length;
		int s2Len = s2.length;

		int i = 0;
		int j = 0;

		while (i < s1Len && j < s2Len) {
			if (s1[i] == s2[j]) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}

		}
		if (j==s2Len) {
			return i-j;
		}else {
			return -1;
		}
	}

}
