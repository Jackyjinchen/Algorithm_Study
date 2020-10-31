package VMware;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class exam3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {
			int n = cin.nextInt();
			int item[][] = new int[n][2];

			for (int i = 0; i < n; i++) {
				item[i][0] = cin.nextInt();
				item[i][1] = cin.nextInt();
			}
			Solution sl = new Solution();
			System.out.println(sl.max(item));

		}
	}

}

class Solution {

	public int max(int[][] item) {

		Arrays.sort(item, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO 自动生成的方法存根
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				}
				return (o1[1] - o2[1]);
			}

		});
		
		System.out.println(Arrays.toString(item[0]));
		System.out.println(Arrays.toString(item[1]));
		System.out.println(Arrays.toString(item[2]));
		System.out.println(Arrays.toString(item[3]));
		
		
		
		int anum = 0;
		int bb2 = 0;
		int bb1 = 0;
		for (int i = 0; i < item.length; i++) {
			if (item[i][0]==0) {
				anum++;
			}else if (bb1 + item[i][0] > anum)
				anum++;
			else {
				bb1 += item[i][0];
				bb2 += item[i][1];
			}

		}
		return bb2;

	}

}
