package com.Jacky.linkedlist;

import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack();
		//push和add相同，不同在于add返回boolean push返回插入的参数
		stack.push("x");
		stack.push("y");
		stack.push("z");
		//Stack先进后出 单链表先压栈再出栈
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

}
