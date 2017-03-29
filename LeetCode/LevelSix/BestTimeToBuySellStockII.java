package LevelSix;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 * https://leetcode.com/articles/best-time-buy-and-sell-stock-ii/
 * 
 * In this problem we are allowed to make as many transactions as possible.
 * Basically we need to find the peaks and valleys. The max profit will sumAll(peak[i] - valley[i]);
 */
public class BestTimeToBuySellStockII {
	/**
	 * Editorial method #2
	 */
	public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 0) return 0;
        
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        
        int i = 0;
        
        while(i < n-1){
            while(i < n-1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley = prices[i];
            while(i < n-1 && prices[i] <= prices[i+1]){
                i++;
            }
            peak = prices[i];
            maxProfit += peak-valley;
        }
        return maxProfit;
    }
	
	/**
	 * Editorial Method 3
	 * 
	 * Another approach is to add all the profits incremnetally rather than waiting to find the peaks
	 * and valleys.Its pretty much similar to the approach above with the only difference that we add each profit
	 * along the way.
	 */
	
	public int maxProfitMethod3(int[] prices) {
        int maxProfit = 0;
        if(prices.length <= 1) return 0;
        
        for(int i = 1;i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
