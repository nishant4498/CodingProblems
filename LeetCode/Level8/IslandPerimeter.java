package Level8;
/**
 * https://leetcode.com/problems/island-perimeter
 * 
 * The basic idea here is to count the number of 1's(i.e) land and the count of its neighbours.
 * 
 * Each land part will contribute 4 edges while for each neighbour 2 edges will be reduced as shown below
 * https://discuss.leetcode.com/topic/68786/clear-and-easy-java-solution/4
 * 
 *  +--+     +--+                   +--+--+
 *  |  |  +  |  |          ->       |     |
 *  +--+     +--+                   +--+--+
 *
 */
public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		int islands = 0;
		int neighbours = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					islands++;
					if (i < grid.length - 1 && grid[i + 1][j] == 1)
						neighbours++;
					if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
						neighbours++;
				}
			}
		}

		return 4 * islands - 2 * neighbours;
	}
}
