package LevelOne;

/*
 * The number of 1 bits in an integer is called Hamming Weight of the number.
 */
public class HammingWeight {

	public static void main(String[] args) {
		System.out.println(hammingWeight(15));
		System.out.println(hammingWeightOptimized(31));
	}

	/*
	 * This method checks every bit by doing AND with mask which has 1 at that position
	 * 0000 1100 AND 0000 0100 Tells the bit at position 2 is 1;
	 */
	public static int hammingWeight(int num){
		int bitCount = 0;
		int mask = 1;
		
		for(int i =0; i< 32; i++){
			if((num & mask) != 0) bitCount++;
			
			mask <<= 1; 
		}
		
		return bitCount;
	}
	/*
	 * Here the key is to keep fliping the last LSB which is 1 until the number is zero.
	 * num & (num-1) flips the last LSB that is 1.
	 */
	public static int hammingWeightOptimized(int n){
		int bitCount = 0;
		
		while(n != 0){
			n &= (n-1); // n = n & (n-1) this will flip the LSB which is 1.
			bitCount++;
		}
		return bitCount;
	}
}
