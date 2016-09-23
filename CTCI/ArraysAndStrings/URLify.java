package ArraysAndStrings;

public class URLify {

	public static void main(String[] args) {
		String input = "Mr John Smith     ";
		System.out.println(replaceSpaces(input, 13));
	}
	
	public static String replaceSpaces(String str , int length){
		char[] chars = str.toCharArray();
		int spaceCount = 0;
		for(int i=0 ; i< length-1; i++){
			if(str.charAt(i) == ' '){
				spaceCount++;
			}
		}
		/*
		 * We can also use the fact the length of the string is good enough to adjust the new chars.
		 */
		int newLength = length + spaceCount*2;
		chars[newLength] = '\n';
		for(int i = length-1 ; i >= 0 ; i--){
			if(chars[i] == ' '){
				chars[newLength - 1] = '0';
				chars[newLength - 2] = '2';
				chars[newLength - 3] = '%';
				newLength = newLength-3;
			}else{
				chars[newLength -1] = chars[i];
				newLength--;
			}
		}
		return new String(chars);
	}
}
