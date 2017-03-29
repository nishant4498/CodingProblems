package LevelSix;
/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive).
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * SOLUTION 1: Binary Search
 * https://discuss.leetcode.com/topic/25580/two-solutions-with-explanation-o-nlog-n-and-o-n-time-o-1-space-without-changing-the-input-array
 * 
 * THIS IS A VERY IMPORTANT BINARY SEARCH TECHNIQUE WHERE WE NEED TO FIND A RANGE
 * SIMILAR TO KthSmallestElementSortedMatrix SOLUTION 3
 * 
 * The idea is to count the numbers between range 1-n using binary serach.
 * 
 * Lets say n = 10. This means we have numbers in the range [1,10]
 * We take mid = 5 and count the number of elements in the array less than equal to 5.
 * If there are more than 5 elements in this range, it means duplicate lies bw 1-5 and thus we 
 * change high = 5.
 * Otherwise we duplicate lies in the other half.
 * 
 * Time Complexity - O(nlogn) - Since we are doing binary search over n elements.
 * 
 * SOLUTION 2: Similar to Linked list cycle.
 * 
 *
 */
public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums){
		int low = 1, high = nums.length - 1;
		
		while(low < high){
			int mid = low + (high - low)/2;
			int count = 0;
			for(int num : nums){
				if(num <= mid) count++;
			}
			
			if(count > mid){
				high = mid;
			}else{
				low = mid + 1;
			}
		}
		return low;
	}
}
