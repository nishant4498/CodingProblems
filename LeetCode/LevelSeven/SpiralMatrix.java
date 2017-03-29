package LevelSeven;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * 1) Basically here we initialize the 4 markers for rows and cols-
 *    rowStart, rowEnd, colStart, colEnd.
 * 2) Then we traverse in a while loop in the spiral order i.e
 * 	  TOP --> RIGHT --> BOTTOM --> LEFT
 * 3) After each traversal we keep updating the markers.
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix){
		List<Integer> result = new ArrayList<>();
		if(matrix.length == 0) return result;
		int rowStart = 0;
		int rowEnd = matrix.length -1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;
		
		while(rowStart <= rowEnd && colStart <= colEnd){
			/**
			 *  Traverse TOP
			 */
			
			for(int i = colStart ; i <= colEnd; i++){
				result.add(matrix[rowStart][i]);
			}			
			rowStart++;
			
			/**
			 *  Traverse RIGHT
			 */
			for(int i = rowStart; i<= rowEnd; i++){
				result.add(matrix[i][colEnd]);
			}			
			colEnd--;
			
			/**
			 *  Traverse BOTTOM
			 */
			if(rowStart <= rowEnd){ // Important to check these conditions.
				for(int i = colEnd; i >= colStart; i--){
					result.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;
			
			/**
			 *  Traverse LEFT
			 */
			if(colStart <= colEnd){
				for(int i = rowEnd; i >= rowStart; i--){
					result.add(matrix[i][colStart]);
				}
			}
			colStart++;	
			
		}		
		return result;
	}
}
