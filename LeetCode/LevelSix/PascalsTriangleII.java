package LevelSix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii
 *	
 * Given an index k, return the kth row of the Pascal's triangle.(The index is 0 based)
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        
        /**
         * Since index is 0 based , we need to use i <= rowIndex condition.
         */
        for(int i = 0; i <= rowIndex; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(prev.get(j-1) + prev.get(j));
                }
            }
            prev = row;
        }
        return prev;
    }
}
