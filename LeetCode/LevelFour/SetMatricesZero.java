package LevelFour;
/*
 * https://leetcode.com/problems/set-matrix-zeroes/
 * This is the same problem as CTCI. We need to set the row and coulumn of an element as zero if the elemnet
 * is zero.
 * This needs to be done in place.
 * Here we keep the first row and first col and markers for which row and col need to be set to zero.
 * In addition we keep extra flags for the first row and column.
 */
public class SetMatricesZero {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRowZero = false;
		boolean firstColZero = false;

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		/*
		 * Better than doing nullify for each row and col.
		 */
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}

		if (firstColZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
