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
 * 	  We check in the range (num - t) to (num + t) since we are taking num as the reference point.
 *    e.g consider num = 5 and t = 2  => we can return true if we find any of the numbers
 *    2,3,4,5,6,7 - since all these numbers are in the range of 2 from the number.
 *    
 *    So basically two main points here:
 *    a) Sorted set so that we can find the numbers in the range (num -t) & (num + t +1)
 *    b) Deleting kth element by using nums[i - k] and not just the element at index 0 in the set.
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
			long end = num + t + 1;//End exclusive
			
			if(set.subSet(start, end).size() > 0) return true;
			
			set.add(num);
			/**
			 * At any time we just keep k elements in the set since that is the range that we are expecting.
			 * 
			 * Another important point to note is.. while deleting from the set, we can't simply delete
			 * the element at pos 0 since we just want k elements.
			 * We just want k consecutive elements from the array - but since the set is sorted, the kth element
			 * might be somewhere in the middle. So we need to specifically delete that number using 
			 * nums[i - k]. It will delete that element wherever it lies in the set.
			 */
			if(set.size() > k){
				set.remove((long)nums[i - k]);
			}
			
		}
		
		return false;
	}
}
