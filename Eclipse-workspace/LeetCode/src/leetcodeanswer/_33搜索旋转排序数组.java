package leetcodeanswer;

public class _33ËÑË÷Ğı×ªÅÅĞòÊı×é {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		int target = 5;
		Solution33 sl = new Solution33();
		System.out.println(sl.search(nums, target));

	}

}

class Solution33 {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target <= nums[right] && target > nums[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}