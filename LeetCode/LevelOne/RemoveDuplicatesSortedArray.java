package LevelOne;
/*
 * https://leetcode.com/articles/remove-duplicates-sorted-array/
 * Its actually two pointers..Both move one step only..But the slow pointer , only moves 
 * when there is a new element.
 * Use two pointers..Keep moving the fast pointer on getting duplicate elements.
 * If there is a different element copy it in the slow pointer space;
 * The idea is to keep all the unique elements till the slow pointer.
 * We just copy one element out of the many duplicates in the slow pointer next location.
 * Then we keep on moving fast pointer till we get the same element.
 */

/*
 * GOOD QUESTION
 */
public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,4};
		int[] nums1 = {1,1,2,2,3,3,4,4,5,5,5,5,6,6,6};
		
		printArray(nums);
		System.out.println(removeDuplicates(nums));
		printArray(nums);
		
		printArray(nums1);
		System.out.println(removeDuplicates(nums1));
		printArray(nums1);
		

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
	
	public static void printArray(int[] nums){
		for(Integer num : nums){
			System.out.print(num + " ");
		}
		System.out.println();
	}

}
