package com.Jacky.linkedlist;

import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack();
		//push��add��ͬ����ͬ����add����boolean push���ز���Ĳ���
		stack.push("x");
		stack.push("y");
		stack.push("z");
		//Stack�Ƚ���� ��������ѹջ�ٳ�ջ
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

}
