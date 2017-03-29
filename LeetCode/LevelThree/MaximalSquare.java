package LevelThree;
/**
 * https://leetcode.com/problems/maximal-square/
 * https://leetcode.com/articles/maximal-square/
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * 
 * Basically the idea is to keep another matrix which would track the size of max size 
 * squares that can be formed till now.
 * 
 * dp[i][j] = min(dp[i-1][j], dp[i][j-1],dp[i-1][j-1])
 * 
 * We search for the max size in the dp matrix and return the area.
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int maxSize = 0;
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
					min = Math.min(min, dp[i - 1][j - 1]);
					dp[i][j] = min + 1;
					maxSize = Math.max(maxSize, dp[i][j]);
				}
			}
		}

		return maxSize * maxSize;
	}
}
