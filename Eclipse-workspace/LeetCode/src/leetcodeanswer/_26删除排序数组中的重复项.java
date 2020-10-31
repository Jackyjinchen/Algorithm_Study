package leetcodeanswer;

public class _26删除排序数组中的重复项 {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		Solution26 sl = new Solution26();
		int k = sl.removeDuplicates(nums);
		for (int i = 0; i < k; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}

class Solution26 {

	public int removeDuplicates(int[] nums) {
		if (nums.length < 2)
			return nums.length;

		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}

		return i + 1;
	}

//	public int removeDuplicates(int[] nums) {
//		if (nums.length < 2)
//			return nums.length;
//
//		int now = 1;
//		int point = 1;
//		while (point < nums.length) {
//
//			while (point < nums.length&&nums[point] == nums[point - 1]) {
//				point++;
//			}
//			if(point>=nums.length)break;
//
//			nums[now] = nums[point];
//			now++;
//			point++;
//
//		}
//
//		return now;
//	}
}