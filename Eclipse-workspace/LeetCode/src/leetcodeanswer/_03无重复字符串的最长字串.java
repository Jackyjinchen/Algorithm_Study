package leetcodeanswer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _03无重复字符串的最长字串 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "pwwkew";
		Solution03 solution = new Solution03();
		System.out.println(solution.lengthOfLongestSubstring(str));
	}

}

/**
 * 改进滑动窗，采用HashMap存储节点位置，这样右滑动时候可以直接将i赋值到给定的重复出现节点，加速移动
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
				//注意此处i-j无重复，为了移动到i=temp+1
				//需要删除从i当前位置到temp的所有存在的HashMap
				//再将指针移动到temp+1位置
				for (int k = i; k < temp + 1; k++) {
					map.remove(s.charAt(k));
				}
				i = temp + 1;
			}
		}
		return len;
	}
}

////滑动窗解决问题i左指针，j右指针，在此区域查找是否有相同字符串
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
//			// 左闭右开，所以这里j需要越界一个点
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