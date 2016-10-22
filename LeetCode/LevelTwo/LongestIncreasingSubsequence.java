package LevelTwo;
/*
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * https://www.youtube.com/watch?v=CE2b_-XfVDk 
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int[] input = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(lengthOfLIS(input));
	}
	
	public static int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        int maxLen = 0;
        
        for(int i =0; i< nums.length; i++){
            LIS[i] = 1;
        }
        
        for(int i = 1; i< nums.length;i++){
            for(int j =0; j< i; j++){
                if(nums[j] < nums[i]){
                    LIS[i] = Math.max(LIS[i] , 1+ LIS[j]);
                }
            }
        }
        
        for(int len : LIS){
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}
