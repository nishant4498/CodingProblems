package ArraysAndStrings;

// Arrays and Strings Q 1
public class IsUniqueChar {

	public static void main(String[] args) {
		
		System.out.println("nishant has unique characters? " + isUniqueChar("nishant"));
		System.out.println("abcde has unique characters? " + isUniqueChar("abcde") + "\n");
		
		System.out.println("nishant has unique characters?Bitwise " + isUniqueCharBitwise("nishant"));
		System.out.println("abcde has unique characters? Bitwise " + isUniqueCharBitwise("abcde"));


	}
	
	public static boolean isUniqueChar(String str){
		boolean[] char_set = new boolean[256];// assuming its extended character set.
		//If length is more than 256 then obviously characters are repeated.
		if(str.length() > 256){
			return false;
		}
		for(int i =0; i< str.length(); i++){
			int position = str.charAt(i);
			if(char_set[position]){
				return false;// Already the character has been encountered.
			}
			char_set[position] = true;
		}
		return true;
	}

	/**
	 * Bitwise solution assumes that we have only small letters a-z, thus we
	 * have 26 characters at max. Thus we can fir into a single bit vector. i.e
	 * if we use int it is 32 bit and thus we can accomodate 26 characters.
	 * 
	 * Very similar to the above solution.
	 * Here we set the bit for every char position when we encounter a char.
	 * Then we check if a bit is alraedy set at a position, we return false,
	 * since that character has alraedy been encountered.
	 */
	public static boolean isUniqueCharBitwise(String str){
		int checker = 0;
		for(int i =0; i< str.length(); i++){
			int val = str.charAt(i);
			if((checker & (1 << val)) > 0){
				return false;
			}
			checker |= 1 << val; 
		}
		return true;
	}

}
