package leetcodeanswer;

public class _152乘积最大子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -2,0,-1};
		Solution152 sl = new Solution152();
		System.out.println(sl.maxProduct(nums));

	}

}


//暴力求解所有数字序列的乘积值
class Solution152 {
	public int maxProduct(int[] nums) {

		int left = 1;
		int max = nums[0];
		for (int j = 0; j < nums.length; j++) {
			for (int i = j; i < nums.length; i++) {
				max = Math.max(left *= nums[i], max);
			}
			left=1;
		}
		return max;
		
	}
}