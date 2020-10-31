package VMware;

import java.util.Scanner;

public class exam2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner cin = new Scanner(System.in);

		while (cin.hasNextInt()) {
			int a = cin.nextInt();
			int b = cin.nextInt();
			int k = cin.nextInt();
			int ans=0;
			boolean flag=false;
			for (int i = a; i <= b; i++) {
				for (int j = 2; j < k; j++) {
					if (i % j == 0) {
						flag=true;
						break;
					}
				}
				if(i%k==0&&flag==false) ans++;

				flag=false;
			}

			System.out.println(ans);
		}
	}

}
