package leetcodeanswer;

public class _28×Ö·û´®Æ¥Åä {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "hello";
		String needle = "ll";

		Solution28 solution = new Solution28();
		System.out.println(solution.strStr(haystack, needle));

	}

}

class Solution28 {
	public int strStr(String haystack, String needle) {
		
		int i=0,j=0;
		while (i<haystack.length()&&j<needle.length()) {
			if(haystack.charAt(i)==needle.charAt(j)) {
				i++;
				j++;
			}else {
				i=i-j+1;
				j=0;
			}
		}
		if(j==needle.length()) {
			return i-j;
		}
		
		return -1;	
			
	}
}



//class Solution {
//	public int strStr(String haystack, String needle) {
//		if (needle.isEmpty()) {
//			return 0;
//		} else if (haystack.length() < needle.length()) {
//			return -1;
//		}
//		int  j = 0;
//		for (int i = 0; i < haystack.length(); i++) {
//			while (haystack.charAt(i+j)==needle.charAt(j)) {
//				j++;
//				if(j==needle.length()){
//					return i;
//				}
//				if(haystack.length()<=(i+j)) {
//					return -1;
//				}
//			}
//			j=0;
//		}
//		return -1;
//	}
//}