package LevelFour;

/*
 * https://leetcode.com/problems/power-of-two/
 * The number should be positive. As we know n & (n-1) clears the last bit. For power 
 * of two there should be only 1 bit set.
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && ((n & (n - 1)) == 0);
	}
}
