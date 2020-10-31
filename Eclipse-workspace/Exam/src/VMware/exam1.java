package VMware;

import java.util.Scanner;

public class exam1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner cin = new Scanner(System.in);
		while (cin.hasNextInt()) {

			int T = cin.nextInt();
			for (int i = 0; i < T; i++) {

				int n = cin.nextInt();
				int k = cin.nextInt();
				StringBuilder sb = new StringBuilder();
				int temp=0, ans;
				if (n % 2 == 0) {
					temp = (int) Math.pow(10, n / 2 - 1);
//					System.out.println(temp);
					temp = temp + k - 1;

					sb.append(temp);
					sb.reverse();
					sb.insert(0, temp);

				} else {

					temp = (int) Math.pow(10, n / 2);
					if(temp==1)temp=0;
					temp = temp + k - 1;
					sb.append(temp);
					sb.reverse();
					sb.delete(0, 1);
					sb.insert(0, temp);
				}

				System.out.println(sb.toString());

			}

		}
	}

}
