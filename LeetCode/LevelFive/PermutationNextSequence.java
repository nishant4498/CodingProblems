package LevelFive;

import java.util.Arrays;

/**
 * https://leetcode.com/articles/next-permutation/
 * 
 * Given an integer sequence, we need to figure out the next lexicographically greater permutation of numbers.
 * 
 * The idea here is to performs one pass in three steps:
 * 
 * 1) Intuition - If the given list is in all decreasing order, there is no next permutation possible
 *    Start from right and fird the first number which is greater than the number on its left.
 *    i.e Find i such that nums[i] > nums[i-1]
 * 2) We then  swap i-1 with the number just greater than that on the part i - n-1.
 * 
 * 3) Reverse the subarray (i, n-1) as it is in decreasing order and we for next permutation we all elements
 *    on right of i-1 in increasing order.
 *
 */
public class PermutationNextSequence {
	public void nextPermutation(int[] nums){
		int n = nums.length;
		int i = n - 1;
		
		while(i > 0 && nums[i] <= nums[i-1]){
			i--;
		}
		// if i == 0, it means that the whole array is in descending order and we simply reverse the array.
		if(i > 0){
			int j = n-1;
			while(j > 0 && nums[j] <= nums[i-1]){
				j--;
			}
			swap(nums, i-1, j);
		}
		reverseArray(nums, i);
	}
	
	public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverseArray(int[] nums, int start){
        int i = start;
        int j = nums.length-1;
        
        while(i < j){
            swap(nums, i , j);
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
		int[] nums = {1,5,8,4,7,6,5,3,1};
		PermutationNextSequence pns = new PermutationNextSequence();
		pns.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
