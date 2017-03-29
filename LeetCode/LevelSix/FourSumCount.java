package LevelSix;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/4sum-ii
 * 
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are 
 * such that A[i] + B[j] + C[k] + D[l] is zero.
 * 
 * Basically we put the sum of the first two arrays into a map and then check how many are there in the
 * other two arrays.
 * 
 * Time Complexity - O(n^2)
 * Space Complexity - O(n ^ 2)
 *
 */
public class FourSumCount {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int n = A.length;
        /**
         * Store the sum of elemnets combination of first two arrays into a map.
         */
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                int sum = A[i] + B[j];
                if(map.containsKey(sum)){
                    map.put(sum, map.get(sum) + 1);
                }else{
                    map.put(sum, 1);
                }
            }
        }
        
        int count = 0;
        /**
         * Whenever we find -1 * sum, we add that to the count.
         */
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                int sum = C[i] + D[j];
                if(map.containsKey(-1 * sum)){
                    count += map.get(-1 * sum);
                }
            }
        }
        
        return count;
    }
}
