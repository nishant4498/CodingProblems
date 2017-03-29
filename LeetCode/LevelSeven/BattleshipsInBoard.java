package LevelSeven;
/**
 * https://leetcode.com/problems/battleships-in-a-board/
 * 
 * 1) A battleship is repesented by 1..N(i.e 1 to N) 'X's. There should be atleast one 'X' and at max will be
 *    equal to the length of the row or column.
 * 2) They are placed either horizontally or vertically and bw each battleship there should be a '.'
 */
public class BattleshipsInBoard {
	/**
	 * Basically the idea is to count consecutive horizontal or vertical 'X's as 1.
	 * We do the following:
	 * 1) Ignore if we get a '.'
	 * 2) Ignore if the element on the top is a 'X' , since this will count as single battleship.
	 * 3) Ignore if the element on the left is 'X' for the same reason.
	 * 4) Increase count. 	 
	 */
	public int countBattleships(char[][] board){
		int count = 0;
		int m = board.length;
		int n = board[0].length;
		
		for(int i = 0; i < m; i++){
			for(int j =0; j < n ; j++){
				if(board[i][j] == '.') continue;
				if(i > 0 && board[i-1][j] == 'X') continue;
				if(j > 0 && board[i][j-1] == 'X') continue;
				count++;
			}
		}
		return count;
	}
}
