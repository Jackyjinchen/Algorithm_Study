package leetcodeanswer;

import java.util.Arrays;

public class _238除自身以外数组的乘积 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,4};
		Solution238 sl = new Solution238();
		
		System.out.println(Arrays.toString(sl.productExceptSelf(nums)));
		
	}

}


//分别做左右累计乘积的数据，左右各遍历一遍，就可得到除了其本身之外数字的乘积
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