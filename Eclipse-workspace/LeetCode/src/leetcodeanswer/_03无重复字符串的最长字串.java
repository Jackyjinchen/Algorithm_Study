package leetcodeanswer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _03���ظ��ַ�������ִ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "pwwkew";
		Solution03 solution = new Solution03();
		System.out.println(solution.lengthOfLongestSubstring(str));
	}

}

/**
 * �Ľ�������������HashMap�洢�ڵ�λ�ã������һ���ʱ�����ֱ�ӽ�i��ֵ���������ظ����ֽڵ㣬�����ƶ�
 */
class Solution03 {
	public int lengthOfLongestSubstring(String s) {
		int len = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int j = 0;
		while (i < s.length() && j < s.length()) {
			Character ch = s.charAt(j);
			if (!map.containsKey(ch)) {
				map.put(ch, j);
				j++;
				len = Math.max(len, j - i);
			} else {
				int temp = map.get(ch);
				//ע��˴�i-j���ظ���Ϊ���ƶ���i=temp+1
				//��Ҫɾ����i��ǰλ�õ�temp�����д��ڵ�HashMap
				//�ٽ�ָ���ƶ���temp+1λ��
				for (int k = i; k < temp + 1; k++) {
					map.remove(s.charAt(k));
				}
				i = temp + 1;
			}
		}
		return len;
	}
}

////�������������i��ָ�룬j��ָ�룬�ڴ���������Ƿ�����ͬ�ַ���
//class Solution03 {
//	public int lengthOfLongestSubstring(String s) {
//		int len = 0;
//		HashSet<Character> set = new HashSet<Character>();
//		int i = 0;
//		int j = 0;
//		while (i < s.length() && j < s.length()) {
//			if (!set.contains(s.charAt(j))) {
//				set.add(s.charAt(j++));
//				len = Math.max(len, j - i);
//			} else {
//				set.remove(s.charAt(i++));
//			}
//		}
//
//		return len;
//	}
//}

//class Solution03 {
//	public int lengthOfLongestSubstring(String s) {
//		int len = 0;
//		for (int i = 0; i < s.length(); i++) {
//			// ����ҿ�����������j��ҪԽ��һ����
//			for (int j = 0; j <= s.length(); j++) {
//				if (allUnique(s, i, j))
//					len = Math.max(len, j - i);
//			}
//		}
//		return len;
//	}
//
//	public boolean allUnique(String str, int begin, int end) {
//		Set<Character> set = new HashSet<Character>();
//		for (int i = begin; i < end; i++) {
//			Character ch = str.charAt(i);
//			if (set.contains(ch))
//				return false;
//			set.add(ch);
//		}
//		return true;
//	}
//}