package com.Jacky.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Sort_method {

	public static void main(String[] args) {

//		 初始化数组
//		int[] arr = new int[80000];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 800000);
//		}
		
		int[] arr= {1,1,1,5,1,1,1};

		// 开始时间
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(date1);
		System.out.println("排序前时间=" + date1Str);

		//冒泡排序
//		bubbleSort(arr);
//		选择排序
//		selectSort(arr);
		//插入排序
//		insertSort(arr);
		//希尔排序
//		shellSort(arr);
//		shellSort2(arr);
		//快速排序
		quickSort1(arr, 0, arr.length - 1);

		//归并排序
//		int temp[] =new int[arr.length];
//		mergeSort(arr, 0, arr.length-1, temp);
		
		//基数排序
//		radixSort(arr);
//		System.out.println("排序好了");
//		System.out.println(Arrays.toString(arr));

		// 结束时间
		Date date2 = new Date();
		String date2Str = simpleDateFormat.format(date2);
		System.out.println("排序后时间=" + date2Str);
	}

	public static void bubbleSort(int[] arr) {
		// 选择排序时间复杂度O(n^2)
		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (flag == false) {
				break;
			}
			flag = false;
		}
	}

	public static void selectSort(int[] arr) {
		// 冒泡排序时间复杂度O(n^2)
		int minIndex = 0;
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	public static void insertSort(int[] arr) {
		// 插入排序时间复杂度O(n^2)
		int insertVal = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i - 1;
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			if (insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertVal;
			}
		}
	}

	// 交换希尔排序
	public static void shellSort1(int[] arr) {
		// 希尔排序时间复杂度
		int temp = 0;
		// 根据前面的逐步分析，使用循环处理
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
		}
	}

	// 插入希尔排序
	public static void shellSort(int[] arr) {
		// 希尔排序时间复杂度
		int j = 0;
		int temp = 0;
		// 根据前面的逐步分析，使用循环处理
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				j = i;
				temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = temp;
				}
			}
		}
	}

	public static void quickSort1(int[] arr, int left, int right) {
		// 排序时间复杂度
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		// 比pivot小的放到左边，大的放在右边
		while (l < r) {
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				r--;
			}
			// 实现了 左边小， 右边大
			if (l >= r) {
				break;
			}
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			if (arr[l] == pivot) {
				r--;
			}
			if (arr[r] == pivot) {
				l++;
			}

		}
		if (l == r) {
			l++;
			r--;
		}

		if (left < r) {
			quickSort(arr, left, r);
		}
		if (right > l) {
			quickSort(arr, l, right);
		}

	}

	public static void quickSort(int[] arr, int low, int high) {
		// 排序时间复杂度

		int tmp = arr[low];
		int i = low;
		int j = high;

		while (i < j) {
			// 先看右边，依次往左递减，直到找到小于基准数的数字
			while (arr[j] >= tmp && i < j) {
				j--;
			}
			// 比基准小的记录移到低端
			arr[i] = arr[j];

			// 后看左边，依次往右递增，直到找到大于基准数的数字
			while (arr[i] <= tmp && i < j) {
				i++;
			}
			// 比基准大的记录移到高端
			arr[j] = arr[i];
		}

		// 记录基准
		arr[i] = tmp;

		// 递归调用左半数组
		if (low < j - 1) {
			quickSort(arr, low, j - 1);
		}

		// 递归调用右半数组
		if (j + 1 < high) {
			quickSort(arr, j + 1, high);
		}

	}

	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			// 合并
			merge(arr, left, mid, right, temp);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		// 归并排序时间复杂度
		int i = left;
		int j = mid + 1;
		int t = 0;

		// 顺序填充temp
		while (i <= mid && j <= mid) {
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t++;
				i++;
			} else {
				temp[t] = arr[j];
				t++;
				j++;
			}

		}
		// 剩余一边数据全部放入temp
		while (i <= mid) {
			temp[t] = arr[i];
			t++;
			i++;
		}
		while (j <= mid) {
			temp[t] = arr[j];
			t++;
			j++;
		}
		// temp重新拷贝arr中
		for (int k = 0; k < t; k++) {
			arr[left + k] = temp[k];
		}
	}

	public static void radixSort(int[] arr) {
		// 基数排序时间复杂度

		int[] bucketIndex = new int[10];
		boolean flag = true;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();
		for (int k = 0, modnum = 1; k < maxLength; k++, modnum *= 10) {
			for (int i = 0; i < 10; i++) {
				bucketIndex[i] = 0;
			}
			int[][] bucket = new int[10][arr.length];
			for (int i = 0; i < arr.length; i++) {
				bucket[arr[i] / modnum % 10][bucketIndex[arr[i] / modnum % 10]] = arr[i];
				bucketIndex[arr[i] / modnum % 10]++;
			}
			int index = 0;
			for (int i = 0; i < bucket.length; i++) {
				if (bucketIndex[i] != 0) {
					for (int j = 0; j < bucketIndex[i]; j++) {
						arr[index] = bucket[i][j];
						index++;
					}
				}
			}
//			System.out.println(Arrays.toString(arr));
		}
	}
	
}
