package LevelSeven;
/**
 * In this problem we need to reverse the words in string in place i.e - using O(1) space.
 * Also its given that there are no extra white spaces, so we do not need to trim.
 * 
 *  e.g  - "the sky is blue"
 *  o/p  - "blue is the sky"
 *  
 *  Here we apply the following approach-
 *  
 *  1) We reverse each word indidually at its own place.
 *  2) We reverse the whole string.
 *  
 *  Step 1 - "eht yks si eulb"
 *  Step 2 - "blue is sky the"
 *
 */
public class ReverseWordsInStringII {
	/**
	 * Couple of important points in the method below : idea is to reverse each single word.
	 * 
	 * 1) We keep a variable j, that tracks the begin of the word.
	 * 2) We run a loop from i = 0 to s.length
	 * 3) Two important conditions for reversing last word - i <= s.length && if condition checking i == s.length
	 */
	public void reverseWords(char[] s){
		for(int i = 0, j = 0; i <= s.length; i++){
			if(i == s.length || s[i] == ' '){
				reverseString(s, j, i-1); //The word indices re j .. i-1
				j = i + 1;// set j to mark beginning of next word.
			}
		}
		reverseString(s, 0, s.length -1);
	}
	
	private void reverseString(char[] s, int start, int end){
		while(start < end){
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
}
