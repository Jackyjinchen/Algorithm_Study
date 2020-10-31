package leetcodeanswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15三数之和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums = { -4,-4,-4,-4,-4,-4,    0,4,4,4,4,4 };

		Solution15 sl = new Solution15();
		System.out.println(sl.threeSum(nums));

	}

}

class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
		if (nums[0]>0||nums[nums.length-1]<0) {
			return list;
		}
		for (int left = 0; left < nums.length-2; left++) {
			if (nums[left]>0) break;
			if (left>0&&nums[left]==nums[left-1]) continue;
			int mid=left+1;
			int right=nums.length-1;
			while (mid<right) {
				//这里当我已经找到一个0 如-4 -2 6，有可能移位后还是-4 -2(mid++) 5 此时就需要跳过mid的重复值
				if (nums[left]+nums[mid]+nums[right]<0||(mid>left+1&&nums[mid]==nums[mid-1])) {
					mid++;
				}else {
					//这里当我已经找到一个0 如-4 -2 6，有可能移位后还是-4 -1 5(right++)此时就需要跳过right的重复值
					if (nums[left]+nums[mid]+nums[right]>0||(right<nums.length-1&&nums[right]==nums[right+1])) {
						right--;
					}else {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[left]);
						temp.add(nums[mid++]);
						temp.add(nums[right--]);
						list.add(temp);
					}
					
				}
			
			}
	
		}
		
		
		
		
		return list;

	}
}