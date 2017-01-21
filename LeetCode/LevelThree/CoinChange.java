package LevelThree;

/* https://leetcode.com/problems/coin-change/
 * https://www.youtube.com/watch?v=NJuKJ8sasGk
 * http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 */
public class CoinChange {
	public static void main(String[] args) {
		int[] coins = { 7, 2, 3, 6 };
		int amount = 13;
		System.out.println(minCoins(coins, amount));
	}

	public static int minCoins(int[] coins, int amount) {
		if (coins.length == 0 || amount == 0)
			return 0;

		int[] dp = new int[amount + 1];
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		/*
		 * We have two conditions before we compare 1) j >= coins[i] - This
		 * means that the value of the coin should be less than or equal to the
		 * amount for which we are comparing. 2) dp[j - coins[j - coins[i]]]
		 * should not still be infinity(or max value). This means that we cannot
		 * form the amount using this coin as the prevoius value was not formed.
		 */

		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
				}
			}
			/*
			 * To get the max no of ways the amount can be formed we can keep a
			 * counter here and increment it whenever the value of dp[amount] is
			 * not Integer.MAX_VALUE and is updated from the last time.
			 */

		}
		return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
	}
}
