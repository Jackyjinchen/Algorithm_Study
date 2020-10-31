package Nowcoder;

import java.util.ArrayList;

public class _À≥ ±’Î¥Ú”°æÿ’Û {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int matrix[][] = { { 1, 2, 3, 4 } ,{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		SolutionÀ≥ ±’Î solution = new SolutionÀ≥ ±’Î();
		ArrayList<Integer> answer = solution.printMatrix(matrix);
		System.out.println(answer.toString());
	}

}

class SolutionÀ≥ ±’Î {
	public ArrayList<Integer> printMatrix(int[][] matrix) {

		if (matrix.length==0) {
			return new ArrayList<Integer>();
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0, y = 0;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		while (m > 0 && n > 0) {
			if(m==1) {
				for (int i = 0; i < n; i++) {
					arrayList.add(matrix[x][y++]);
				}
				return arrayList;
			}		
			if(n==1) {
				for (int i = 0; i < m; i++) {
					arrayList.add(matrix[x++][y]);
				}
				return arrayList;
			}		
			for (int i = 0; i < n - 1; i++) {
				arrayList.add(matrix[x][y++]);
			}
			for (int i = 0; i < m - 1; i++) {
				arrayList.add(matrix[x++][y]);
			}
			for (int i = 0; i < n - 1; i++) {
				arrayList.add(matrix[x][y--]);
			}
			for (int i = 0; i < m - 1; i++) {
				arrayList.add(matrix[x--][y]);
			}
			m-=2;
			n-=2;
			x++;
			y++;
		}
		return arrayList;
	}
}
