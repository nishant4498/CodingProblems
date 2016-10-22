package LevelTwo;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k =3;
		rotateArray(nums, k);
		System.out.println(Arrays.toString(nums));
		
		int[] nums1 = {1,2,3,4,5,6,7};
		rotateArrayByReversing(nums1, k);
		System.out.println(Arrays.toString(nums1));
	}
	/*
	 * This is the naive approach where we copy the result in a diffrent array.
	 * Time - O(n) Space - O(n)
	 */
	
	public static void rotateArray(int[] nums, int k){		
		int len = nums.length;
		if(k > len){
			k = k % len;
		}
		int[] result = new int[len];
		
		for(int i =0; i< k;i++){
			result[i] = nums[len - k + i];
		}
		
		int j =0;
		for(int i = k; i< len; i++){
			result[i] = nums[j];
			j++;
		}
		// This copis into the same array.
		System.arraycopy(result, 0,nums , 0, len);
	}
	
	public static void rotateArrayByReversing(int[] nums, int k) {
        int len = nums.length;
		if(k > len){
			k = k % len;
		}
		
		int firstPartLen = len - k;
		reverseArray(nums , 0, firstPartLen - 1);
		reverseArray(nums, firstPartLen, len - 1);
		reverseArray(nums, 0 , len - 1);
    }
    
    public static void reverseArray(int[] nums, int start, int end){
        if(nums == null || nums.length == 1){
            return;
        }
        
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
