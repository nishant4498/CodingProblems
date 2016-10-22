package LevelTwo;
/*
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Should not contain any leading or trailing spaces. Also no extra spaces between each word.
 */
public class ReverseWordsInString {

	public static void main(String[] args) {
		String s = "   a   b ";
		System.out.println(reverseWordsInString(s));
		String s1 = "the sky is blue";
		System.out.println(reverseWordsInString(s1));
		
		System.out.println(reverseWord("nishant"));
	}
	
	public static String reverseWordsInString(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        // never write words[i] == "". Always use .equals.
        for(int i = words.length -1; i >=0 ;i-- ){
            if(!words[i].trim().isEmpty()){
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        
        return sb.toString().trim();
    }
	
	/*
	 * Method to reverse a string - Just practice
	 */
	
	public static String reverseWord(String word){
		char[] chars = word.toCharArray();
		
		int start = 0;
		int end = chars.length - 1;
		
		while(start < end){
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
		
		return new String(chars);
	}

}
