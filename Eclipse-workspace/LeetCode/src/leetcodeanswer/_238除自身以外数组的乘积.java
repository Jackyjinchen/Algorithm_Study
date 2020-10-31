package leetcodeanswer;

import java.util.Arrays;

public class _238��������������ĳ˻� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,4};
		Solution238 sl = new Solution238();
		
		System.out.println(Arrays.toString(sl.productExceptSelf(nums)));
		
	}

}


//�ֱ��������ۼƳ˻������ݣ����Ҹ�����һ�飬�Ϳɵõ������䱾��֮�����ֵĳ˻�
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] muilt=new int[nums.length];
        int left=1,right=1;
        
        for (int i = 0; i < nums.length; i++) {
			muilt[i]=left;
			left*=nums[i];
		}
//        System.out.println(Arrays.toString(muilt));
        for (int i = nums.length-1; i >=0; i--) {
			muilt[i]*=right;
			right*=nums[i];
		}

        return muilt;
     
    }
}