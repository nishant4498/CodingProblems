package LevelSix;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * https://discuss.leetcode.com/topic/9748/shared-my-concise-java-code/6
 * 
 * Basically as we know, for a sudoku to be valid, each row, column and cube should contain unique digits
 * from 1-9.
 * 
 * 1) Here we traverse through the matrix using i and j.
 * 2) 9 values of i's represent 9, rows,cols and cubes(starting from top left to right then bottom.)
 * 3) j values are used to traverse the rows and cols for each i.
 * 4) The main trick is how do we convert i & j so that we can cover each row, column and cube for each value of i
 * 
 * Rows & Columns: This part is simple
 * 
 * i = 0 , j = 0...8  if we see board[i][j]  will give the first row and board[j][i] will give the first column.
 * 
 * Similary i =1 and j = 0..8, will give 2nd row and 2 nd column and so on.
 * 
 * CUBE: the trick here is how to get the cubes.Basically 
 * 
 * i = 0 points to cube 1 on the top left.
 * i = 1 points to the cube 2 in the top middle and so on...
 * 
 * The link above has a very good description of how to convert i and j into row and col indices.
 * 
 *
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<>();
			Set<Character> col = new HashSet<>();
			Set<Character> cube = new HashSet<>();

			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) return false;

				if (board[j][i] != '.' && !col.add(board[j][i])) return false;

				/**
				 * It is important to note that we get both the starting rowIndex and colIndex
				 * from the cube using i.
				 */
				int rowIndex = 3 * (i / 3);
				int colIndex = 3 * (i % 3);

				if (board[rowIndex + j / 3][colIndex + j % 3] != '.'
						&& !cube.add(board[rowIndex + j / 3][colIndex + j % 3]))
					return false;
			}
		}
		return true;
	}
}
