package leetcodeanswer;

public class _42����ˮ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Solution42 sl = new Solution42();
		System.out.println(sl.trap(height));
	}

}



//��̬�滮���ӱ���������ȡ��˼·
//�ֱ��ҵ�ÿ��λ�������Ҳ����ֵ�ĸ߶ȼ���
class Solution42 {
public int trap(int[] height) {
	if (height.length < 2) return 0;
	int ans=0;
	int size=height.length;
	int[] left = new int[size]; //�����ߵ�����
	int[] right = new int[size];//�ұ���ߵ�����
	
	left[0]=height[0];
	for (int i = 1; i < size; i++) {
		left[i]=Math.max(height[i], left[i-1]);
	}
	right[size-1]=height[size-1];
	for (int i = size-2; i >=0; i--) {
		right[i]=Math.max(height[i], right[i+1]);
	}
	
	for (int i = 0; i <size; i++) {
		ans=ans+Math.min(left[i], right[i])-height[i]; //ˮ�ĸ߶Ⱦ���������������еĽ�Сֵ���͵�ǰλ�õĸ߶Ȳ�
	}	
	return ans;
	}
}


////1��������ָ��iָ���һ������Ԫ��
////2������j��ʼ���һ�����ͬʱ��¼i����һλ��ʼ�Ĵθ�λλ�ã�
////	����ҵ��߶ȸ��ڻ�������ģ�
////		j-i=1����ʱ˵��û�н���ˮ��i����һλ
////		j-i>1,�ӵ�����ˮ����������һ���ж���ˮ��Ȼ��iָ��j���ڵ�λ��
////	���û�ҵ���iλ�ø߶ȸ߻���ȵ�
////		�жϴθ�λ
////			�θ�λ����i��˵��û��ˮ��i++
////			�θ�λû�н���i��˵����ˮ�ˣ�����ˮ������ָ��i=�θ�λλ�ã�
//class Solution42 {
//public int trap(int[] height) {
//
//	if (height.length < 2) {
//		return 0;
//	}
//	int i = 0, j = 0;
//	int volume = 0;
//	int secondhighindex = 0;
//	// �����ҵ���һ���߶Ȳ�Ϊ���
//	while (height[i] < 1 && i < height.length) {
//		i++;
//	}
//	j = i + 1;
//	secondhighindex = j;
//	// ��ʼ
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




////��ʱ����������ָ�����ظ�����
////����ٵظĽ���ÿ��������С��0�ģ���ȥ���ұ�־λ֮��Ŀվ�����
////ÿ�ο��Դӵ��²���һ�㣬���˿�����Ϊ0�ĵط�
////����Ϊ��ĵط�����ˮ��
//class Solution42 {
//	public int trap(int[] height) {
//		if (height.length < 2)
//			return 0;// ���û���ѾͿ϶�ûˮ
//		int ans = 0;
//		int left = 0;// ���־
//		int right = height.length - 1;// �ұ�־
//
//		while (true) {
//
//			while (left < height.length) {// �ҵ�����ߵ���ǽ
//				if (height[left] < 1) {
//					left++;
//				} else {
//					break;
//				}
//			}
//			while (right >= 0) {// �ҵ����ұߵ���ǽ
//				if (height[right] < 1) {
//					right--;
//				} else {
//					break;
//				}
//			}
//			if (left >= right)
//				return ans;
//
//			for (int i = left; i <= right; i++) { // �ٵ�һ����,��¼���п�
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

////����ٵ�
////ÿ�ο��Դӵ��²���һ�㣬���˿�����Ϊ0�ĵط�
////����Ϊ��ĵط�����ˮ��
//class Solution42 {
//	public int trap(int[] height) {
//		if (height.length < 2)
//			return 0;// ���û���ѾͿ϶�ûˮ
//		int ans = 0;
//		int left = 0;// ���־
//		int right = height.length - 1;// �ұ�־
//		int flag = 0; // ��¼�ǲ���������������,��������ܳ����ǲ�����
//		while (true) {
//			for (int i = 0; i < height.length; i++) { // �ٵ�һ����
//				height[i]--;
//			}
//			while (left < height.length) {// �ҵ�����ߵ���ǽ
//				if (height[left] < 0) {
//					left++;
//				} else {
//					break;
//				}
//			}
//			while (right >= 0) {// �ҵ����ұߵ���ǽ
//				if (height[right] < 0) {
//					right--;
//				} else {
//					break;
//				}
//			}
//			if (left < right) {
//				for (int k = left; k < right; k++) {// ��ǽ��յĵط�����ˮ
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


//����������ÿ��λ�ô�ˮ�߶ȵ���
//��λ���������λ�õĽ�Сֵ
//�͵�ǰλ�ø߶Ȳ�
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