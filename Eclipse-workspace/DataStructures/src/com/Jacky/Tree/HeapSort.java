package com.Jacky.Tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 6, 8, 5, 9 };
		heapSort(arr);
	}

	public static void heapSort(int arr[]) {
		System.out.println("堆排序");
		int temp = 0;
//		adjustHeap(arr, 1, arr.length);
//		System.out.println("First"+Arrays.toString(arr));

		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}

		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}

		System.out.println(Arrays.toString(arr));

	}

	/**
	 * 调整数组为大顶堆
	 * 
	 * @param arr
	 * @param i      表示非叶子节点在数组中的索引
	 * @param length 表示对多少个元素进行调整
	 */
	public static void adjustHeap(int arr[], int i, int length) {

		int temp = arr[i];
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) { // 左节点小于右节点
				k++;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
//				arr[k]=temp;
			} else {
				break;
			}
		}
		//
		arr[i] = temp;

	}

}
