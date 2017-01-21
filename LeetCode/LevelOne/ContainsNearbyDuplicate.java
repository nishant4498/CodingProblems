package LevelOne;
import java.util.HashMap;
import java.util.Map;
/*
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * The idea is to keep inserting an element and its position into Hash Map.
 * If we encounter that number again we compare the indices and return true if within range k.
 * We update the current index if the range is more than k to look for another possible solution.
 */
public class ContainsNearbyDuplicate {

	public static void main(String[] args) {
		int[] nums = {1,2,1};
		int k = 0;
		
		System.out.println(containsNearbyDuplicate(nums, k));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        for(int i =0;i< nums.length;i++){
            if(indexMap.containsKey(nums[i])){
                if(i - indexMap.get(nums[i]) <= k){
                    return true;
                }
            }
            indexMap.put(nums[i] , i);
        }
        return false;
    }

}
