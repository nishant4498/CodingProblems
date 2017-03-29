package LevelSix;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * http://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 * 
 * Similar to LargestRectangleInHistogram
 * 
 * The idea is to find the maximum area for each row in the matrix using the histogram approach.
 *
 */
public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int result = 0;
		int[] row = new int[matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					row[j] += 1;
				} else {
					row[j] = 0;
				}				
			}
			result = Math.max(result, largestRowArea(row));
		}

		return result;
	}

	public static int largestRowArea(int[] row) {
		Stack<Integer> s = new Stack<>();

		int maxArea = 0;
		int area = 0;
		int i = 0;

		while (i < row.length) {
			if (s.isEmpty() || row[s.peek()] <= row[i]) {
				s.push(i++);
			} else {
				int top = s.pop();

				area = row[top] * (s.isEmpty() ? i : (i - s.peek() - 1));

				maxArea = Math.max(area, maxArea);
			}
		}

		while (!s.isEmpty()) {
			int top = s.pop();

			area = row[top] * (s.isEmpty() ? i : (i - s.peek() - 1));

			maxArea = Math.max(area, maxArea);
		}

		return maxArea;
	}
	
	public static void main(String[] args) {
		char[][] input = {{'0','1'},{'1','0'}};
		
		System.out.println(maximalRectangle(input));
	}
}
