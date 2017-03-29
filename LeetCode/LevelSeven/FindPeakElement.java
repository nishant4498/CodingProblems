package LevelSeven;
/**
 * https://leetcode.com/problems/find-peak-element/
 * Given an input array where num[i] != num[i+1], find a peak element and return its index.The array may 
 * contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 
 * Basically we need to do a binary search.
 * 
 * The condition here will be:
 * 
 * 1) If nums[mid] < nums[mid + 1] , it means that the array is still increasing and we can move to the 
 *    right, else move to the left.
 * 
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums){
		int start = 0;
		int end = nums.length -1;
		
		while(start < end){
			int mid = (start + end)/2;
			
			if(nums[mid] < nums[mid +1]){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return start;
	}
}
