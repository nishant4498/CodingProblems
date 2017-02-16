package LevelSix;
/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * 
 * Given a non-empty integer array of size n, find the minimum number of moves required to make 
 * all array elements equal, where a move is incrementing n - 1 elements by 1.
 * 
 * The key here is :
 * 
 * 1) Incrementing n-1 elements by 1 is same as decrementing one element.
 * 2) The total number of moves would be equal to make all the elements equal to the smallest element
 *    in the array. 
 *
 */
public class MinimumMovesToEqualArrayElementsI {
	/**
	 * Here we just find the min of all numbers in one loop and then in the next loop,
	 * we find the difference b/w the min element and all other elements.
	 */
	public int minMoves(int[] nums) {
		if (nums.length <= 1)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		int moves = 0;
		for (int i = 0; i < nums.length; i++) {
			moves += nums[i] - min;
		}

		return moves;
	}
	/**
	 * This is the same approach implemented using single loop.
	 * We find the sum and then subtract it from n time min value.
	 * The problem here is there can be overflow if the sum exceeds out of integer range.
	 */
	public int minMovesII(int[] nums){
		if(nums.length <= 1) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        int moves = sum - (min * nums.length);
        
        return moves;
	}
}
