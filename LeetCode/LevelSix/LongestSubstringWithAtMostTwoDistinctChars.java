package LevelSix;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 *
 * In all such problems, l denotes the left pointer, r denotes the right pointer.
 * 
 * Keep a left pointer that points the beginning of the substring.
 * Keep a right pointer that points to the end of the substring.
 * 
 * We keep adding the chars to a map to see the size of distinct chars in the current substring.
 * 
 * When the size of map grows k(here k = 2) We move the left pointer until the size of the map
 * grows less equal to k.
 * 
 * Here are the steps that we follow for this:
 * 
 * 1) Check the count of charAt(left) in map. 
 *    - If count > 1, it means that there are more than one char(left) in the substring.
 *    - Thus we move left and reduce the count of char(l) in map = 1
 *    - If count == 1, we remove that char from the map.
 *    - After removing this char the size of map would become l, and we again keep moving r
 *      to look for another substring.
 */
public class LongestSubstringWithAtMostTwoDistinctChars {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		
		if(s.length() < 2) return s.length();
		
		int l = 0, max = 0;
		
		/**
		 * This loop moves right to find the substring fixing the left.
		 */
		for (int r = 0; r < s.length(); r++) {
			char c = s.charAt(r);
			
			/**
			 * In the map we keep track of the chars and their count.
			 */
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}

			/**
			 * Whenever the size of map grows more than k(2 here), we keep moving left pointer
			 * till there are only 2 unique chars in the substring. At this point r is fixed and
			 * l is moving.
			 * To do this we keep reducing the count of chars at left.
			 * When the count goes zero, we remove from the map...
			 * This also means that we have now removed the extra chracter from out substring.
			 */
			if (map.size() > 2) {
				max = Math.max(max, r-l);
				
				while(map.size() > 2){
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
		 * Take care of the last condition.
		 * 
		 * It's basically s.length() - (left index). In case we keep on moving till end 
		 * with just two unique chars we won't be able to update max.
		 */
		
		max = Math.max(max,  s.length() - l);
		return max;
	}
}
