package LevelFour;

import java.util.HashMap;
import java.util.Map;

/*
 * Both in leetcode and CTCI. 16.18
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPatternMatching {
	public boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		if(pattern == null || str == null) return false;
		
		String[] words = str.split(" ");
		
		if(pattern.length() != words.length) return false;
		
		for(int i =0; i< pattern.length(); i++){
			char ch = pattern.charAt(i);
			String word = words[i];
			
			if(map.containsKey(ch)){
				if(!map.get(ch).equals(word)) {
					return false;
				}
			}else if(map.containsValue(word)){
				return false;
			} 
			map.put(ch, word);
		}		
		return true;
	}
	
	public static void main(String[] args) {
		WordPatternMatching test = new WordPatternMatching();
		System.out.println(test.wordPattern("abab", "dog cat dog cat"));
		System.out.println(test.wordPattern("abab", "dog dog dog dog"));
	}
}
