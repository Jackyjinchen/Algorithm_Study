package leetcodeanswer;

import java.util.Scanner;
import java.util.Stack;


public class _155��Сջ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack obj = new MinStack();

		String key = "";
		Scanner sc = new Scanner(System.in);
		boolean loop = true;

		while (loop) {
			System.out.println("�������:push");
			System.out.println("��������:pop");
			System.out.println("���ջ��:top");
			System.out.println("��Сֵ:getmin");
			System.out.println("�˳�����:exit");
			key = sc.nextLine();
			switch (key) {
			case "pop":
				obj.pop();
				System.out.println("��ɾ��");
				break;
			case "push":
				System.out.println("����һ����");
				int value = sc.nextInt();
				obj.push(value);
				break;
			case "top":
				System.out.println(obj.top());
				break;
			case "getmin":
				System.out.println(obj.getMin());
				break;
			case "exit":
				sc.close();
				loop = false;
				break;
			default:
				break;
			}

		}
//		obj.push(5);
//		obj.push(4);
//		obj.push(1);
//		obj.push(3);
//		obj.push(2);
//		obj.push(6);
//		obj.pop();
//		int param_3 = obj.top();
//		int param_4 = obj.getMin();
//		System.out.println(param_3);
//		System.out.println(param_4);

	}

}

class MinStack {
	Stack<Integer> stack;
	Stack<Integer> minstack;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new Stack<>();
		minstack = new Stack<>();
	}

	public void push(int x) {

		if (minstack.isEmpty() || x <= minstack.peek()) {
			minstack.add(x);
		}
		stack.add(x);
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int top=stack.pop();
			if(top==minstack.peek()) {
				minstack.pop();
			}

		}

	}

	public int top() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		throw new RuntimeException("ջ��");
		
	}

	public int getMin() {
		if (!minstack.isEmpty()) {

			return minstack.peek();
		}
		throw new RuntimeException("ջ��");

	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */