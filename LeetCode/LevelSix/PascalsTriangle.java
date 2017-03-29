package LevelSix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *	
 * Basically there are two conditions in Pascal's triangle:
 * 
 * 1) First and last elements are 1.
 * 2) Each element is a row is the sum of the previous two elements in the previous row.
 * 	  row[i][j] = row[i-1][j-1] + row[i-1][j]
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows){
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < numRows; i++){
			List<Integer> row = new ArrayList<>();
			for(int j = 0; j < i + 1; j++){
				if(j == 0|| j == i){
					row.add(1);
				}else{
					/**
					 * We don't need to worry about i = 0, as for i = 0, [1] will be added to the result
					 * i = 1 [1, 1] will be added . The for i =2, this portion will be executed.
					 */
					List<Integer> prev = result.get(i-1);
					row.add(prev.get(j-1) + prev.get(j));
				}
			}
			result.add(row);
		}
		return result;
	}
}
