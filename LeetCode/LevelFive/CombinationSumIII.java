package LevelFive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * 
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * The difference here is that the sum need to be formed by max k numbers.
 * 
 * So here we need to check that the length of the tempList should be k when the target sum is zero.
 * 
 * k = 3, n = 7  O/P - [[1,2,4]]
 * k = 3, n = 9 O/P [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		int[] candidates = new int[9];
		for (int i = 0; i < 9; i++) {
			candidates[i] = i + 1;
		}
		helper(result, tempList, candidates, n, k, 0);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tempList, int[] input, int target, int k, int start) {
		if (target == 0 && tempList.size() == k) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = start; i < input.length; i++) {
			if (input[i] > target)
				continue;
			tempList.add(input[i]);
			helper(result, tempList, input, target - input[i], k, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
