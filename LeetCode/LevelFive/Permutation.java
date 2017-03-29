package LevelFive;
/**
 * https://leetcode.com/problems/permutations/
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * 
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ - Permutaion without duplicates in sorted order.
 */
import java.util.ArrayList;
import java.util.List;

public class Permutation {	
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList= new ArrayList<>();
		
		helper(result, tempList, nums);
		return result;
	}
	
	private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums){
		if(tempList.size() == nums.length){
			result.add(new ArrayList<>(tempList));
			return;
		}		
		for(int i = 0; i< nums.length; i++){
			/**
			 * tempList.contains(nums[i]) can also be replaced with using an extra boolean[] used
			 * and checking used[i].
			 * Similar to PermutationWithDuplicates
			 */
			if(tempList.contains(nums[i])) continue;
			tempList.add(nums[i]);
			helper(result, tempList, nums);
			tempList.remove(tempList.size() - 1);
		}
	}	
	
	public static void main(String[] args) {
		Permutation pm = new Permutation();
		int[] nums = {1,2,3};
		System.out.println(pm.permute(nums));
	}
}

class PermutationSwap {

	public List<List<Integer>> permuteSwap(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;
		helper(nums, result, 0, nums.length - 1);
		return result;
	}

	private void helper(int[] input, List<List<Integer>> result, int l, int r) {
		if (l == r) {
			result.add(convertToList(input));
			return;
		}

		for (int i = l; i <= r; i++) {
			swap(input, l, i);
			helper(input, result, l + 1, r);
			swap(input, l, i);
		}
	}

	private List<Integer> convertToList(int[] input) {
		List<Integer> list = new ArrayList<>();
		for (int num : input)
			list.add(num);
		return list;
	}

	private void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
