package ArraysAndStrings;

public class PalindromePermutation {

	public static void main(String[] args) {
		String str = "Tact Coa";
		String str1 = "AbdebA";
		
		System.out.println(isPalindromePermutation(str));
		System.out.println(isPalindromePermutation(str1));
		
		System.out.println(isPalindromePermutationAlternate(str));
		System.out.println(isPalindromePermutationAlternate(str1));
		
		System.out.println(isPalindromePermutationBitwise(str));
		System.out.println(isPalindromePermutationBitwise(str1));

	}
	/*
	 * Get the count of each character in an array of size equal to num characters = 26.
	 * If there are more than one chars with odd count return false.
	 */
	public static boolean isPalindromePermutation(String str){
		int[] countChars = new int[26];
		
		for(int i =0; i< str.length(); i++){
			char c = str.charAt(i);
			int index = getCharIndex(c);
			if( index > 0){ // to ignore characters other than alphabets.
				countChars[index]++;
			}
		}
		
		boolean foundOdd = false;
		for(int i =0; i < 26; i++){
			if(countChars[i] % 2 != 0){
				if(foundOdd) return false;
				foundOdd = true;
			}
		}
		return true;
	}
	/*
	 * No need to stress more on this method.	 * 
	 * When increasing the char count, also maintain a count of number of odd chars.
	 */
	public static boolean isPalindromePermutationAlternate(String str){
		int[] countChars = new int[26];
		
		int countOdd = 0;
		for(int i =0; i< str.length(); i++){
			char c = str.charAt(i);
			int index = getCharIndex(c);
			if( index > 0){
				countChars[index]++;
				/*
				 * Counting the number of odds on the go.No need to do in a
				 * separate loop.
				 */
				if((countChars[index] % 2) != 0){
					countOdd++;
				}else{
					countOdd--;
				}
			}
		}		
		return countOdd <= 1;
	}
	
	public static boolean isPalindromePermutationBitwise(String str){
		int bitVector = 0;
		char c;
		int index;
		for(int i = 0; i< str.length(); i++){
			c = str.charAt(i);
			index = getCharIndex(c);
			bitVector = toggle(bitVector, index);
		}
		
		if(bitVector == 0 || checkExactlyOneBitset(bitVector)){
			return true;
		}
		return false;
	}
	/*
	 * Toggles the bit vector at a given index.
	 */
	public static int toggle(int bitVector , int index){
		// To handle characters outside alphabet range.
		if(index < 0) return bitVector;
		
		int mask = 1 << index; // 0000 1000
		
		if((bitVector & mask) == 0){ // bitVector = 1011 0111 , Value at index is not set
			bitVector |= mask; // Set that bit bitVector will become 1011 1111
		}else{//bitVector = 1011 1000 , , Value at index is set
			bitVector = bitVector & (~mask); // 1011 1000 & 1111 0111 , sets the bit at Pos to zero.
		}
		
		return bitVector;
	}
	/*
	 * The AND of num and num-1 will be zeo if there is only one bit set in num.
	 */
	public static boolean checkExactlyOneBitset(int bitVector){
		return (bitVector & (bitVector - 1)) == 0;
	}
	
	public static int getCharIndex(char c){
		if(c >= 'a' & c <= 'z')
			return c - 'a';
		if(c >= 'A' & c <= 'Z')
			return c - 'A';
		return -1;
	}
}
