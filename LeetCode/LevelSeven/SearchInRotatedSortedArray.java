package LevelSeven;
/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * CTCI 10.3
 * 
 * Basically, in this problem we try to find the min element index using binary search.
 * 
 * Once we find the min element we can easily figure out which part of the array our target lies:
 * 
 * i.e to the left of min or right fo min. Based on this info we can search the target using binary search
 * on that part of the array.
 *
 */
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target){
		if(nums.length == 0) return -1;
		
		int min = findMinIndex(nums);
		if(target == nums[min]) return min;
		
		int n = nums.length;
		
		int low = (target <= nums[n-1])? min : 0;
		int high = (target > nums[n-1])? min : n-1;
		
		while(low <= high){
			int mid = (low + high)/2;
			if(nums[mid] == target) return mid;
			
			if(target > nums[mid]){
				low = mid + 1;
			}else{
				high = mid -1;
			}
		}
		
		return -1;
	}
	
	public int findMinIndex(int[] nums){
		int low = 0, high = nums.length -1;
		
		while(low < high){
			int mid = (low + high) / 2;
			/**
			 * A VERY IMPORTANT POINT TO NOTE THAT WE COMPARE nums[mid]  with nums[high] TO FIND THE MIN INDEX
			 */
			if(nums[mid] > nums[high]){
				low = mid + 1;
			}else{
				high = mid;
			}
		}
		return low;
	}
}
