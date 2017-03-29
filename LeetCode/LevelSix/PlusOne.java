package LevelSix;
/** 
 * https://leetcode.com/problems/plus-one/
 * 
 * The digits of a number are given in array. We have to add one and return an array for the sum.
 * 
 * input 748 as [7,4,8] result = [7,4,9]
 * 
 * Basically we iterate from n-1 th position, which is the unit's place in the digit and whenevr we find a digit
 * less than 9, we add one and return back the result.
 * 
 * If all numbers are 9, then we need to create a new array with length n + 1 and set it 0'th position as 1.
 */
public class PlusOne {
	public int[] plusOne(int[] digits){
		int n = digits.length;
		
		for(int i = n-1; i >= 0; i--){
			if(digits[i] < 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		
		int[] sum = new int[n+1];
		sum[0] = 1;
		return sum;
	}
}
