package BitManipulation;

public class CommonBiTTasks {

	public static void main(String[] args) {
		int number = 109; // 0110 1101
		
		System.out.println(Integer.toBinaryString(number) + "\n");
		
		System.out.println("Bit value at Pos 1: " + getBit(number, 1));
		System.out.println("Bit value at Pos 2: "  + getBit(number, 2) + "\n");
		
		int setNum = setBit(number, 1);
		System.out.println("After setting the bit at positon 1: " + Integer.toBinaryString(setNum) + "\n");
		
		int clearNum = clearBit(setNum, 1);
		System.out.println("After clearing the bit at positon 1: " + Integer.toBinaryString(clearNum)+ "\n");
		
		int clearMSBtoPos = clearBitsMSBthroughPos(number, 4);
		System.out.println("After clearing the bit from MSB to positon 4: " + Integer.toBinaryString(clearMSBtoPos)+ "\n");
		
		int clearPostoZero = clearBitsPosthroughZero(number, 3);
		System.out.println("After clearing the bit from Pos 3 to zero: " + Integer.toBinaryString(clearPostoZero)+ "\n");
		
		int clearPostoZeroCTCI = clearBitsPosthroughZeroCTCI(number, 3);
		System.out.println("After clearing the bit from Pos 3 to zero CTCI: " + Integer.toBinaryString(clearPostoZeroCTCI)+ "\n");
		
		int updatedNum = updateBit(number, 1, true);
		System.out.println("After setting the bit at Pos 1: " + Integer.toBinaryString(updatedNum)+ "\n");
		
		int updatedNum1 = updateBit(number, 2, false);
		System.out.println("After clearing the bit at Pos 2: " + Integer.toBinaryString(updatedNum1)+ "\n");
	}
	
	/*
	 * Gets the bit in an number at a particular position(position starts from right, 0)
	 * The idea to create a mask with 1 at that position then AND with the number.
	 * If > 0(i.e 1 ), val is 1 otherwise val is 0 at that position
	 */
	public static boolean getBit(int num, int pos){
		return ((num & (1 << pos)) > 0);
	}
	
	
	public static int setBit(int num, int pos){
		return num | (1 << pos);
	}
	
	/*
	 * Create a mask with zero at that position.
	 * To do this left shift 1 position times and then negate.
	 * the result is number & mask
	 */
	public static int clearBit(int num, int pos){
		int mask = ~(1 << pos);
		return num & mask;
	}
	
	/*
	 * Create a mask as mentioned in the formula. First set the bit at Pos.
	 * Subtracting 1 makes all bits after Pos 1 and before that are already
	 * zero.
	 */
	public static int clearBitsMSBthroughPos(int num, int pos){
		int mask = (1 << pos) - 1;
		return num & mask;
	}
	/*
	 * This is just the reverse of the above.
	 * We need zeros from Pos to 0th bit.We create a mask with left shift one more than Pos and subtract 1.
	 * This gives all 1s from Pos-0. Negating gives all zeros and thus we can clear all bits from Pos.
	 */
	public static int clearBitsPosthroughZero(int num, int pos){
		int mask = ~((1 << (pos+1)) - 1);
		System.out.println(Integer.toBinaryString(mask));
		return num & mask;
	}
	/*
	 * Here we create the same mask using logical right shift of -1(which is basically all 1s with sign bit on.)
	 * Negating gives a mask with all zeros from Pos-0.
	 */
	public static int clearBitsPosthroughZeroCTCI(int num, int pos){
		int mask = ~(-1 >>> ( 31-pos));
		System.out.println(Integer.toBinaryString(mask));
		return num & mask;
	}
	
	/*
	 * First clear the bit by doing AND with mask like 11110111 (for Pos 3)
	 * Then or with the value to be updated at Pos.
	 */
	public static int updateBit(int num,int pos, boolean bitIs1){
		int val = bitIs1 ? 1 : 0;
		int mask = ~(1 << pos);// creates the mask to clear the bit
		return (num & mask) | (val << pos);
	}

}
