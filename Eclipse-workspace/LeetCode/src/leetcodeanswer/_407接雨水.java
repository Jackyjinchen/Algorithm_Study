package leetcodeanswer;

public class _407接雨水 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 12, 13, 1, 12 },
						{ 13, 4, 13, 12 },
						{ 13, 8, 10, 12 },
						{ 12, 13, 12, 12 },
						{ 13, 13, 13, 13 } };
		Solution407 sl = new Solution407();
		sl.trapRainWater(arr);
//		System.out.println(sl.trapRainWater(arr));

	}

}
////////////////////////////////////////////////////////////////////////////

//未解决
////////////////////////////////////////////////////////////////////////////
class Solution407 {
	public int trapRainWater(int[][] heightMap) {

		if (heightMap.length < 3 || heightMap[0].length < 3)
			return 0;
		int ans = 0;
		int row = heightMap.length;
		int column = heightMap[0].length;

		int[][] right = new int[row][column];
		int[][] left = new int[row][column];
		int[][] up = new int[row][column];
		int[][] down = new int[row][column];

		for (int i = 0; i < row; i++) {
			right[i][0] = heightMap[i][0];
			right[i][column - 1] = heightMap[i][column - 1];
			left[i][0] = heightMap[i][0];
			left[i][column - 1] = heightMap[i][column - 1];
			up[i][0] = heightMap[i][0];
			up[i][column - 1] = heightMap[i][column - 1];
			down[i][0] = heightMap[i][0];
			down[i][column - 1] = heightMap[i][column - 1];
		}

		for (int i = 0; i < column; i++) {
			right[0][i] = heightMap[0][i];
			right[row - 1][i] = heightMap[row - 1][i];
			left[0][i] = heightMap[0][i];
			left[row - 1][i] = heightMap[row - 1][i];
			up[0][i] = heightMap[0][i];
			up[row - 1][i] = heightMap[row - 1][i];
			down[0][i] = heightMap[0][i];
			down[row - 1][i] = heightMap[row - 1][i];

		}

		// 左侧最高表
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				left[i][j] = Math.max(heightMap[i][j], left[i][j - 1]);
//				System.out.print(left[i][j]+" ");
			}
//			System.out.println();
		}
		

		

		// 右侧最高表
		for (int i = row - 2; i >= 1; i--) {
			for (int j = column - 2; j >= 1; j--) {
				right[i][j] = Math.max(heightMap[i][j], right[i][j + 1]);
//				System.out.print(right[i][j]+" ");
			}
//			System.out.println();
		}


		
		// 上侧最高表
		for (int i = 1; i < column - 1; i++) {
			for (int j = 1; j < row - 1; j++) {
				up[j][i] = Math.max(heightMap[j][i], up[j - 1][i]);
//				System.out.print(up[j][i]+" ");
			}
//			System.out.println();
		}


		// 下侧最高表
		for (int i = column - 2; i >= 1; i--) {
			for (int j = row - 2; j >= 1; j--) {
				down[j][i] = Math.max(heightMap[j][i], down[j + 1][i]);
//				System.out.print(down[j][i]+" ");
			}
//			System.out.println();
		}
		
		
		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < column-1; j++) {
				System.out.print(heightMap[i][j]+""+left[i][j]+""+right[i][j]+""+up[i][j]+""+down[i][j]+" ");
			}
			System.out.println();
		}

		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < column - 1; j++) {
				ans = ans + Math.min(Math.min(up[i][j], down[i][j]), Math.min(left[i][j], down[i][j]))
						- heightMap[i][j];
//				System.out.print(ans+" ");
			}
//			System.out.println();

		}

		return ans;

	}
}