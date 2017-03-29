package Level8;
/**
 * https://leetcode.com/problems/number-complement
 * 
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of 
 * its binary representation.
 * 
 * The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * 
 * As we know , to flip the bit we need an XOR operation.Only thing that we need to be careful is, we need to XOR with
 * only the number of bits in the number.
 * e.g 5 = 101 so mask should contain 3 bits = 111.
 * 
 * In our solution below, to control the number of bits in the mask, we are doing a right shift of the number until its zero.
 * 
 * 
 *
 */
public class NumberComplement {
	public int findComplement(int num) {
		int result = num;// Intialize with num.
		int i = 0;
		while (num != 0) {
			result = result ^ (1 << i++);// XOR at ith bit position
			num = num >> 1;// Right shift the number.
		}
		return result;
	}
}
