package leetcodeanswer;

public class _42接雨水 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Solution42 sl = new Solution42();
		System.out.println(sl.trap(height));
	}

}



//动态规划，从暴力搜索中取得思路
//分别找到每个位置左侧和右侧最大值的高度即可
class Solution42 {
public int trap(int[] height) {
	if (height.length < 2) return 0;
	int ans=0;
	int size=height.length;
	int[] left = new int[size]; //左边最高的数据
	int[] right = new int[size];//右边最高的数据
	
	left[0]=height[0];
	for (int i = 1; i < size; i++) {
		left[i]=Math.max(height[i], left[i-1]);
	}
	right[size-1]=height[size-1];
	for (int i = size-2; i >=0; i--) {
		right[i]=Math.max(height[i], right[i+1]);
	}
	
	for (int i = 0; i <size; i++) {
		ans=ans+Math.min(left[i], right[i])-height[i]; //水的高度就是左右最高数据中的较小值，和当前位置的高度差
	}	
	return ans;
	}
}


////1、首先用指针i指向第一个非零元素
////2、利用j开始向右滑动，同时记录i的下一位开始的次高位位置：
////	如果找到高度高于或等于他的：
////		j-i=1，此时说明没有接雨水，i后移一位
////		j-i>1,接到了雨水，可以算这一段有多少水，然后将i指向j所在的位置
////	如果没找到比i位置高度高或相等的
////		判断次高位
////			次高位紧邻i，说明没存水，i++
////			次高位没有紧邻i，说明存水了，求存的水，重新指向i=次高位位置；
//class Solution42 {
//public int trap(int[] height) {
//
//	if (height.length < 2) {
//		return 0;
//	}
//	int i = 0, j = 0;
//	int volume = 0;
//	int secondhighindex = 0;
//	// 从左找到第一个高度不为零的
//	while (height[i] < 1 && i < height.length) {
//		i++;
//	}
//	j = i + 1;
//	secondhighindex = j;
//	// 开始
//	while (i < height.length) {
//
//		while (j < height.length) {
//			if (height[j] > height[secondhighindex]) {
//				secondhighindex = j;
//			}
//			if (height[j] >= height[i]) {
//				break;
//			}
//			j++;
//		}
//		if (j < height.length) {
//			if (j - i > 1) {
//				for (int k = i + 1; k < j; k++) {
//					volume = volume + height[i] - height[k];
//				}
//				i = j;
//			} else {
//				i++;
//			}
//		} else {
//			if (secondhighindex - i == 1) {
//				i++;
//			} else {
//				for (int k = i + 1; k < secondhighindex; k++) {
//					volume = volume + height[secondhighindex] - height[k];
//				}
//				i = secondhighindex;
//			}
//		}
//		j = i + 1;
//		secondhighindex = j;
//	}
//	return volume;
//}
//}




////超时，遍历次数指数级重复遍历
////填坑刨地改进，每次算所有小于0的，减去做右标志位之外的空就行了
////每次可以从地下铲掉一层，除了靠两边为0的地方
////其余为零的地方均存水了
//class Solution42 {
//	public int trap(int[] height) {
//		if (height.length < 2)
//			return 0;// 如果没土堆就肯定没水
//		int ans = 0;
//		int left = 0;// 左标志
//		int right = height.length - 1;// 右标志
//
//		while (true) {
//
//			while (left < height.length) {// 找到最左边的土墙
//				if (height[left] < 1) {
//					left++;
//				} else {
//					break;
//				}
//			}
//			while (right >= 0) {// 找到最右边的土墙
//				if (height[right] < 1) {
//					right--;
//				} else {
//					break;
//				}
//			}
//			if (left >= right)
//				return ans;
//
//			for (int i = left; i <= right; i++) { // 刨掉一层土,记录所有空
//				if (height[i] == 0) {
//					ans++;
//				} else {
//					height[i]--;
//				}
//			}
//
//		}
//	}
//}

////填坑刨地
////每次可以从地下铲掉一层，除了靠两边为0的地方
////其余为零的地方均存水了
//class Solution42 {
//	public int trap(int[] height) {
//		if (height.length < 2)
//			return 0;// 如果没土堆就肯定没水
//		int ans = 0;
//		int left = 0;// 左标志
//		int right = height.length - 1;// 右标志
//		int flag = 0; // 记录是不是土都被铲掉了,如果等于总长就是铲完了
//		while (true) {
//			for (int i = 0; i < height.length; i++) { // 刨掉一层土
//				height[i]--;
//			}
//			while (left < height.length) {// 找到最左边的土墙
//				if (height[left] < 0) {
//					left++;
//				} else {
//					break;
//				}
//			}
//			while (right >= 0) {// 找到最右边的土墙
//				if (height[right] < 0) {
//					right--;
//				} else {
//					break;
//				}
//			}
//			if (left < right) {
//				for (int k = left; k < right; k++) {// 土墙里空的地方都是水
//					if (height[k] < 0) {
//						ans++;
//					}
//				}
//			} else {
//				return ans;
//			}
//		}
//	}
//}


//暴力搜索，每个位置存水高度等于
//此位置左右最高位置的较小值
//和当前位置高度差
//class Solution {
//	public int trap(int[] height) {
//		int ans = 0;
//		int size = height.length;
//		for (int i = 1; i < size - 1; i++) {
//			int max_left = 0, max_right = 0;
//			for (int j = i; j >= 0; j--) { // Search the left part for max bar size
//				max_left = Math.max(max_left, height[j]);
//			}
//			for (int j = i; j < size; j++) { // Search the right part for max bar size
//				max_right = Math.max(max_right, height[j]);
//			}
//			ans += Math.min(max_left, max_right) - height[i];
//		}
//		return ans;
//	}
//}