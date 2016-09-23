package LevelOne;
import java.util.HashSet;
import java.util.Set;
/*
 * https://leetcode.com/articles/contains-duplicate/
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		int[] nums = { 10, 25, 18, 26, 27 , 10};
		System.out.println(containsDuplicate(nums));
	}

	public static boolean containsDuplicate(int[] nums) {
		if(nums.length == 0){
			return false;
		}
		Set<Integer> numbers = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (numbers.contains(nums[i])) {
				return true;
			}
			numbers.add(nums[i]);
		}
		return false;
	}

}

/**
 * TreeSet gives a sorted set.
 */
