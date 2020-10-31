package leetcodeanswer;

public class _04寻找两个有序数组的中位数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 2 };
		int[] nums2 = { 3, 4 };
		Solution04 sl = new Solution04();
		double ans = sl.findMedianSortedArrays(nums1, nums2);
		System.out.println(ans);

	}

}

class Solution04 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int left = -1, right = -1;
		int num1index = 0, num2index = 0;
		for (int i = 0; i <= (m + n) / 2; i++) {
			left=right;
			if (num1index < m && (num2index >= n || nums1[num1index] < nums2[num2index])) {
				right = nums1[num1index++];
			} else {
				right = nums2[num2index++];
			}
		}
		if (((m + n) & 1) == 0)
			return (left + right) / 2.0;
		else
			return right;

	}
}