/*
 * https://leetcode.com/articles/remove-duplicates-sorted-array/
 * Use two pointers..Keep moving the fast pointer on getting duplicate elements.
 * If there is a different element copy it in the slow pointer space;
 */
public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,4};
		int[] nums1 = {1,1,2,2,3,3,4,4,5,5,5,5,6,6,6};
		
		System.out.println(removeDuplicates(nums));
		System.out.println(removeDuplicates(nums1));

	}
	
	public static int removeDuplicates(int[] nums){
		int i = 0;
		
		for(int j =1; j < nums.length ; j++){
			if(nums[i] != nums[j]){
				i++;
				nums[i] = nums[j];
			}
		}
		
		return i + 1; // since i started with zero.
	}

}
