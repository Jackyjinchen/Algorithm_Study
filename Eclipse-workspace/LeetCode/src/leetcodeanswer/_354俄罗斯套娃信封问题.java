package leetcodeanswer;

import java.util.Arrays;
import java.util.Comparator;

public class _354俄罗斯套娃信封问题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		Solution354 sl = new Solution354();
		System.out.println(sl.maxEnvelopes(envelopes));
//		sl.maxEnvelopes(envelopes);
		
	}

}

class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length<2) {
			return envelopes.length;
		}
//    	System.out.println(Arrays.toString(envelopes));
//    	for (int[] is : envelopes) {
//			System.out.println(Arrays.toString(is));
//		}   	
    	Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0]!=o2[0]) {
					return o1[0]-o2[0];
				}
				return -(o1[1]-o2[1]);
			}
    		
		});

    	
//    	for (int[] is : envelopes) {
//			System.out.println(Arrays.toString(is));
//		}
//    	System.out.println(Arrays.toString(envelopes));
    	
    	
    	
    	return lengthOfLIS(envelopes);
    }
    
	public int lengthOfLIS(int[][] nums) {

		if(nums.length<2) return nums.length;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int ans=1;
		for (int i = 0; i < nums.length; i++) {
			int maxlencurr = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j][1] < nums[i][1]) {
					maxlencurr = Math.max(maxlencurr, dp[j] + 1);
				}
			}
			dp[i]=maxlencurr;
			ans=Math.max(dp[i], ans);
		}
		return ans;
	}

}