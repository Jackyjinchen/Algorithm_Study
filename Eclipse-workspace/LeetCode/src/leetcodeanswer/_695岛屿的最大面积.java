package leetcodeanswer;

public class _695岛屿的最大面积 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		Solution695 sl = new Solution695();
		System.out.println(sl.maxAreaOfIsland(grid));

	}

}

class Solution695 {
	public int maxAreaOfIsland(int[][] grid) {
		int maxarea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					maxarea = Math.max(maxarea, square(i, j, grid));
			}
		}

		return maxarea;
	}

	public int square(int x, int y, int[][] grid) {
		int square = 0;
		if (grid[x][y] == 0) {
			return 0;
		}
		if (grid[x][y] == 1) {
			grid[x][y] = 2;
			square++;
		}
		if (x-1>=0&&grid[x - 1][y] == 1) {// 左
			square += square(x - 1, y, grid);
		}
		if (x+1<grid.length&&grid[x + 1][y] == 1) {// 右
			square += square(x + 1, y, grid);
		}
		if (y-1>=0&&grid[x][y - 1] == 1) {// 上
			square += square(x, y - 1, grid);
		}
		if (y+1<grid[0].length&&grid[x][y + 1] == 1) {// 下
			square += square(x, y + 1, grid);
		}

		return square;

	}

}