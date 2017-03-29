package LevelSeven;
/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 * 
 * Basically we do a binary search and check the following:
 * 
 * 1) If the mid element is greater than the last element, it means mid lies in the rotated portion.
 * 2) Hence the minimum must lie on the right hand side. change low = mid +1
 * 3) If mid is not greater, it means we are in the non rotated portion and thus we change the high to mid.
 */
public class MinimumInRotatedSortedArray {
	public int findMin(int[] nums){
		int low = 0, high = nums.length -1;
		
		while(low < high){
			int mid = (low + high)/2;
			if(nums[mid] > nums[high]){
				low = mid + 1;
			}else{
				high = mid;
			}
		}
		return nums[low];
	}
}
