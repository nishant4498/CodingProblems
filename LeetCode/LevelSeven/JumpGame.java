package LevelSeven;
/**
 * https://leetcode.com/problems/jump-game/
 * 
 * We need to determine if we are able to reach the end(given an array where the positions determine
 * the number of steps we can jump.)
 * 
 * 1. Solution 1 is the greedy approach. At every poistion in the array , we compute the maxIndex that we can
 *	  reach till now. The loop terminates when either of these is satisfied:
 *	  - The curr position is greater than max we can reach(not reachable).
 *    - Max is greater than equal to length - We reached the end.
 * 
 * 2. Solution 2 is the basic DP solution, same as LIS, but 1 test case out of 73 timing out for this.
 */
public class JumpGame {
	
	public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        
        for(int i = 0; i < n; i++){
            if(i > maxIndex) return false;
            maxIndex = Math.max(nums[i] + i, maxIndex);
            if(maxIndex >= n-1) return true;    
        }
        return true;
    }
	
	
	public boolean canJumpDP(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        
        if(n == 0) return false;
        dp[0] = true;// If there is just one element, we are at the end.
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && nums[j] + j >= i){
                    dp[i] = true;
                    /**
                     * We immediately break out for that position, since we know there 
                     * is a way to reach index i.
                     */
                    break;
                }
            }
        }
        return dp[n -1];
    }
}
