package leetcodeanswer;

public class _657机器人能否返回原点 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution657().judgeCircle("LL"));
	}

}

class Solution657 {
	public boolean judgeCircle(String moves) {
		if (moves.length() % 2 == 1)
			return false;

		int x = 0, y = 0;
		for (int i = 0; i < moves.length(); i++) {
			char ch = moves.charAt(i);
			System.out.println(ch);
			if (ch == 'U') {
				y++;
			} else if (ch == 'D') {
				y--;
			} else if (ch == 'R') {
				x++;
			} else if (ch == 'L') {
				x--;
			}
		}
		System.out.println(x + "" + y);
		if (x == 0 && y == 0)
			return true;

		return false;
	}
}