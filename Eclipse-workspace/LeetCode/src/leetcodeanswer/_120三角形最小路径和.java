package leetcodeanswer;

import java.util.ArrayList;
import java.util.List;


public class _120三角形最小路径和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		triangle.add(list1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		triangle.add(list2);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		triangle.add(list3);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list4);

//		System.out.println(triangle);

		Solution120 sl = new Solution120();
		System.out.println(sl.minimumTotal(triangle));

	}

}

class Solution120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() < 1) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		int temp = 0;
		int lens = triangle.size();

		for (int i = lens - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				triangle.get(i).set(j,
						triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
			}
		}

		return triangle.get(0).get(0);
	}

}