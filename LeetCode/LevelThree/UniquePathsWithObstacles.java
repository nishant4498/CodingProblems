package LevelThree;
/*
 * https://leetcode.com/problems/unique-paths-ii/
 * The difference here is in initialization the first row and coulmn.
 * Also whenever we find a grid has obstacle we set number of paths for that point as zero.
 */
public class UniquePathsWithObstacles {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m == 0 || n == 0)
			return 0;
		int[][] paths = new int[m][n];

		/*
		 * Bsically in the normal unique paths we have 1 path from source to dest if we have just one row.
		 * Here we have zero paths if we get an obstacle.
		 * Thus whenever we find an obstacle we set all the next grids to zero.
		 */
		boolean found = false;
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1 || found) {
				paths[i][0] = 0;
				found = true;
			} else {
				paths[i][0] = 1;
			}

		}
		/*
		 * Same as above.
		 */
		found = false;
		for (int j = 0; j < n; j++) {
			paths[0][j] = 0;
			if (obstacleGrid[0][j] == 1 || found) {
				paths[0][j] = 0;
				found = true;
			} else {
				paths[0][j] = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					paths[i][j] = 0; // For an obstacle , the num paths is zero.
					continue;
				} else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}

			}
		}

		return paths[m - 1][n - 1];
	}
}
