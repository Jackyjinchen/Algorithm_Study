package leetcodeanswer;

public class _300最长上升子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		Solution300 sl = new Solution300();
		System.out.println(sl.lengthOfLIS(nums));

	}

}

class Solution300 {
	public int lengthOfLIS(int[] nums) {

		if(nums.length<2) return nums.length;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int ans=1;
		for (int i = 0; i < nums.length; i++) {
			int maxlencurr = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					maxlencurr = Math.max(maxlencurr, dp[j] + 1);
				}
			}
			dp[i]=maxlencurr;
			ans=Math.max(dp[i], ans);
		}
		return ans;
	}
}



//class Solution300 {
//	public int lengthOfLIS(int[] nums) {
//		if(nums.length<2) return nums.length;
//		int[] dp = new int[nums.length];
//		dp[0] = 1;
//		int ans=1;
//		for (int i = 0; i < nums.length; i++) {
//			int maxlencurr = 1;
//			for (int j = 0; j < i; j++) {
//				if (nums[j] < nums[i]) {
//					maxlencurr = Math.max(maxlencurr, dp[j] + 1);
//				}
//			}
//			dp[i]=maxlencurr;
//			ans=Math.max(dp[i], ans);
//		}
//		return ans;
//	}
//}