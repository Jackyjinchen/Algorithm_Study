package DAC;

public class Hannoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hannoiTower(5, 'A', 'B', 'C');
		System.out.println("������ƶ�");
	}

	// ��ŵ���ƶ�����
	// �����㷨

	public static void hannoiTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("��1���̴�" + a + "->" + c);
		} else {
			hannoiTower(num - 1, a, c, b);
			System.out.println("��" + num + "���̴�" + a + "->" + c);

			hannoiTower(num - 1, b, a, c);

		}
	}

}
