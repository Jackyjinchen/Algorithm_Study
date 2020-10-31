package leetcodeanswer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class _01两数之和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 2, 7, 11, 15 };
		int target = 26;

		Solution01 solution01 = new Solution01();
		int[] answer=solution01.twoSum(nums, target);
		System.out.println(Arrays.toString(answer));

	}

}


//暴力搜索
//class Solution01 {
//	public int[] twoSum(int[] nums, int target) {
//		//注意j的范围，题目要求不能重复
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i+1; j < nums.length; j++) {
//				if(nums[i]+nums[j]==target) {
//					return new int[] {i,j};
//				}
//			}
//		}
//
//		return null;
//
//	}
//}


//哈希表方式
class Solution01 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> data = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			data.put(nums[i], i);
		}
		
		int temp=0;
		for (int i = 0; i < nums.length; i++) {
			temp=target-nums[i];
			if(data.containsKey(temp)&&data.get(temp)!=i) {
				return new int[] {i,data.get(temp)};
			}
		}
		return null;
	}
}


