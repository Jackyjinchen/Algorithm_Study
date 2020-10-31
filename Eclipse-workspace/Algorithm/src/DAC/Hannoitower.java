package DAC;

public class Hannoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hannoiTower(5, 'A', 'B', 'C');
		System.out.println("完成了移动");
	}

	// 汉诺塔移动方法
	// 分治算法

	public static void hannoiTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("第1个盘从" + a + "->" + c);
		} else {
			hannoiTower(num - 1, a, c, b);
			System.out.println("第" + num + "个盘从" + a + "->" + c);

			hannoiTower(num - 1, b, a, c);

		}
	}

}
