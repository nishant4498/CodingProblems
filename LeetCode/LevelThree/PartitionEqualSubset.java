package LevelThree;
/*
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * The idea here is to reduce the problem to subset sum.Here are the steps:
 * 1) Find the total sum of all the elements in the set
 * 2) If the sum is odd, we can definitely not partition into two sets.
 * 3) If the sum is even , then the problem can be reduced to finding subset sum with partitonSum = totalSum/2.
 *    i.e if there is a subset with half the sum, other subset will have euqal sum.
 */
public class PartitionEqualSubset {
	
	public static void main(String[] args){
		int[] nums = {1,5,11,5};
		System.out.println(canPartition(nums));
	}
	
	
	public static boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		int totalSum = 0;

		for (int i = 0; i < nums.length; i++) {
			totalSum += nums[i];
		}

		if (totalSum % 2 != 0)
			return false;

		int partitionSum = totalSum / 2;

		boolean[][] dp = new boolean[nums.length + 1][partitionSum + 1];

		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= partitionSum; j++) {
				if (j >= nums[i - 1]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[nums.length][partitionSum];
	}
}
