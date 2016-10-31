package LevelFour;

/*
 * https://leetcode.com/problems/single-number/
 * The idea is to do the xor of all numbers. Xor of two same numbers is zero.Thus only 
 * number appearing once will be left.
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		if (nums.length == 0)
			return 0;
		int missingNum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			missingNum = missingNum ^ nums[i];
		}

		return missingNum;
	}
	
	/*
	 * Also check single number 2.
	 * https://leetcode.com/problems/single-number-ii/
	 * https://discuss.leetcode.com/topic/2031/challenge-me-thx
	 * http://www.programcreek.com/2014/03/leetcode-single-number-ii-java/
	 */
}
