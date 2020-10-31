package leetcodeanswer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _18四数之和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution18 sl = new Solution18();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		List<List<Integer>> res = sl.fourSum(nums, 15);
		System.out.println(res.toString());

	}

}

class Solution18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new LinkedList<>();
		Arrays.sort(nums);
		int lens = nums.length;
		for (int i = 0; i < lens - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
			if (nums[i] + nums[lens - 1] + nums[lens - 2] + nums[lens - 3] < target) continue;

			for (int j = i + 1; j < lens - 2; j++) {
				if (j - i > 1 && nums[j] == nums[j - 1]) continue;

				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
				if (nums[i] + nums[j] + nums[lens - 1] + nums[lens - 2] < target) continue;

				int left = j + 1;
				int right = lens - 1;
				while (left < right) {
					int temp = nums[i] + nums[j] + nums[left] + nums[right];
					if (temp > target)
						right--;
					else if (temp < target)
						left++;
					else {
						List<Integer> temList = new LinkedList<Integer>(
								Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						res.add(temList);
						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						left++;
						right--;

					}

				}

			}
		}

		return res;

	}
}