package KMP;


public class KMPAlgorith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		
		int[] next = kmpNext(str2);
		
		System.out.println(kmpSearch(str1, str2, next));

	}

	// KMP搜索算法
	/**
	 * 
	 * @param str1 原字符串
	 * @param str2 匹配字符串
	 * @param next 部分匹配表，子串对应的部分匹配表
	 * @return 如果-1没有匹配到。否则返回匹配位置下标
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		// 遍历str1
		for (int i = 0, j = 0; i < str1.length(); i++) {
			//需要考虑不同的情况str1.charAt(i)!=str2.charAt(j)
			while (j>0&&str1.charAt(i)!=str2.charAt(j)) {
				j=next[j-1];
			}
			
			if(str1.charAt(i)==str2.charAt(j)) {
				j++;
			}
			if(j==str2.length()) {
				return i-j+1;
			}
			
		}
		return -1;

	}

	// 获取到一个字符串（部分匹配值）
	public static int[] kmpNext(String dest) {
		int[] Next = new int[dest.length()];
		Next[0] = 0;

		for (int i = 1, j = 0; i < dest.length(); i++) {
			// 当dest.charAt(i) != dest.charAt(j),需要从Next[j-1]获取新的j
			// 直到发现dest.charAt(i) =!= dest.charAt(j)退出
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = Next[j - 1];
			}
			// 满足i和j的字符串相等，匹配值+1
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			Next[i] = j;
		}

		return Next;
	}

}
