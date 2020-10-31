package leetcodeanswer;

import java.util.Arrays;


public class _16��ӽ�������֮�� {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		Solution16 sl = new Solution16();
		int ans = sl.threeSumClosest(nums, target);
		System.out.println(ans);

	}

}

class Solution16 {
	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
//    	System.out.println(Arrays.toString(nums));
    	for (int i = 0; i < nums.length; i++) {
			int start=i+1,end=nums.length-1;
			while (start<end) {
				int sum=nums[start]+nums[end]+nums[i];
				if(Math.abs(target-sum)<Math.abs(target-ans))
					ans=sum;
				if(sum>target)
					end--;
				else if (sum<target) 
					start++;
				else
					return ans;
			}
			
			
		}
    	
    	return ans;
    }
}