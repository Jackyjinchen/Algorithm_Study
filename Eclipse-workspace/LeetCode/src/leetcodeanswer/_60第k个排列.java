package leetcodeanswer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _60第k个排列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8, k = 4000;
		Solution60 sl = new Solution60();
		System.out.println(sl.getPermutation(n, k));

	}
}

class Solution60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        //阶乘数组
    	int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        //阶乘值为当前值乘前一个阶乘值

        //list存储“数字”，因此remove后依旧有序，无需排序。
        //这保证了我们只要知道需要获取值的偏移量就可以得到对应的值。
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n;i++){
            nums.add(i);
        }
        int index;
        //将题目的人类习惯奇数改为list内部下标计数。
        k--;
        //最差情况下从第一位一直运算到第n-1位，最后一位便是剩下的。
        for(int j = 1;j < n;j++){
            int factorial = factorials[n-j];
            //获取该位“数字”在list内的下标
            index = k / factorial;
            k = k % factorial;
            //将这一位“数字”加进来后从list内部删除该“数字”
            sb.append(nums.get(index));
            nums.remove(index);
            //如果此时不再有相对偏移量，退出循环。
            if(k == 0){
                break;
            }
        }
        //如果最差情况，此时将最后一位加进来，
        //如果中途因为刚好匹配、没有偏移量而退出则按序将剩余“数字”加进来。
        while (nums.size()>0){
            sb.append(nums.get(0));
            nums.remove(0);
        }
        return sb.toString();
    }
}





//class Solution60 {
//
//	List<Integer> str = new LinkedList<Integer>();
//	int k;
//	int n;
//	boolean flag=false;
//	StringBuilder ans = new StringBuilder();
//	int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
//	public String getPermutation(int n, int k) {
//		
//		this.k = k;
//		this.n = n;
//		for (int i = 1; i <= n; i++) {
//			str.add(i);
//		}
//		backtrack();
//
//		return ans.toString();
//	}
//
//	public void backtrack() {
//		if (n==0) {
//			k--;
//			if (k==0) {
//				flag=true;
////				System.out.println(ans+"ans");
//			}
//			return;
//		}
//		for (int i = 1; i <= n; i++) {
//			int temp=str.get(i-1);
////			ans.append(temp);
//			str.remove(i-1);
//			n--;
//			backtrack();
//			if(flag) {
//				ans.insert(0, temp);			
//				return;
//			}
//			n++;
////			ans.deleteCharAt(ans.length() - 1);
//			str.add(i - 1, temp);
//
//		}
//
//	}
//
//}


//class Solution60 {
//
//    public String getPermutation(int n, int k) {
//        int[] nums = new int[n];
//        boolean[] used = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = i + 1;
//            used[i] = false;
//        }
//        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
//        List<String> pre = new ArrayList<>();
//        return dfs(nums, used, n, k, 0, pre, factorial);
//    }
//
//    private String dfs(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre, int[] factorial) {
//        if (depth == n) {
//            StringBuilder sb = new StringBuilder();
//            for (String c : pre) {
//                sb.append(c);
//            }
//            return sb.toString();
//        }
//        int ps = factorial[n - 1 - depth];
//        for (int i = 0; i < n; i++) {
//            if (used[i]) {
//                continue;
//            }
//            if (ps < k) {
//                k -= ps;
//                continue;
//            }
//            pre.add(nums[i] + "");
//            used[i] = true;
//            return dfs(nums, used, n, k, depth + 1, pre, factorial);
//        }
//        // 如果参数正确的话，代码不会走到这里
//        throw new RuntimeException("参数错误");
//    }
//}
//
//
