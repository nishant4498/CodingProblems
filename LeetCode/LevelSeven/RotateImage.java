package LevelSeven;
/**
 * https://leetcode.com/problems/rotate-image/
 * 
 * Here we perform the rotation into two steps:
 * 
 * 1) First we compute the transpose of the matrix.
 * 2) We swap the left most with right most/ basically flipping the matrix horizontally.
 *
 */
public class RotateImage {
	public void rotate(int[][] matrix){
		int n = matrix.length;
		
		/**
		 * Transpose
		 * 
		 * important condition j < i.
		 */
		
		for(int i =0; i < n ; i++){
			for(int j = 0; j < i; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		/**
		 * Flip horizontally
		 */
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n/2; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j -1];
				matrix[n-j-1][i] = temp;
			}
		}
	}
}
