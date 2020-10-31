package leetcodeanswer;

public class _122买卖股票的最佳时机II {

	public static void main(String[] args) {
		
		int[] prices= {7,1,5,3,6,4};
		Solution122 sl = new Solution122();
		System.out.println(sl.maxProfit(prices));
		

	}

}

class Solution122 {
    public int maxProfit(int[] prices) {
        
    	int maxprice=0;
    	for (int i = 1; i < prices.length; i++) {
			if (prices[i]>prices[i-1]) {
				maxprice+=(prices[i]-prices[i-1]);
			}
		}
    	
    	return maxprice;
    }
}