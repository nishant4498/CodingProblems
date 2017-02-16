package LevelThree;

/*
 * https://leetcode.com/problems/maximum-product-subarray/
 * TODO check the problem with the leetcode refactired solution
 */
public class MaxProductSubarray {
	public int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int maxHerePrev = nums[0];
		int minHerePrev = nums[0];
		int maxProduct = nums[0];

		int maxHere, minHere;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				maxHere = Math.max(nums[i], maxHerePrev * nums[i]);
				minHere = Math.min(nums[i], minHerePrev * nums[i]);
			} else {
				maxHere = Math.max(nums[i], minHerePrev * nums[i]);
				minHere = Math.min(nums[i], maxHerePrev * nums[i]);
			}
			maxHerePrev = maxHere;
			minHerePrev = minHere;
			maxProduct = Math.max(maxHere, maxProduct);
		}
		return maxProduct;
	}
}
