package com.Jacky.stack;

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class PolandCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String suffixExpression = "3 4 + 5 * 6 -";
//		List<String> rpnList = getListString(suffixExpression);
//		System.out.println("rpnList" + rpnList);
//
//		int res = calculate(rpnList);
//		System.out.println("Answer = " + res);
		String expression = "1+((2+1)*4)-5";
		System.out.println(toInfixExpressionList(expression));
		System.out.println(parseSuffixExpressionList(toInfixExpressionList(expression)));
		System.out.println(calculate(parseSuffixExpressionList(toInfixExpressionList(expression))));

	}

	// 将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
	public static List<String> getListString(String suffixExpression) {
		// 将 suffixExpression 分割
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;

	}

	// 计算后缀表达式的结果
	public static int calculate(List<String> ls) {
		Stack<String> stack = new Stack<String>();
		for (String item : ls) {
			// 正则表达式取数据
			if (item.matches("\\d+")) {// 匹配多位数
				stack.push(item);
			} else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num1 - num2;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num1 / num2;
				} else {
					throw new RuntimeException("Error");
				}
				stack.push(res + "");
			}
		}
		return Integer.parseInt(stack.pop());
	}

	// 中缀转后缀list
	public static List<String> parseSuffixExpressionList(List<String> ls) {
		Stack<String> s1 = new Stack<String>();
		// s2没有pop操作，还需要逆序输出，值解用ArrayList
		List<String> s2 = new ArrayList<String>();

		for (String item : ls) {
			if (item.matches("\\d+")) {
				s2.add(item);
			} else if (item.equals("(")) {
				s1.push(item);
			} else if (item.equals(")")) {
				while(!s1.peek().equals("(")){
					s2.add(s1.pop());
				}
				s1.pop();
			}else {
				//item优先级小于s1栈顶优先级，s1->s2然后item再次判断
				while (s1.size()!=0&&Operation.getValue(item)<Operation.getValue(s1.peek())) {
					s2.add(s1.pop());	
				}
				s1.push(item);
			}
		}
		while (s1.size()!=0) {
			s2.add(s1.pop());		
		}
		
		return s2;//因为存放到List，顺序数据就是后缀表达式的list
	}

	// 中缀表达式转换成List
	public static List<String> toInfixExpressionList(String s) {
		List<String> ls = new ArrayList<String>();
		int i = 0;// 索引指针，遍历
		String str;
		char c;
		do {
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else {
				str = "";
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					str += c;
					i++;
				}
				ls.add(str);
			}
		} while (i < s.length());
		return ls;
	}

}

class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("Error Operator");
			break;
		}
		return result;
	}
}