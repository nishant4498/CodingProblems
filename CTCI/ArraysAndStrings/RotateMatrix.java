package ArraysAndStrings;
/**
 * https://leetcode.com/problems/rotate-image/?tab=Description
 */
public class RotateMatrix {

	public static void main(String[] args) {		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		int[][] rotatedMatrix = rotate(matrix, 3);
		
		for(int i =0; i < 3; i++){
			for(int j =0; j < 3; j++){
				System.out.print(rotatedMatrix[i][j]);
			}
			System.out.println();
		}
	}
	/*
	 * Given a n X n matrix, rotate it by 90 degree.
	 */
			
	public static int[][] rotate(int[][] matrix , int n ){
		/*
		 * Layer denotes the current layer being rotated.
		 * There will be n/2 in a n X n dimensional matrix.
		 */
		for(int layer = 0; layer < n/2; layer++){
			/*
			 * first and last denote the first and last indices of the current
			 * layer being rotated.
			 */
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = 0; i < last; i++){
				// Offset tells the index of element in the current layer being copied.
				int offset = i - first;
				int top = matrix[first][i];// copy top into temp
				matrix[first][i] = matrix[last - offset][first];//top = left
				matrix[last - offset][first] = matrix[last][last - offset];//left = bottom
				matrix[last][last - offset] = matrix[i][last];//bottom = right;
				matrix[i][last] = top;//right = top
			}
			
		}
		
		return matrix;
	}

}
