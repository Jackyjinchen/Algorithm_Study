package leetcodeanswer;


public class _53最大子序和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		Solution53 sl = new Solution53();
		System.out.println(sl.maxSubArray(nums));
		
		
		
	}

}

//Kadene算法
//def max_subarray(A):
//    max_ending_here = max_so_far = A[0]
//    for x in A[1:]:
//        max_ending_here = max(x, max_ending_here + x)
//        max_so_far = max(max_so_far, max_ending_here)
//    return max_so_far
class Solution53 {
    public int maxSubArray(int[] nums) {
    	int ans = nums[0];
        int sum = 0;
        for(int num : nums) {
            // if(sum > 0) { 可以写成这样
            if(sum + num > num ){
                sum = sum + num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        };
        return ans;

    }
    
}
    



//class Solution53 {
//    public int maxSubArray(int[] nums) {
//        
//    	return merge(0, nums.length-1, nums);
//    }
//    
//    public int merge(int left,int right,int[] nums) {
//		if (left==right) {
//			return nums[left];
//		}
//		int mid=(left+right)/2;
//		
//		int leftmax = merge(left, mid, nums);
//		int rightmax= merge(mid+1, right, nums);
//		int sum=0,lmax=nums[mid],rmax=nums[mid+1];
//		for (int i = mid; i >=left ; i--) {
//			sum+=nums[i];
//			lmax=Math.max(lmax, sum);
//		}
//		sum=0;
//		for (int i = mid+1; i <=right ; i++) {
//			sum+=nums[i];
//			rmax=Math.max(rmax, sum);
//		}
//		
//		return Math.max(leftmax, Math.max(rightmax, rmax+lmax));
//		
//
//	}
//     
//}