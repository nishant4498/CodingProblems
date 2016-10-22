package LevelTwo;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-palindrome/
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * Case sensitive.
 * Here the idea is only the even count of characters can help build a palindrome.
 * So we take the count of all the characters with even count. If some character had odd count, we subtract 1 and take it.
 * e.g out of aaa only 2 a's can be aprt of the palindrome string.
 * We add 1 in the result in the end if we find any odd length char since at max 1 chracter can contribute to the 
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		String input = "abccccdd"; // 4 c 2 d 1 a or b.
		System.out.println(longestPalindrome(input));
	}
	
	 public static int longestPalindrome(String s) {
	        if(s == null || s.isEmpty()) return 0;
	        Map<Character, Integer>  charCount = new HashMap<>();
	        
	        for(int i =0; i< s.length(); i++){
	            char c = s.charAt(i);
	            if(charCount.containsKey(c)){
	                charCount.put(c , charCount.get(c) + 1);
	            }else{
	                charCount.put(c , 1);
	            }
	        }
	        
	        int count = 0;
	        boolean hasOddLength = false;
	        for(char key : charCount.keySet()){
	            int currCount = charCount.get(key);
	            if(currCount % 2 == 0){
	                count += currCount;
	            }else{
	                count += currCount - 1;
	                hasOddLength = true;
	            }
	        }
	        
	        return hasOddLength? count + 1: count;
	    }

}
