/*
 * https://leetcode.com/articles/move-zeroes/
 */
public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		for(int num : nums){
			System.out.print(num + " ");
		}
		System.out.println();
		
		moveZeroes(nums);
		for(int num : nums){
			System.out.print(num + " ");
		}
	}
	
	public static void moveZeroes(int[] nums){
		if(nums == null){
			return;
		}
		int length = nums.length;
		int zerosCount = 0;
		
		for(int i =0; i< length; i++){
			if(nums[i] == 0){
				zerosCount++;
			}else{
				// Every non-zero element has to be moved back by the number of
				// zeros coming before it.
				nums[i - zerosCount] = nums[i];
			}
		}
		// Fill zeros in the end.
		while(zerosCount > 0){
			nums[length - zerosCount--] = 0;
		}
		
	}

}
