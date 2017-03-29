package Level8;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * The idea is to mark the indices of elements that we see as negative in one iteration.
 * In the second iteration we can the find the missing number simply by going over the array
 * again and see which indices have positive elements.
 *
 */
public class FindAllDisappearedElements {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) result.add(i + 1);
        }
        
        return result;
    }
}
