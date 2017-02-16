package LevelFour;

/* CTCI - 17.1 
 * https://leetcode.com/problems/sum-of-two-integers/
 * Check CTCI for better explanation.
 * 
 * The idea here is to compute sum and carry seprately as below:
 * 
 * 1) If we add two binary numbers and do not take the carry, bit in i'th position will be 0, only if
 *    both bits are 0 or both are 1.This is basically XOR.
 * 2) If we only take the carry, i'th bit will be 1 only if both (i-1)'th bits are 1. This is basically
 *    & left shifted by 1.
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
