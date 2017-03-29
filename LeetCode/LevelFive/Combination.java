package LevelFive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *  n = 4 and k = 2, a solution is:  [ [2,4], [3,4],[2,3],[1,2],[1,3],[1,4],]
 *  
 *  Basically this is same as PowerSet , some of the differences being
 *  a) We don't store every tempList but only lists of length k.
 *  b) We start with 1 as n varies from 1-n.
 */
public class Combination {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();

		helper(result, tempList, n, k, 1);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
		if (tempList.size() == k) {
			result.add(new ArrayList<>(tempList));
			return;
		}
		
		for (int i = start; i <= n; i++) {
			tempList.add(i);
			helper(result, tempList, n, k, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
