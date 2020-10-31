package com.Jacky.Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Sort_method {

	public static void main(String[] args) {

//		 ��ʼ������
//		int[] arr = new int[80000];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = (int) (Math.random() * 800000);
//		}
		
		int[] arr= {1,1,1,5,1,1,1};

		// ��ʼʱ��
		Date date1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(date1);
		System.out.println("����ǰʱ��=" + date1Str);

		//ð������
//		bubbleSort(arr);
//		ѡ������
//		selectSort(arr);
		//��������
//		insertSort(arr);
		//ϣ������
//		shellSort(arr);
//		shellSort2(arr);
		//��������
		quickSort1(arr, 0, arr.length - 1);

		//�鲢����
//		int temp[] =new int[arr.length];
//		mergeSort(arr, 0, arr.length-1, temp);
		
		//��������
//		radixSort(arr);
//		System.out.println("�������");
//		System.out.println(Arrays.toString(arr));

		// ����ʱ��
		Date date2 = new Date();
		String date2Str = simpleDateFormat.format(date2);
		System.out.println("�����ʱ��=" + date2Str);
	}

	public static void bubbleSort(int[] arr) {
		// ѡ������ʱ�临�Ӷ�O(n^2)
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
		// ð������ʱ�临�Ӷ�O(n^2)
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
		// ��������ʱ�临�Ӷ�O(n^2)
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

	// ����ϣ������
	public static void shellSort1(int[] arr) {
		// ϣ������ʱ�临�Ӷ�
		int temp = 0;
		// ����ǰ����𲽷�����ʹ��ѭ������
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

	// ����ϣ������
	public static void shellSort(int[] arr) {
		// ϣ������ʱ�临�Ӷ�
		int j = 0;
		int temp = 0;
		// ����ǰ����𲽷�����ʹ��ѭ������
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
		// ����ʱ�临�Ӷ�
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		// ��pivotС�ķŵ���ߣ���ķ����ұ�
		while (l < r) {
			while (arr[l] < pivot) {
				l++;
			}
			while (arr[r] > pivot) {
				r--;
			}
			// ʵ���� ���С�� �ұߴ�
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
		// ����ʱ�临�Ӷ�

		int tmp = arr[low];
		int i = low;
		int j = high;

		while (i < j) {
			// �ȿ��ұߣ���������ݼ���ֱ���ҵ�С�ڻ�׼��������
			while (arr[j] >= tmp && i < j) {
				j--;
			}
			// �Ȼ�׼С�ļ�¼�Ƶ��Ͷ�
			arr[i] = arr[j];

			// ����ߣ��������ҵ�����ֱ���ҵ����ڻ�׼��������
			while (arr[i] <= tmp && i < j) {
				i++;
			}
			// �Ȼ�׼��ļ�¼�Ƶ��߶�
			arr[j] = arr[i];
		}

		// ��¼��׼
		arr[i] = tmp;

		// �ݹ�����������
		if (low < j - 1) {
			quickSort(arr, low, j - 1);
		}

		// �ݹ�����Ұ�����
		if (j + 1 < high) {
			quickSort(arr, j + 1, high);
		}

	}

	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
			// �ϲ�
			merge(arr, left, mid, right, temp);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		// �鲢����ʱ�临�Ӷ�
		int i = left;
		int j = mid + 1;
		int t = 0;

		// ˳�����temp
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
		// ʣ��һ������ȫ������temp
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
		// temp���¿���arr��
		for (int k = 0; k < t; k++) {
			arr[left + k] = temp[k];
		}
	}

	public static void radixSort(int[] arr) {
		// ��������ʱ�临�Ӷ�

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
