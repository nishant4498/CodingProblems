package LevelOne;
import java.util.HashMap;
import java.util.Map;
/*
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,3,5,7,11};
		int target = 10;
		int[] result = twoSum(nums, target);
		System.out.println(result[0] + "  " +  result[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    int[] result = new int[2];
	    for(int i =0; i < nums.length ; i++ ){
	    	int complement = target - nums[i];
	    	if(map.containsKey(complement)){
	    		result[0] = map.get(complement);
	    		result[1] = i;
	    		return result;
	    	}
	    	map.put(nums[i], i);
	    }
	    return result;
	}

}
