package LevelThree;
/*
 * CTCI - 16.17
 * https://leetcode.com/problems/maximum-subarray/
 * We should ignore the sum of the previous n-1 elements if nth element is greater
 * than the sum till nth element.
 * Basically whenever currSum becomes negative, we have to reinitialize the currSum.
 */
public class MaxSumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int maxSum = nums[0];
        int maxCurrSum = nums[0];
        
        for(int i = 1; i < nums.length; i++){
        	maxCurrSum = Math.max(nums[i], nums[i] + maxCurrSum);
        	maxSum = Math.max(maxSum,maxCurrSum);
        }
        
        return maxSum;
    }
}
