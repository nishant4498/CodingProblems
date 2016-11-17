package LevelOne;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class StockBuySell {

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		System.out.println(maxProfit(prices));
		System.out.println(maxProfitApproach2(prices));
	}	
	
	/*
	 * Here we just compare the price diff with the minimum number in the array
	 * found so far and not with every number.
	 */
	public static int maxProfitApproach2(int[] prices) {
        if(prices.length <= 1){
            return 0;   
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for(int i =1; i< prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
	
	/*
	 * Brute Force Approach - Check the diff of every element with every other
	 * element and get the max diff.
	 */
	public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i =0; i< prices.length - 1; i++){
            for(int j = i +1 ; j < prices.length; j++ ){
                if(prices[j] - prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
	
}
