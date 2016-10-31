package LevelThree;
/*
 * https://leetcode.com/problems/unique-paths/
 * Find the number of unique paths the robot can move from one corner to another
 * given it can only move right or down.
 */
public class UniquePaths {
	public int uniquePaths(int m , int n){
		if(m ==0 || n == 0) return 0;
		int[][] paths = new int[m][n];
		
		/*
		 * If there is only one column, then there is only path where we can go down to reach target.
		 */
		for(int i =0; i < m; i++){
			paths[i][0] = 1;
		}
		
		for(int j =0; j< n ; j++){
			paths[0][j] = 1;
		}
		
		for(int i = 1; i< m; i++){
			for(int j =1; j < n; j++){
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}
		
		return paths[m-1][n-1];
	}
}
