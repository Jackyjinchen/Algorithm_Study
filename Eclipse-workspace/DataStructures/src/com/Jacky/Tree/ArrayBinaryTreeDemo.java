package com.Jacky.Tree;

public class ArrayBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1,3,6,8,10,14};
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
//		arrayBinaryTree.preOrder(0);
		arrayBinaryTree.infixOrder(0);
	}

}

class ArrayBinaryTree {
	private int[] arr;

	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}

	/**
	 * 
	 * @param index 数组下标
	 */
	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("Empty");
		}
		System.out.println(arr[index]);

		if (2 * index + 1 < arr.length) {
			preOrder(2 * index + 1);
		}
		if (2 * index + 2 < arr.length) {
			preOrder(2 * index + 2);
		}

	}

	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("Empty");
		}
		if (2 * index + 1 < arr.length) {
			infixOrder(2 * index + 1);
		}
		System.out.println(arr[index]);
		if (2 * index + 2 < arr.length) {
			infixOrder(2 * index + 2);
		}

	}

}