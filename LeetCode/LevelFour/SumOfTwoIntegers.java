package LevelFour;

/* CTCI - 17.1 
 * https://leetcode.com/problems/sum-of-two-integers/
 * Check CTCI for better explanation.
 */
public class SumOfTwoIntegers {
	/*
	 * Basically xor gives the sum without carry.
	 * & left shifted by 1 gives the carry.
	 */
	public int getSum(int a, int b) {
		while (b != 0) {
			int sum = a ^ b;
			int carry = (a & b) << 1;
			a = sum;
			b = carry;
		}
		return a;
	}
	
	 public int getSumRecursion(int a, int b) {
	       if (b == 0) return a;
	       
	       int sum = a ^ b;
	       int carry = (a & b) << 1;
	       return getSum(sum, carry);
	    }
}
