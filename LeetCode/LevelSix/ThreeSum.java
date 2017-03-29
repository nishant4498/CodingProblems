package LevelSix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Here are the steps taken to find the triplets which sum to zero.Basically we sort the array, fix the
 * pointer at one element and then try to find other two elements that together sum to zero.
 * 
 * 1) Sort the array.
 * 2) Run the loop from i - 0 .. n-2
 * 3) Basically for each element at position i, we try to find a pair that together sum up to zero.
 * 4) To avoid duplicates we keep moving both the left and right pointers till we encounter same elements.
 * 5) In case sum is greater, we try to move the left index, since the array is sorted.
 * 
 * Time Complexity O(n^2)
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int left = i + 1, right = nums.length - 1, sum = 0 - nums[i];
			while (left < right) {
				if (nums[left] + nums[right] == sum) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					/**
					 * Ignore duplicate elements
					 */
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				} else if (nums[left] + nums[right] < sum) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}
}
