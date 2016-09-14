package ArraysAndStrings;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(getCompressedString("aabcccccaaa"));
		System.out.println(getCompressedString("abcdef"));
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
		if(compressedString.length() == 2 * str.length()){
			return str;
		}
		return compressedString;
	}

}
