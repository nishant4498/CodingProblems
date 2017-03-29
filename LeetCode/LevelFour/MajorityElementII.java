package LevelFour;

/*
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * In this problem we need to find elements which appear more than n/3 times. As we can easily see,
 * there can only be two such majority elements.
 * Thus this is a simple extension to the majority element problem but we need to keep track of two pointers
 * for the two elements.  
 */
import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int c1 = 0, c2 = 0;
		Integer num1 = null, num2 = null;
		//One important thing to note is we have to follow the order in which we check the various conditions.
		for (int num : nums) {
			if (num1 != null && num1 == num) {
				c1++;
			} else if (num2 != null && num2 == num) {
				c2++;
			} else if (c1 == 0) {
				num1 = num;
				c1++;
			} else if (c2 == 0) {
				num2 = num;
				c2++;
			} else {
				c1--;
				c2--;
			}
		}
		if (c1 > 0) {
			if (validateMajority(nums, num1))
				result.add(num1);
		}
		if (c2 > 0) {
			if (validateMajority(nums, num2))
				result.add(num2);
		}

		return result;
	}

	public static boolean validateMajority(int[] nums, int num) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num) {
				count++;
			}
		}
		return (count > nums.length / 3);
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		List<Integer> result = majorityElement(nums);
		for (int num : result) {
			System.out.println(num);
		}
	}
}
