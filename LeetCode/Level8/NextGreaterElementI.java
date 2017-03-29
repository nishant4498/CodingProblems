package Level8;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * https://leetcode.com/articles/greater-element-i/
 * 
 * The idea is to put the elements of the nums1 into a map with their indices to search quickly.
 * Thus we find the index of the lement in the array and then start looking for the greater element
 * after that index.
 * 
 * There is a O(m + n) stack solution as well.Check the article
 *
 */
public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] result = new int[findNums.length];
        
        for(int i = 0; i < nums.length;i++){
            map.put(nums[i], i);
        }
        int j;
        for(int i = 0; i < findNums.length; i++){
            for(j = map.get(findNums[i]); j < nums.length; j++){
                if(nums[j] > findNums[i]){
                    result[i] = nums[j];
                    break;
                }
            }
            
            if(j == nums.length) {
                result[i] = -1;
            }
        }
        return result;
    }
}
