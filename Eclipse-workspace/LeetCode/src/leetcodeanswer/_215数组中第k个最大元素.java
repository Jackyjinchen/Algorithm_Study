package leetcodeanswer;

import java.util.Arrays;

public class _215数组中第k个最大元素 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution215 sl = new Solution215();
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(sl.findKthLargest(nums, k));

	}

}

//快速排序。
class Solution215 {
	public int findKthLargest(int[] nums, int k) {
		int ans = 0;
		quickSort(nums, 0, nums.length-1);

		return nums[nums.length-k];
	}
	
	public void quickSort(int[] nums, int start, int end) {

		int l = start ;
		int r = end;
		int pivot = nums[(l + r) / 2];
		int temp = 0;

		while (l < r) {
			while (nums[l] < pivot) {
				l++;
			}
			while (nums[r] > pivot) {
				r--;
			}
			if (l >= r)
				break;			
			temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;			
			if (nums[l] == pivot)
				r--;
			if (nums[r] == pivot)
				l++;
		}
		if (l==r) {
			l++;
			r--;
		}		
		if (start<r) {
			quickSort(nums, start,r );
		}
		if (l<end) {
			quickSort(nums, l,end );
		}
	}
	
}



////最好采用排序算法来做。
//class Solution215 {
//	public int findKthLargest(int[] nums, int k) {
//		int ans = 0;
//		Arrays.sort(nums);
//
//		return nums[nums.length-k];
//	}
//}