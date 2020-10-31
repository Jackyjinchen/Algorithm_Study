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

	// ���ûʺ󷽷�
	private void Check(int n) {
		if (n == max) {
			print();
			return;
		}

		// ���η���ʺ��ж��Ƿ��ͻ
		for (int i = 0; i < array.length; i++) {
			array[n] = i;
			if (Judge(n)) {
				// ����ͻ�·�һ��
				Check(n + 1);
			}

		}
	}

	// ���õ�n���ʺ�ʱ����Ƿ��ͻ
	private boolean Judge(int n) {
		for (int i = 0; i < n; i++) {
			// Math.abs(n-i)==Math.abs(array[n]-array[i]) �ж��Ƿ���ͬһб��
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
