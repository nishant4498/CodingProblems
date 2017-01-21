package LevelFour;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 * 
 * abs(nums[i] - nums[j]) <= t && abs(i - j) <= k.
 * 
 * Here we have to use TreeSet which is a ConcreteClass and implements NavigableSet, Set and SortedSet.
 * 
 * 1) The idea is to add the numbers of the array into a sorted set.
 * 2) At any time we just keep k elements in the set since the numbers in the array with range outside
 *    k are not relevant for this problem.
 * 3) Then we just check if the set has a subset in the range (num - t) & (num + t). If yes we return true;
 */
public class ContainsNearbyDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int t, int k){
		if(nums == null || nums.length < 2 || k < 0 || t < 0) return false;
		
		TreeSet<Long> set = new TreeSet<Long>();
		/**
		 * We can't write Set<Long> set = new TreeSet<Long>() as navigable set functions won't be avaialble.
		 * i.e. set.subSet();
		 */
		
		for(int i = 0; i < nums.length; i++){
			long num = (long) nums[i];
			
			long start = num - t;
			long end = num + t + 1;
			
			if(set.subSet(start, end).size() > 0) return true;
			
			set.add(num);
			// At any time we just keep k elements in the set since that is the range that we are expecting.
			if(set.size() > k){
				set.remove(nums[i - k]);
			}
			
		}
		
		return false;
	}
}
