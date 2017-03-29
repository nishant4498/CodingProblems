package LevelSix;
/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * Given an array of n positive integers and a positive integer s, find the minimal length of a 
 * contiguous subarray of which the sum ≥ s. 
 * 
 * This is a standard two pointer problem. 
 * 		- We start with left and right pointers at index 0.
 *      - We keep moving the right pointer until the sum is >= s
 *      - Then we keep moving the left pointer and decrease the number from sum till sum >= s.
 *      - At every update we check the minimum size of the subarray which gives sum more than s.
 *  
 *
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        
        int l = 0, r = 0, min = Integer.MAX_VALUE, sum = 0;
        
        while(r < nums.length){
            sum += nums[r++];
            
            while(sum >= s){
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE? 0 : min;
    } 
}
