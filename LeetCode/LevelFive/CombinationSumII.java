package LevelFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * Given a set of candidate numbers C(without duplicates), a target sum T, find all unique 
 * combinations in C that sum to T.Each number in C may only be used once in the combination. 
 * 
 *  C = [10, 1, 2, 7, 6, 1, 5] T = 8
 *  Solution set -  [[1,1,6],[1,2,5],[1,7],[2,6]]
 *  
 *  Difference from CombinationSum
 *  
 *  1) Start is updated to  i + 1 since we dont need to consider the dsme element again.
 *  2) We use the condition if(used[i] || i > start && input[i] == input[i-1] && !used[i-1]) continue
 *     to avoid duplicate entries into the set.
 *
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		Arrays.sort(candidates);
		helper(result, tempList, candidates, new boolean[candidates.length], target, 0);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tempList, int[] input, boolean[] used, int sum,
			int start) {
		if (sum == 0) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = start; i < input.length; i++) {
			if (input[i] > sum)
				continue;
			if (used[i] || i > start && input[i] == input[i - 1] && !used[i - 1])
				continue;
			tempList.add(input[i]);
			used[i] = true;
			helper(result, tempList, input, used, sum - input[i], i + 1);
			tempList.remove(tempList.size() - 1);
			used[i] = false;
		}
	}
}
