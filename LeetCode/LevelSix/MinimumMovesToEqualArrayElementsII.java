package LevelSix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * 
 * Given a non-empty integer array, find the minimum number of moves required to make all 
 * array elements equal, where a move is incrementing a selected element by 1 or 
 * decrementing a selected element by 1.
 * 
 * Basically this is the same concept as the BestMeetingPoint.
 * 1) We need to sort the array and find the median of the array.
 * 2) Basically this is the point which is equidistant from the left and right.
 * 	  Thus this is the point where we can reach in minimum steps.
 * 3) Then we just compute the difference of each element in the array from median - This would 
 *    denote the number of moves needed to reach from that position to the mid element.   
 */
public class MinimumMovesToEqualArrayElementsII {
	public int minMovesII(int[] nums){
		Arrays.sort(nums);
		int median = nums[nums.length/2];
		
		int moves = 0;
        for(int i =0; i< nums.length; i++){
            moves += Math.abs(nums[i] - median);
        }        
        return moves;
	}
}
