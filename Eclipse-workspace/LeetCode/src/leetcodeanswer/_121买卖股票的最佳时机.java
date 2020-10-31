package leetcodeanswer;

public class _121买卖股票的最佳时机 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}

class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices.length<2)
            return 0;
        int mini=Integer.MAX_VALUE;
        int maxprofit=0;
        
        for(int i=0;i<prices.length;i++){
        if(prices[i]<mini){
            
            mini=prices[i];
            
        }
            maxprofit=Math.max(prices[i]-mini,maxprofit);
            }
        return maxprofit;
    }
}