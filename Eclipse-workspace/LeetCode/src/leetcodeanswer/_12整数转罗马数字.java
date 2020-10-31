package leetcodeanswer;

import java.util.HashMap;

public class _12整数转罗马数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution12 solution12 = new Solution12();
		String string = solution12.intToRoman(58);
		System.out.println(string);

	}

}

class Solution12 {
	public String intToRoman(int num) {
		int values[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String reps[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		String str = "";

		for (int i = 0; i < reps.length; i++) {
			while (num >= values[i]) {
				str += reps[i];
				num -= values[i];
			}
		}

		return str;

	}
}