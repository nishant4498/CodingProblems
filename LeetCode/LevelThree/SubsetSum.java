package LevelThree;

/**
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
 * https://www.youtube.com/watch?v=s6FhG--P7z0 
 * The first row in the video is not initialized..It should be all false.
 * 
 * Same as CoinChange
 */

public class SubsetSum {
	
	public static void main(String[] args) {
		int[] input = {2,3,7,8,10};
		System.out.println(isSubsetSumPresent(input, 11));
		System.out.println(isSubsetSumPresent(input, 14));
	}
	
	public static boolean isSubsetSumPresent(int[] input , int sum){
		boolean[][] dp = new boolean[input.length + 1][sum + 1]; 
		
		
		/*
		 * When the sum required is zero it can be fulfilled with and empty set.
		 */
		
		for(int i =0; i<= input.length;i++){
			dp[i][0] = true;
		}
		
		/*
		 * When the length of given set is zero it should be false. We don't specifically initialize here
		 * as by default the value of boolean array is false in java.
		 */
		
		for(int i =1; i <= input.length; i++){
			for(int w =1; w <= sum; w++){
				if(input[i-1] <= w){
					dp[i][w] = dp[i-1][w] || dp[i-1][w - input[i-1]];
				}else{
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		
		return dp[input.length][sum];
	}
}
