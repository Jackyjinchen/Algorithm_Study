package com.Jacky.stack;

public class StackCalculater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack2 numStack = new ArrayStack2(500);
		ArrayStack2 operStack = new ArrayStack2(500);
		String expressionString = "7*2*2-5+1-5+3-4";
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";
		while (true) {
			ch = expressionString.substring(index, index + 1).charAt(0);
//			System.out.printf("%s", ch);

			if (operStack.isOper(ch)) {
				if (!operStack.isEmpty()) {
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						operStack.push(ch);
						numStack.push(res);
					} else {
						operStack.push(ch);
					}
				} else {
					operStack.push(ch);
				}

			} else {
				//处理数据大于一位的问题
				keepNum += ch;
				if (index == expressionString.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					if (operStack.isOper(expressionString.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";
					}
				}

			}
			index++;
			if (index >= expressionString.length()) {
				break;
			}
		}
		while (true) {
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		System.out.printf("%s = %d", expressionString, numStack.peek());
//		operStack.show();
//		numStack.show();
	}
}

class ArrayStack2 {
	private int maxSize;
	private int[] stack; // 数组模拟栈
	private int top = -1;

	public ArrayStack2(int maxSize) {
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
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空");
//			System.out.println("栈空");
//			return;
		}
		int value = stack[top];
		top--;
		return value;
	}

	public int peek() {
		return stack[top];
	}

	public void show() {
		if (isEmpty()) {
//			throw new RuntimeException("栈空");
			System.out.println("栈空");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

	// 返回优先级
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	// 判断是不是运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	// 计算方法
	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '-':
			res = num2 - num1;
			break;
		case '+':
			res = num2 + num1;
			break;
		case '*':
			res = num2 * num1;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}

}
