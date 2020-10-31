package leetcodeanswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class _06Z×ÖÐÎ±ä»» {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "PAYPALISHIRING";
		Solution06 solution = new Solution06();
		solution.convert(str, 3);
	}

}

class Solution06 {
	public String convert(String s, int numRows) {
		if (numRows==1) return s;
		StringBuilder[] arr=new StringBuilder[numRows];
		
		for (int i = 0; i < numRows; i++) {
			arr[i]=new StringBuilder();
		}
		
		boolean flag=false;
		int index=0;
		int curRow=0;
		for (int i = 0; i < s.length(); i++) {
			arr[curRow].append(s.charAt(i));
			if(curRow==0||curRow==numRows-1) {
				flag= !flag;
			}
			curRow+=flag?1:-1;
		}
		
		for (int i = 1; i < numRows; i++) {
			arr[0].append(arr[i]);
		}
		
//		System.out.println();
		return arr[0].toString();
	}
}




//class Solution {
//	public String convert(String s, int numRows) {
//		if (numRows==1) return s;
//		char[][] matrix = new char[numRows][s.length() / (2*numRows-2) * (numRows - 1)+s.length()%(2*numRows-2)-numRows+2];
//		int[][] ix = new int[numRows][s.length() / (2*numRows-2) * (numRows - 1)+s.length()%(2*numRows-2)-numRows+2];
//		int index = 0;
//		int pointer = 0;
//		while (index < s.length()) {
//			for (int i = 0; i < numRows; i++) {
//				matrix[i][pointer] = s.charAt(index);
//				ix[i][pointer] = 1;
//				index++;
//				if (index == s.length())
//					break;
//			}
//			pointer++;
//			if (index == s.length())
//				break;
//			for (int i = numRows - 2; i > 0; i--, pointer++) {
//				matrix[i][pointer] = s.charAt(index);
//				ix[i][pointer] = 1;
//				index++;
//				if (index == s.length())
//					break;
//			}
//
//		}
//		StringBuilder sBuilder = new StringBuilder();
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				if (ix[i][j] == 1) {
//					sBuilder.append(matrix[i][j]);
//				}
//			}
//		}
//		System.out.println(sBuilder.toString());
////
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		return sBuilder.toString();
//	}
//}