package LevelSix;
/**
 * https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * https://discuss.leetcode.com/topic/10351/o-1-space-java-solution
 * We try to put the elements in their place.
 * 
 * The idea is in sorted array - the element A[i] will be at position i - 1
 * e.g 1 should be at position 0, 2 at position 1.
 * 
 * Thus we iterate through the array and swap the elements if the follwing conditions are not met:
 * 
 * 1) - If the element is at expected position i.e nums[i] = i + 1, we do not need to swap.
 *    - If element is 0 or -ve, we dont do anything.
 *    - If element is greater than array length we ingone it.
 *      	Here we do not consider equal to array length since we always place at position i -1.
 *      	Thus if an element is equal to length, it will be the last element in the sorted array.
 * 2) If the element at position A[i] - 1 == A[i] - we do not need to swap as these are duplicate elements.
 * 
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int i = 0;

		while (i < nums.length) {
			if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {//Condition 1																			
				i++;
			} else if (nums[nums[i] - 1] == nums[i]) {//Condition 2
				i++;
			} else {
				swap(nums, i, nums[i] - 1);
			}
		}

		i = 0;

		while (i < nums.length && nums[i] == i + 1)
			i++;
		return i + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
