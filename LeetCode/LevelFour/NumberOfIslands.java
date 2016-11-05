package LevelFour;
/*
 * https://leetcode.com/problems/number-of-islands/
 * 
 * http://www.geeksforgeeks.org/find-number-of-islands/
 * 
 * Basically we take each position with 1 and change its neigbors with mark 'X'.
 * Thus each time we get one group.
 * TODO See how to use union find data structure in this problem. Also how to do this 
 * without modifying the actual array.
 * Basically without modifying we can take a boolean array of size m X n and instead of updating 1 -> X
 * we can update the boolean array to true whenever we visiti ones.
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;
		
		boolean[][] visited = new boolean[m][n];

		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' & !visited[i][j]) {
					count++;
					clearRestOfLand(grid, i, j, visited);
				}
			}
		}

		return count;
	}

	public void clearRestOfLand(char[][] grid, int i, int j, boolean[][] visited) {
		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1' || visited[i][j])
			return;

		visited[i][j] = true;

		clearRestOfLand(grid, i - 1, j, visited);
		clearRestOfLand(grid, i + 1, j, visited);
		clearRestOfLand(grid, i, j - 1, visited);
		clearRestOfLand(grid, i, j + 1, visited);
	}
}
