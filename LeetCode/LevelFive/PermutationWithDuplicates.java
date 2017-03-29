package LevelFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations-ii/ 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class PermutationWithDuplicates {
	/**
	 * 
	 * 
	 * 1) Sorting the array. 
	 * 2) if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
	 * 
	 * This basically says that we ignore a number if: a) It has been used
	 * already. b) It is the same number as the previous number and the previous
	 * number has not been used yet.
	 * 
	 * The idea here is to only consider the item once in any permutation 
	 * 
	 * Let's take example of 1 1 2
	 * 
	 * For the first iteration
	 * 
	 * i = 0 item = 1 , used[] initially = [F, F, F], used[] later = [T,F, F], tempList= [1,]
	 *       i = 0 item = 1 , used[] = [T,F,F] , since used[i] we move  to i = 1
	 *       i = 1 item = 1 , used[] = [T,F,F] , used[i] = False, nums[i] == nums[i-1] but used[i-1] = True, This means we are
	 *                        visiting this for the fisrt time and thus add
	 *                        Thus used[] = [T,T,F] tempList = [1,1]
	 *              i = 0, item = 1 , used[] = [T,T,F] used[i] = true continue
	 *              i = 1, item = 1                    used[i] = true continue 
	 *              i = 2, item = 2 used[i] = false add, used[T,T,T] tempList = [1,1,2]
	 *        
	 * i = 1, item = 1, used[] [F,F,F], here nums[i] == nums[i-1] but used[i-1] = false
	 * 					so we ignore this path totally.This basically means that, since we have not used[i-1]
	 *                  in this iteration, it much have been used in previous iteration and thus we should ignore this
	 *                  path totally as it will generate the same result. 
	 * 
	 * i = 2 item = 2, used[] = [F,F,F]
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);
		helper(result, new ArrayList<>(), new boolean[nums.length], nums);
		return result;
	}

	public void helper(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<>(tempList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;
			tempList.add(nums[i]);
			used[i] = true;
			helper(result, tempList, used, nums);
			used[i] = false;
			tempList.remove(tempList.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		PermutationWithDuplicates pwd = new PermutationWithDuplicates();
		int[] nums = {1,1,2};
		System.out.println(pwd.permuteUnique(nums));
	}

}

class PermutationWthDuplicatesSwap {
	public List<List<Integer>> permuteUniqueSwap(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		permute(nums, result, 0, nums.length - 1);
		return result;
	}

	public void permute(int[] input, List<List<Integer>> result, int l, int r) {
		if (l == r) {
			result.add(convertToList(input));
		}
		/**
		 * This is the only change here wrt. to the permutation where duplicates
		 * are allowed. Here we create a cache which is basically a Set and
		 * acnnot contain duplicates. Important point to note here is we just
		 * maintain unique characters at a particular level and not deeper down
		 * the tree e.g 1 1 2 At level one we will have a) 1 1 2 - Swapping 1 at
		 * pos 0 with 1 at pos 0. b) 1 1 2 - Swapping 1 at position 0, with 1 at
		 * pos 1. c) 2 1 1 Swapping 1 at pos 0, with 1 at position 2.
		 * 
		 * So here branch b would not be followed, since 1 has already been
		 * added to set in step a.
		 */
		Set<Integer> cache = new HashSet<>();
		for (int i = l; i <= r; i++) {
			if (cache.add(input[i])) {
				swap(input, l, i);
				permute(input, result, l + 1, r);
				swap(input, l, i);
			}
		}
	}

	public List<Integer> convertToList(int[] input) {
		List<Integer> list = new ArrayList<>();
		for (int num : input)
			list.add(num);
		return list;
	}

	public void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
