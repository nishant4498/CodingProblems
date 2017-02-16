package LevelFive;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/count-derangements-permutation-such-that-no-element-appears-in-its-original-position/
 * Basically we have to permute the given numbers so that no element appears in its own place.
 * 
 *  Count can be found using the recursive formuala:
 *  countDer(n) = (n -1)*(count(n-2) + count(n-1))
 *  
 *  Since an element cannot be placed at its original position, we have (n-1) derangements for the same.
 *  
 *  Now lets say element 0 is replaced with element i
 *  
 *  a) IF i IS PLACED AT POS 0 - This is equlvalent to countDer(n-2) as two elements have been placed
 *  b) IF i IS NOT PLACED AT POS 0 - This is similar to derangement of n-1 items as only 0 has been placed.
 *  
 *  We will use a dp based solution to find the count.
 */
public class CountDerangements {
	/**
	 * This function is used to count the number of derangemnets
	 */
	public int countDerangement(int n){
		int[] dp = new int[n+1];
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i = 3; i<= n; i++){
			dp[i] = (i-1) * (dp[i-1] + dp[i-2]);
		}
		
		return dp[n];
	}
	/**
	 * This function actually finds all the derangemnets
	 */
	public List<List<Integer>> computeDerangements(int n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList= new ArrayList<>();
		int[] nums = new int[n];
		for(int i =0; i< n ; i++){
			nums[i] = i;
		}
		helper(result, tempList, nums);
		return result;
	}
	
	private void helper(List<List<Integer>> result, List<Integer> tempList, int[] nums){
		if(tempList.size() == nums.length){
			result.add(new ArrayList<>(tempList));
			return;
		}		
		for(int i = 0; i< nums.length; i++){
			if(i== tempList.size() || tempList.contains(nums[i])) continue;
			tempList.add(nums[i]);
			helper(result, tempList, nums);
			tempList.remove(tempList.size() - 1);
		}
	}	
	
	public static void main(String[] args) {
		CountDerangements cd = new CountDerangements();
		
		System.out.println(cd.countDerangement(2));//{0,1}
		System.out.println(cd.computeDerangements(2));
		
		System.out.println(cd.countDerangement(3));//{0,1,2}
		System.out.println(cd.computeDerangements(3));
		
		System.out.println(cd.countDerangement(4));//{0,1,2,3}
		System.out.println(cd.computeDerangements(4));
	}
}
