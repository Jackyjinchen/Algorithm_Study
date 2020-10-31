package com.Jacky.Recursion;


public class EightQueenDemo {

	int max = 8;
	int[] array = new int[max];
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EightQueenDemo queen8 = new EightQueenDemo();
		queen8.Check(0);
		System.out.print(count);

	}

	// 放置皇后方法
	private void Check(int n) {
		if (n == max) {
			print();
			return;
		}

		// 依次放入皇后并判断是否冲突
		for (int i = 0; i < array.length; i++) {
			array[n] = i;
			if (Judge(n)) {
				// 不冲突下放一个
				Check(n + 1);
			}

		}
	}

	// 放置第n个皇后时检测是否冲突
	private boolean Judge(int n) {
		for (int i = 0; i < n; i++) {
			// Math.abs(n-i)==Math.abs(array[n]-array[i]) 判断是否是同一斜线
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		count++;
		System.out.println();
	}
}
