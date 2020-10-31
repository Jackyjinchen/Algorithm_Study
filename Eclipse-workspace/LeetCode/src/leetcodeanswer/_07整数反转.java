package leetcodeanswer;



public class _07整数反转 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution07 sl = new Solution07();
		int ans=sl.reverse(1234);
		System.out.println(ans);
		
		
	}

}

class Solution07 {
    public int reverse(int x) {
        int ans=0;
        while (x!=0) {
        	int pop=x%10;
        	if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) 
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) 
                return 0;

			ans=10*ans+pop;
			x/=10;			
		}
    
    	return ans;
    	
    }
}