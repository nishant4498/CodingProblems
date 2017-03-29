package LevelSix;
/**
 * https://leetcode.com/problems/climbing-stairs/
 * 
 * Basically this is a dp question with equation
 * dp[i] = dp[i-1] + dp[i-2]
 * 
 * Total length dp[n+1]
 * Base case:
 * dp[0] = 0
 * dp[1] = 1
 * dp[2] = 2
 * 
 * 
 * Here we can just store the solution in two variables since we need the previous two results only.
 * 
 * from 3 to n
 * 		apply recurrence
 *
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		/**
		 * Base cases combined together.
		 */
		if (n <= 2) return n;
		
		/**
		 * If we are at n = 2, then there are two ways to reach there...Either take one step 
		 * or take two steps.
		 * 
		 */
		int oneStepBack = 2;
		int twoStepsBack = 1;
		int allPaths = 0;

		for (int i = 3; i <= n; i++) {
			allPaths = oneStepBack + twoStepsBack;
			twoStepsBack = oneStepBack;
			oneStepBack = allPaths;
		}

		return allPaths;
	}
}
