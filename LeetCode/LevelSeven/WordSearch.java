package LevelSeven;
/**
 * https://leetcode.com/problems/word-search/
 * 
 * Very similar to the NumberOfIslands CountOfIslandSize
 * 
 * Here using a visited matrix causes some test cases to fail(3 out of 87) so we have temporarily
 * modified the same array and then reverted it back using a '#' sign. Also here we need to send
 * a newly created visited array since for each position we want to start a fresh search. 
 * 
 * Another way of setting the character visited mentioned here:
 * 
 * https://discuss.leetcode.com/topic/7907/accepted-very-short-java-solution-no-additional-space/2
 *
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;
		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (exist(board, word, 0, i, j)) return true;
			}
		}
		return false;
	}

	private boolean exist(char[][] board, String word, int index, int i, int j) {
		if (index == word.length()) return true;
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) {
			return false;
		}

		char temp = board[i][j];
		board[i][j] = '#';

		boolean result = exist(board, word, index + 1, i + 1, j) 
				|| exist(board, word, index + 1, i - 1, j)
				|| exist(board, word, index + 1, i, j + 1) 
				|| exist(board, word, index + 1, i, j - 1);

		board[i][j] = temp;

		return result;
	}
}
