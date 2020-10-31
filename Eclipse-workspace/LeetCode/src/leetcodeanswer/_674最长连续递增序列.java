package leetcodeanswer;

public class _674最长连续递增序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2,2,2,2,1,2,3};
		Solution647 sl = new Solution647();
		System.out.println(sl.findLengthOfLCIS(nums));

	}

}

class Solution647 {
	public int findLengthOfLCIS(int[] nums) {
		int ans = 0;
		int begin = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				ans = Math.max(ans, i - begin + 1);
			}else {
				while(i < nums.length&&nums[i+1] == nums[i]) i++;
				begin = i;
			}
			
		}
		return ans;
	}
}