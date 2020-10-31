package com.Jacky.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack arrayStack = new ArrayStack(5);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);

		while (loop) {
			System.out.println("show:s");
			System.out.println("exit:e");
			System.out.println("push:i");
			System.out.println("pop:o");
			key = scanner.next();
			switch (key) {
			case "s":
				arrayStack.show();
				break;
			case "e":
				loop = false;
				break;
			case "i":
				System.out.println("input number");
				int value = scanner.nextInt();
				arrayStack.push(value);
				break;
			case "o":
				try {
					System.out.printf("out number is£º %d\n", arrayStack.pop());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}
		}
		scanner.close();
	}

}

class ArrayStack {
	private int maxSize;
	private int[] stack; // Êý×éÄ£ÄâÕ»
	private int top = -1;

	public ArrayStack(int maxSize) {
		// TODO Auto-generated constructor stub
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("Õ»Âú");
			return;
		}
		top++;
		stack[top] = value;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Õ»¿Õ");
//			System.out.println("Õ»¿Õ");
//			return;
		}
		int value = stack[top];
		top--;
		return value;
	}

	public void show() {
		if (isEmpty()) {
//			throw new RuntimeException("Õ»¿Õ");
			System.out.println("Õ»¿Õ");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

}
