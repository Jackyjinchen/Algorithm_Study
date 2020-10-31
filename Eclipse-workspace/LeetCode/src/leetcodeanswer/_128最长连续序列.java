package leetcodeanswer;

import java.util.HashSet;

public class _128最长连续序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		Solution128 sl = new Solution128();
		System.out.println(sl.longestConsecutive(nums));

	}

}

class Solution128 {
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}
		int ans = 0;
		int currlens = 0;
		int currnum = 0;

		for (int num : nums) {

			if (!set.contains(num - 1)) {
				currnum = num;
				currlens = 1;

				while (set.contains(currnum + 1)) {
					currnum++;
					currlens++;
				}
				ans = Math.max(ans, currlens);
			}
		}
		return ans;

	}
}