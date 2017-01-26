package LevelThree;
/**
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * https://www.youtube.com/watch?v=cETfFsSTGJI - Tushar Roy
 * https://www.youtube.com/watch?v=vBdo7wtwlXs - Ideserve
 * 
 */
public class ArrayJump {
	
	/*
	 * This solution is O(n^2). It works fine but gives time limit ecceeded exception for just 
	 * one test case.
	 */
	public static int jumpDP(int[] nums){
		if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
	}
}
