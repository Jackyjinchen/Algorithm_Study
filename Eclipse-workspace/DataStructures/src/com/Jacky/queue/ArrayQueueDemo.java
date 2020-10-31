package com.Jacky.queue;

import java.util.Queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// 测试
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("显示队列:s");
			System.out.println("添加数据:a");
			System.out.println("删除数据:d");
			System.out.println("退出程序:e");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("输入一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'd':
				try {
					queue.deleteQueue();
					System.out.println("已删除");
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
		System.out.println("程序结束");

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
			System.out.println("队列满");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;

	}

	public void deleteQueue() {
		if (isEmpty())
			// System.out.println("队列空");
			throw new RuntimeException("队列空");
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
			System.out.println("队列空");
		}
		System.out.println();
	}

}
