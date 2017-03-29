package LevelSeven;
/**
 * Leetcode locked questions.
 * CTCI Moderate 16.4
 * 
 * Basically here we have to implement the move function and return the winning condition.
 * 
 * For winning either one row, one column or any of the diagonals should be filled by a player.
 * 
 * Hence we keep here two arrays for two rows and two variables for both diagonals.
 * For player 1 we increment the count and for player 2 we decremnet the count.
 * Whenever the abs(count) == size(array) that player wins. 
 */
public class TicTacToe {
    int[] rows;
    int[] cols;
    int dia1;
    int dia2;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
       rows = new int[n];
       cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = (player == 1) ? 1 : -1;
        
        rows[row] += toAdd;
        cols[col] += toAdd;
        
        if(row == col){
            dia1 += toAdd;
        }
        
        int size = rows.length;
        /**
         * For the anti diagonal.
         */
        if((row + col + 1) == size){
            dia2 += toAdd;
        }
        
        if(Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(dia1) == size || Math.abs(dia2) == size) return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
