package LevelOne;
//https://leetcode.com/problems/house-robber/
public class HouseRobberDP {

	public static void main(String[] args) {
		int[] nums = {1,4,1};
		int[] nums1 = {3,5,3};
		
		System.out.println(rob(nums));
		System.out.println(rob(nums1));
	}
	
	public static int rob(int[] nums) {
		int length = nums.length;
        int[] maxRobValue = new int[length];
        
        if(nums == null || length == 0) return 0;
        
        if(length == 1) return nums[0];
        
        maxRobValue[0] = nums[0];
        maxRobValue[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < length ;i ++){
           maxRobValue[i] = Math.max((nums[i] + maxRobValue[i-2]) , maxRobValue[i-1]);
        }
        
        return maxRobValue[length-1];
    }
}
