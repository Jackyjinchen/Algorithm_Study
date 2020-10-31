package com.Jacky.Search;

import java.util.ArrayList;
import java.util.List;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		System.out.println(binarysearchmulit(arr, 3, 0, arr.length - 1));
		System.out.println(insertsearchmulit(arr, 3, 0, arr.length - 1));
	}

	public static int binarysearch(int[] arr, int value, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;

		if (arr[mid] > value) {
			return binarysearch(arr, value, left, mid - 1);
		} else if (arr[mid] < value) {
			return binarysearch(arr, value, mid + 1, right);
		} else {

			return mid;
		}

	}

	public static List<Integer> binarysearchmulit(int[] arr, int value, int left, int right) {
		System.out.println("hello");
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		//改成下式就是插值查找
		if (arr[mid] > value) {
			return binarysearchmulit(arr, value, left, mid - 1);
		} else if (arr[mid] < value) {
			return binarysearchmulit(arr, value, mid + 1, right);
		} else {
			//
			List<Integer> resIndexlist = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != value) {
					break;
				}
				resIndexlist.add(temp);
				temp--;
			}
			resIndexlist.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != value) {
					break;
				}
				resIndexlist.add(temp);
				temp++;
			}

			return resIndexlist;
		}

	}
	
	public static List<Integer> insertsearchmulit(int[] arr, int value, int left, int right) {
		System.out.println("hello");
		//避免mid越界
		if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
			return new ArrayList<Integer>();
		}
//		int mid = (left + right) / 2;
		//改成下式就是插值查找
		int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
		if (arr[mid] > value) {
			return binarysearchmulit(arr, value, left, mid - 1);
		} else if (arr[mid] < value) {
			return binarysearchmulit(arr, value, mid + 1, right);
		} else {
			//
			List<Integer> resIndexlist = new ArrayList<Integer>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != value) {
					break;
				}
				resIndexlist.add(temp);
				temp--;
			}
			resIndexlist.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || arr[temp] != value) {
					break;
				}
				resIndexlist.add(temp);
				temp++;
			}

			return resIndexlist;
		}

	}
	

}
