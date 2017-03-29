package LevelSix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 * 
 * Similar to 3 sum
 * 
 * Time Complexity = O(n ^ 3)
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4) return result;
        Arrays.sort(nums);
        
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			
			for(int j = i + 1; j < nums.length - 2; j++){
			    if(j > i + 1 && nums[j] == nums[j-1]) continue;
			    
			    int left = j + 1, right = nums.length - 1;
    			
    			while (left < right) {
    			    int sum = nums[i] + nums[j] + nums[left] + nums[right];
    				if (sum == target) {
    					result.add(Arrays.asList(nums[i], nums[j],nums[left], nums[right]));
    					/**
    					 * Ignore duplicate elements
    					 */
    					while (left < right && nums[left] == nums[left + 1]) left++;
    					while (left < right && nums[right] == nums[right - 1]) right--;
    					left++;
    					right--;
    				} else if (sum < target) {
    					left++;
    				} else {
    					right--;
    				}
    			}
			}
		}

		return result;
    }
}
