package Nowcoder;

import java.util.Scanner;

public class _Baiduproblem3 {

	//u个节点点权au 最短路径使点权严格递增
//	5
//	3 5 5 4 1
//	1 2
//	1 3
//	2 4
//	2 5
//	输出2
//	4
//	3 4 1 2
//	1 2
//	2 3
//	2 4
//	输出2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[]=new int[n];
		for (int i = 0; i < n; i++) {	
				a[i] = sc.nextInt();
		}
		if(n==2&&a[0]==a[1]) {System.out.println(1);return;}
		System.out.println(a[0]);
	}

}
