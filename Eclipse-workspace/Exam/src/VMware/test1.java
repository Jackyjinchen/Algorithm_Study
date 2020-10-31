package VMware;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner cin = new Scanner(System.in);

		while (cin.hasNextInt()) {

			int N = cin.nextInt();
			int M = cin.nextInt();
			HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
			HashSet<Integer> hashSet = new HashSet<>();
			hashSet.add(1);
			for (int i = 0; i < M; i++) {
				int a = cin.nextInt();
				int b = cin.nextInt();
				int c = cin.nextInt();
				if (c == 1) {
					if (hashSet.contains(a)) {
						hashSet.add(b);
						if (hashMap.containsKey(b)) {
							hashSet.add(hashMap.get(b));
							hashMap.remove(b);
						}
					} else if (hashSet.contains(b)) {
						hashSet.add(a);
						if (hashMap.containsKey(a)) {
							hashSet.add(hashMap.get(a));
							hashMap.remove(a);
						}
					} else {
						hashMap.put(a, b);
						hashMap.put(b, a);
					}
				}
			}
			System.out.println(hashSet.size() - 1);
		}

	}

}
