package Level8;
/**
 * https://leetcode.com/problems/hamming-distance/
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * 
 * 1) Basically we take a mask and check at each position.
 *    If the and with mask is different, it means that the bits are different.
 * 
 * 2) In this approach we can XOR both x and y. This will leave only those bits on, which are differnt.
 * 	  After that we can do and with the mask and xor result to count the number of bits.
 *
 */
public class HammingDistance {
	public int hammingDistance(int x, int y) {
		int mask = 0;
		int distance = 0;
		for (int i = 0; i < 32; i++) {
			mask = 1 << i;
			if ((x & mask) != (y & mask))
				distance++;
		}
		return distance;
	}
}
