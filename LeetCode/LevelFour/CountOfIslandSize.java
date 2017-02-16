package LevelFour;

import java.util.ArrayList;
import java.util.List;

/**
 * CTCI 16.19
 * This is very similar to the NumberOfIslands.Water is denoted by 0, Land is denoted by non-zero
 * positive integer.
 * The main difference is:
 * Here we need to count the size of each pond i.e how many 0's are there continuosly 
 * (horizontally, vertically and diagonally).
 * 
 * In case of NumberOfIslands, it just counts how many land pieces(continuos ones) are there.
 */
public class CountOfIslandSize {
	public List<Integer> getIslandSize(int[][] matrix){
		List<Integer> result = new ArrayList<>();
		if(matrix.length == 0 || matrix[0].length == 0) return result;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		boolean[][] visited = new boolean[m][n];
		
		for(int i =0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0 && !visited[i][j]){
					int count = countSize(matrix, i, j, visited);
					result.add(count);
				}
			}
		}
		return result;
	}
	
	private int countSize(int[][] matrix, int row, int col, boolean[][] visited){
		int m = matrix.length;
		int n = matrix[0].length;
		
		if (row < 0 || row >= m || col < 0 || col >= n || matrix[row][col] != 0 || visited[row][col]) {
			return 0;
		}
		/**
		 * It's important to initialize size here as 1. Usually we think of initializing as 0.
		 * But since we are already at this point, it means that the size is minimum one. 
		 */
		int size = 1;
		visited[row][col] = true;
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				size += countSize(matrix, row + i, col + j, visited);
			}
		}	
		
		return size;
	}
	
	public static void main(String[] args) {
		CountOfIslandSize test = new CountOfIslandSize();
		int[][] matrix = {{0,2,1,0},
				          {0,1,0,1},
				          {1,1,0,1},
				          {0,1,0,1}};
		
		List<Integer> result = test.getIslandSize(matrix);
		for(int val : result){
			System.out.println(val);
		}
	}
}
