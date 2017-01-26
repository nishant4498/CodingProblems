package LevelFour;

/*
 * Both in leetcode and CTCI. 16.5
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * 
 * Basically here we need to count how many multiples of 5, 25, 125 ... are present in the number.
 * Since every zero is created by a multiple of 5 * 2. The number of zeroes will be equal to the 
 * number of 5's in the number. We consider 25, 125 as 25 consists of two 5's 125 3 5's and so on.
 * This needs to be considered. * 
 */
public class FactorialTrailingZeros {
	public int trailingZeroes(int n) {
		int count = 0;

		while (n > 0) {
			n = n / 5;
			count += n;
		}
		return count;
	}
}
