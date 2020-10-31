package com.Jacky.Recursion;

public class Mazerecursion {
	public static void main(String[] args) {
		int[][] map = { { 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 0, 0, 1, 0, 1, 1 },
						{ 1, 1, 0, 0, 0, 0, 1 },
						{ 1, 0, 0, 0, 1, 0, 1 },
						{ 1, 0, 1, 0, 1, 0, 1 },
						{ 1, 0, 0, 0, 1, 0, 1 },
						{ 1, 0, 1, 0, 1, 0, 1 },
						{ 1, 1, 1, 1, 1, 1, 1 } };
//		for (int i = 0; i < 7; i++) {
//			map[0][i] = 1;
//			map[7][i] = 1;
//		}
//		for (int i = 0; i < 8; i++) {
//			map[i][0] = 1;
//			map[i][6] = 1;
//		}
		if(setWay(map, 1, 1)) {
			System.out.println("找到路了");
		}else {
			System.out.println("没有路");
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.printf(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			return true;
		} else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if(setWay(map, i+1, j)) {
					return true;
				}else if (setWay(map, i, j+1)) {
					return true;
				}else if (setWay(map, i-1, j)) {
					return true;
				}else if (setWay(map, i, j-1)) {
					return true;
				}else {
					map[i][j]=3;
					return false;
				}
			}else {
				return false;
			}
		}
	}

}
