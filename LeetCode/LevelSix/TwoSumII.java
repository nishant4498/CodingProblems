package LevelSix;
/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 * 
 * Here we are given that the input array is sorted.
 * 
 * So we take two pointers at two ends and compute their sum.
 * 
 * If sum > target -> Move the right pointer
 *    sum < target -> Move the left pointer.
 *
 */
public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int start = 0, end = numbers.length - 1;
		int[] result = new int[2];

		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				result[0] = start + 1;
				result[1] = end + 1;
				break;
			} else if (target < sum) {
				end--;
			} else {
				start++;
			}
		}
		return result;
	}
}
