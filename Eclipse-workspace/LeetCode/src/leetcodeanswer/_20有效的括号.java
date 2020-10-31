package leetcodeanswer;

import java.util.HashMap;
import java.util.Stack;

public class _20��Ч������ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="()";
		Solution20 sl = new Solution20();
		System.out.println(sl.isValid(s));
		
		
		
	}

}


//����ջ����ʽ��������ֵ��������ţ���ջ��������Ŷԣ��Ͱ�ջ������
//�Ƚ�ջ���������ƥ���˵�����ŶԲ���ȷ��
//			����������ţ�ֱ����ջ

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
