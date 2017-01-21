package LevelThree;

/*
 * https://leetcode.com/problems/house-robber-ii/
 * Basically this is the same as house robber problem with the only change that first and last 
 * houses are connected.
 * Thus we compute the values for (0, len-2) and (1, len-1) since first and last houses cannot be 
 * together and take the max of these.
 * HouseRobberDP
 */
public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int length = nums.length;
		if (length == 1)
			return nums[0];

		int max1 = rob(nums, 0, length - 2);
		int max2 = rob(nums, 1, length - 1);

		return Math.max(max1, max2);
	}

	public int rob(int[] nums, int i, int j) {
		/*
		 * This handles the case when therevare just two elements.
		 */
		if (i == j)
			return nums[i];

		int[] dp = new int[nums.length];

		dp[i] = nums[i];
		dp[i + 1] = Math.max(nums[i], nums[i + 1]);

		for (int k =  i + 2; k <= j; k++) {
			dp[k] = Math.max((nums[k] + dp[k - 2]), dp[k - 1]);
		}

		return dp[j];
	}
}
