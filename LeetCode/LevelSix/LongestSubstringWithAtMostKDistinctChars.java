package LevelSix;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 * 
 * Detailed description at LongestSubstringWithAtMostTwoDistinctChars.
 *
 */
public class LongestSubstringWithAtMostKDistinctChars {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		
		if(s.length() < k) return s.length();
		
		int l = 0, max = 0;

		for (int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

			if (map.size() > k) {
				max = Math.max(max, r-l);
				
				while(map.size() > k){
					char t = s.charAt(l);
					int count = map.get(t);
					if(count > 1){
						map.put(t, count-1);
					}else{
						map.remove(t);
					}
					l++;
				}
			}

		}
		
		/**
		 * Take care of the last condition
		 * 
		 * s.length() - left 
		 */
		
		max = Math.max(max,  s.length() - l);
		return max;
	}
}
