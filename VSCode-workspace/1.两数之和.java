/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
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

