package leetcodeanswer;

import java.util.HashMap;
import java.util.Stack;

public class _20有效的括号 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="()";
		Solution20 sl = new Solution20();
		System.out.println(sl.isValid(s));
		
		
		
	}

}


//采用栈的形式，如果出现的是右括号，和栈顶组成括号对，就把栈顶弹出
//比较栈顶，如果不匹配就说明括号对不正确。
//			如果是左括号，直接入栈

class Solution20 {

	private HashMap<Character, Character> mappings;

	// Initialize hash map with mappings. This simply makes the code easier to read.
	public Solution20() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put('}', '{');
		this.mappings.put(']', '[');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (this.mappings.containsKey(c)) {
				char topElem = stack.empty() ? '#' : stack.pop();
				if (topElem != this.mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}

		}

		return stack.isEmpty();
	}
}
