package LevelFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
 *
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();

		Arrays.sort(nums);
		helper(result, tempList, nums, 0);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
		/**
		 * The main condition here is (i > start && nums[i] == nums[i - 1])
		 * Let's look at the subsets of [1,2,2]
		 * 
		 * [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
		 * 
		 * Here if we don't give the condition i > start, [1,2,2] & [2,2] wont be printed as well.
		 * The reason is we would consider the numbers once in some set even if they are duplicates.
		 * So when i = start they are processed and inserted into the tempList. for i > start we ignore the 
		 * duplicate characters.
		 */
		result.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]){
				continue;
			} 
			tempList.add(nums[i]);
			helper(result, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		SubsetsII ps = new SubsetsII();
		int[] nums = {1,2,2};
		System.out.println(ps.subsetsWithDup(nums));
	}
}
