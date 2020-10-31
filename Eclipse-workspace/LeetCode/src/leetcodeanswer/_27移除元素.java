package leetcodeanswer;

public class _27ÒÆ³ıÔªËØ {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		Solution27 sl = new Solution27();
		int k = sl.removeElement(nums, 4);
		for (int i = 0; i < k; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}

class Solution27 {

	
    public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}

		return i;
    }
	
}