package LevelFour;
/*
 * https://leetcode.com/problems/missing-number/
 * CTCI - 17.4
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 */
public class MissingNumber {
	/*
	 * This is a simple solution where we compute the sum of given numbers and subtract it from the
	 * sum of numbers from 1..n(which is n * (n +1)/2).
	 */
	public static int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int totalSum = n * (n + 1)/2;
        
        int currSum = 0;
        
        for(int i =0 ; i < n ; i++){
            currSum += nums[i];
        }
        
        return totalSum - currSum;
    }
	
	/*
	 * In this solution we simply do a bitwise XOR with numbers from 1 to n with the given numbers.
	 * Thus in the end only one number will be left which is missing since all others will appear
	 * twice.
	 */
	public static int missingNumberBitwise(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;

        int missingNum = 0;
        
        /*
         * Point to note is , its all XOR
         * Basically the equation is => missingNum = missingNum ^ (i+1) ^ nums[i];
         */
        for(int i =0 ; i < n ; i++){
            missingNum ^= (i+1) ^ nums[i];
        }
        
        return missingNum;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,5,6,7};
		System.out.println(missingNumber(nums));
		System.out.println(missingNumberBitwise(nums));
	}
}
