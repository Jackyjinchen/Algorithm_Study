package KMP;


public class KMPAlgorith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		
		int[] next = kmpNext(str2);
		
		System.out.println(kmpSearch(str1, str2, next));

	}

	// KMP�����㷨
	/**
	 * 
	 * @param str1 ԭ�ַ���
	 * @param str2 ƥ���ַ���
	 * @param next ����ƥ����Ӵ���Ӧ�Ĳ���ƥ���
	 * @return ���-1û��ƥ�䵽�����򷵻�ƥ��λ���±�
	 */
	public static int kmpSearch(String str1, String str2, int[] next) {
		// ����str1
		for (int i = 0, j = 0; i < str1.length(); i++) {
			//��Ҫ���ǲ�ͬ�����str1.charAt(i)!=str2.charAt(j)
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

	// ��ȡ��һ���ַ���������ƥ��ֵ��
	public static int[] kmpNext(String dest) {
		int[] Next = new int[dest.length()];
		Next[0] = 0;

		for (int i = 1, j = 0; i < dest.length(); i++) {
			// ��dest.charAt(i) != dest.charAt(j),��Ҫ��Next[j-1]��ȡ�µ�j
			// ֱ������dest.charAt(i) =!= dest.charAt(j)�˳�
			while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
				j = Next[j - 1];
			}
			// ����i��j���ַ�����ȣ�ƥ��ֵ+1
			if (dest.charAt(i) == dest.charAt(j)) {
				j++;
			}
			Next[i] = j;
		}

		return Next;
	}

}
