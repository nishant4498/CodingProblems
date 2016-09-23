package ArraysAndStrings;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(getCompressedString("aabcccccaaa")); //a2b1c5a3
		System.out.println(getCompressedString("abcdef"));//abcdef
	}
	
	public static String getCompressedString(String str){
		int count = 1;
		char current = str.charAt(0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =1;i < str.length();i++){
			char next = str.charAt(i);
			if(current == next){
				count++;
			}else{
				sb.append(current + "" + count);
				current = next;
				count = 1;
			}
		}
		sb.append(current + "" + count);
		String compressedString = sb.toString();
		/*
		 * We add condition two here since for a string with unique chars each char will appear just once
		 * and hence the string abc will become like a1b1c1.
		 */
		if(compressedString.length() == 2 * str.length()){
			return str;
		}
		return compressedString;
	}

}
