package LevelSix;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * a) Integers in each row are sorted from left to right. b) The first integer
 * of each row is greater than the last integer of the previous row.
 * 
 * Basically the idea here is to first find the row using binary search, then find the exact target 
 * in that using another binary search.
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;

		int m = matrix.length;
		int n = matrix[0].length;

		if (target < matrix[0][0] || target > matrix[m - 1][n - 1])
			return false;

		int targetRow = findRow(matrix, target);

		if (targetRow == -1)
			return false;

		return search(matrix[targetRow], target);
	}

	public int findRow(int[][] matrix, int target) {
		int low = 0;
		int high = matrix.length - 1;

		int n = matrix[0].length;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
				return mid;
			} else if (target < matrix[mid][0]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}

	public boolean search(int[] row, int target) {
		int low = 0;
		int high = row.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (row[mid] == target)
				return true;

			if (target > row[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
