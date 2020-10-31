package com.Jacky.queue;

import java.util.Queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// ����
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("��ʾ����:s");
			System.out.println("�������:a");
			System.out.println("ɾ������:d");
			System.out.println("�˳�����:e");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("����һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'd':
				try {
					queue.deleteQueue();
					System.out.println("��ɾ��");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�������");

	}

}

class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize + 1;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("������");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;

	}

	public void deleteQueue() {
		if (isEmpty())
			// System.out.println("���п�");
			throw new RuntimeException("���п�");
		front = (front + 1) % maxSize;
	}

	public void showQueue() {
		if (!isEmpty()) {
			if (rear>front) {
				for (int i = front; i < rear; i++) {
					System.out.printf("%d\t", arr[i]);
				}
			}
			else {
				for (int i = front; i < maxSize; i++) {
					System.out.printf("%d\t", arr[i]);
				}
				for (int i = 0; i < rear; i++) {
					System.out.printf("%d\t", arr[i]);
				}
			}

		}
		else {
			System.out.println("���п�");
		}
		System.out.println();
	}

}
