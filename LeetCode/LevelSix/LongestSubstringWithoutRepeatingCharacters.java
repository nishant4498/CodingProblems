package LevelSix;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * 
 *  Given "abcabcbb", the answer is "abc", which the length is 3.
 *	Given "bbbbb", the answer is "b", with the length of 1.
 *  Given "pwwkew", the answer is "wke"
 * 
 * Basically we keep track of the position of unique characters in the string using a map.
 * 
 * We keep two pointers left and right. 
 * Right pointer keeps on moving forward.Every time we check if the character exists in the map.
 * In case we find a character that is in the map already, me move the left pointer to the 
 * next character after that.
 * 
 * Every time we keep track of the max length in the loop.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int max = 0;
        
        for(int l = 0, r = 0; r < s.length(); r++ ){
            if(map.containsKey(s.charAt(r))){
                /**
                 * When we see a duplicate character, we move the left pointer to the character after that.
                 * We need to be careful here since the left pointer always moves forward. 
                 * In case the index of repeated char is behind left, this means that we have alraedy crossed 
                 * that point.
                 * Hence we take a max(left, curr_pos of dulicate char + 1);
                 * 
                 * e.g abba 
                 * 
                 * Here when we encounter b at position 2, we move left to oldPosition of b + 1 i.e 2.
                 * Now when we get a again, if we don't check the max condition we will go back
                 * to 0 + 1. Hence we take max so that we do not go back. 
                 */
            	l = Math.max(l,map.get(s.charAt(r)) + 1);
            }
            
            map.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
