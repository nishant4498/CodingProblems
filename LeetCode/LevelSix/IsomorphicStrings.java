package LevelSix;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * Given two strings s and t, determine if they are isomorphic.Two strings are isomorphic if the 
 * characters in s can be replaced to get t.All occurrences of a character must be replaced with 
 * another character while preserving the order of characters.
 * 
 * 
 */
public class IsomorphicStrings {
	/**
	 * Basically in this solution we do a character to chracter mapping.
	 * 
	 * If we find a character that is mapped to a different character we return false;
	 * Also if the value is already mapped to a different character we return false;
	 */
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (map.containsKey(c1)) {
				if (map.get(c1) != c2)
					return false;
			} else {
				if (map.containsValue(c2))
					return false;
				map.put(c1, c2);
			}
		}
		return true;
	}
	
	/**
	 * Here we just store the previous index where the chracters appeared in the 
	 * both the strings.
	 * 
	 * But I am not very sure how this works. Need to take a look.
	 */
	public boolean isIsomorphicII(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            int c1 = s.charAt(i);
            int c2 = t.charAt(i);
            
            if (m1[c1] != m2[c2]) return false;
            
            m1[c1] = i + 1;
            m2[c2] = i + 1;
        }
        return true;
    }
}
