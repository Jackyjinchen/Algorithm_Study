package leetcodeanswer;

public class _11盛最多水的容器 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		Solution11 solution11 = new Solution11();
		System.out.println(solution11.maxArea(height));

	}

}

//vilentSearch
class Solution11 {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int max = (right - left) * Math.min(height[left], height[right]);

		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}

		}
		return max;
	}
}
