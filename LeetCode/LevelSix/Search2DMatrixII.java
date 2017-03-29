package LevelSix;
/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *  - Integers in each row are sorted in ascending from left to right
 *  - Integers in each column are sorted in ascending from top to bottom.
 *  
 *  Basically we start from the first row last column.
 *  
 *  If element is greater than target , it means that we need to move to the previous column.
 *  If elemnt is less than the target we need to move to the next row.
 *  
 *  Time Complexity - Bounded by O(m + n) since everytime we reduce one row or one column.
 */
public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0;
        int col = n -1;
        
        while(row < m && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
