package LevelFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * http://javabypatel.blogspot.in/2015/10/all-subsets-of-set-powerset.html
 * 1) Method One - Using bitwise operator
 *  Basically for a set of size n there can be 2 ^ n number of subsets, since each elemnt has 2 options - either
 *  to be present in the set or absent in the set.
 *  Thus we simply iterate from (0- 2^n -1) and find the equivalent subset for each value.
 *  e.g {1,2,3} total three values so, 8 subsets 0-7
 *  100 can give the subset {3} , 101 can give {3,1} , 111 can give {3,2,1} and so on.
 *  
 *  O(n * 2 ^ n)
 * 
 * 2)Backtracking
 * 
 *   https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 */
public class PowerSet {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();

		if (nums.length == 0)
			return subsets;

		int numSubsets = 1 << nums.length;

		for (int i = 0; i < numSubsets; i++) {
			subsets.add(convertIntegerToSet(i, nums));
		}
		return subsets;
	}
	/**
	 * To find the equivalent subset for a value b/w (0 - 2 ^ n -1), we need to check the bits at each position and
	 * if set add element from that index to the set.
	 * Perform & with value and mask . Thus if LSB is set, we get 1 as the set.
	 * Again leftshift the mask by 1, if 2nd bit is also get we {1,2} as the subset and so on. 
	 */
	public List<Integer> convertIntegerToSet(int val, int[] nums){
        List<Integer> result = new ArrayList<>();
        int mask = 1;
        for(int i = 0; i < nums.length; i++){
            if((val & mask) != 0){
                result.add(nums[i]);
            }
            mask = mask << 1;
        }
        return result;
    }
	/**
	 * This is a basic recursion method where we keep storing the result as we go down the
	 * recursion tree.
	 */
	public List<List<Integer>> subsetsRecursion(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		
		Arrays.sort(nums);		
		helper(result, tempList, nums, 0);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
		/**
		 * We create a new list here and append it.This is very important since the same list keeps 
		 * on getting modified.
		 * 
		 * Subset means it does not need contain all elements, so the condition is not == length
		 * and do not return after this statement.
		 *
		 */
		result.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			helper(result, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		PowerSet ps = new PowerSet();
		int[] nums = {1,2,3};
		System.out.println("Bitwise:    " + ps.subsets(nums));
	
		System.out.println("Recursion:  " + ps.subsetsRecursion(nums));
	}
}
