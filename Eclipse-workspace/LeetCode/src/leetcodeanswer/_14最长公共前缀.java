package leetcodeanswer;

public class _14�����ǰ׺ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = { "apple", "apply", "app" };
		Solution14 sl = new Solution14();
		System.out.println(sl.longestCommonPrefix(str));

	}

}

//���ֲ���
class Solution14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		int minLen = Integer.MAX_VALUE;
		for (String str : strs)
			minLen = Math.min(minLen, str.length());
		int low = 1;
		int high = minLen;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (isCommonPrefix(strs, middle))
				low = middle + 1;
			else
				high = middle - 1;
		}
		return strs[0].substring(0, (low + high) / 2);
	}

	private boolean isCommonPrefix(String[] strs, int len) {
		String str1 = strs[0].substring(0, len);
		for (int i = 1; i < strs.length; i++)
			if (!strs[i].startsWith(str1))
				return false;
		return true;
	}

}

////��λɨ��
//class Solution14 {
//	public String longestCommonPrefix(String[] strs) {
//		if (strs.length == 0)
//			return "";
//		for (int i = 0; i < strs[0].length(); i++) {
//			char ch = strs[0].charAt(i);
//			for (int j = 0; j < strs.length; j++) {
//				if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
//					return strs[0].substring(0, i);
//				}
//			}
//		}
//		return strs[0];
//	}
//}

//ˮƽɨ��
//class Solution14 {
//	public String longestCommonPrefix(String[] strs) {
//
//		if (strs.length == 0)
//			return "";
//
//		String prefix = strs[0];
//
//		for (int i = 1; i < strs.length; i++) {
//			while (strs[i].indexOf(prefix) != 0) {
//				// indexOf�ҵ����ַ���ֵ���ַ������״γ��ֵ�λ��
//				// ����0˵���ҵ���ǰ׺�ҵ��������ͬ���ַ���
//				// ���û�ҵ��Ͱ�prefix�е��ַ������һλɾ��
//				prefix = prefix.substring(0, prefix.length() - 1);
//				// substring���԰��ַ������ض�λ�õ��Ӵ���ֳ���
//				if (prefix.isEmpty())
//					return "";
//			}
//		}
//
//		return prefix;
//	}
//}