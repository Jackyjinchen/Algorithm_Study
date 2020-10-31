package leetcodeanswer;

import java.util.Arrays;

public class _快速排序基础程序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[30];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
		Solutionquicksort sl = new Solutionquicksort();
		sl.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

}

//最好采用排序算法来做。
class Solutionquicksort {
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