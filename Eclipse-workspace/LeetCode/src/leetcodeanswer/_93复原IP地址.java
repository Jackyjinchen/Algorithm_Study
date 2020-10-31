package leetcodeanswer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _93复原IP地址 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "010010";
		Solution93 sl = new Solution93();

//		 ArrayList<String> arrayList = new ArrayList<String>() ;
		 System.out.println(sl.restoreIpAddresses(s));

	}
}

class Solution93 {

	String s;
	int lens;
	LinkedList<String> segments = new LinkedList<String>();
	List<String> ans = new ArrayList<String>();

	public List<String> restoreIpAddresses(String s) {
		this.s = s;
		lens = s.length();
		//字符串长度小于4或者大于12说明已经无法构成IP值，直接跳过
		if(s.length() > 3 && s.length() < 13){
		backtrack(0, 3);
		}
		return ans;
	}

	public void backtrack(int index, int point) {
		if (point < 0) {
			if (index == lens)
				ans.add(String.join(".", segments));
			return;
		}

		for (int i = 1; i < 4; i++) {
			if ((index + i) > lens)
				break;
			String segment = s.substring(index, index + i);
			// 对于子串判断是不是有效
			if ((!segment.startsWith("0")) ? (Integer.valueOf(segment) <= 255) : (segment.length() == 1)) {
				segments.add(segment);
				backtrack(index + i, point - 1);
				segments.remove(segments.size() - 1);
			}

		}
	}

}
