package LevelSix;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the 
 * characters in T in complexity O(n).
 * 
 * S = "ADOBECODEBANC"  T = "ABC"  Minimum window is "BANC".
 * 
 * Basically the idea here is to use a map to keep track of the count of the characters, and two pinters
 * which can keep track of the substring.
 * 
 * In the map we initialize all the charcters from the source string with count zero, and for the 
 * target string we increase the count.
 * 
 * The idea is to keep track of the target string in the substring. Characters of target string will have
 * count > 0 in the map.
 * 
 * Also there is a counter which keeps track of how many charcters of the target we found till now.
 * When the counter is zero, we got one window. We check the length of this window, if it is smaller that
 * the previous and if yes, update the minimum window to this one.
 * 
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();

		/**
		 * Initialize the map with count 0 for chars in s, increase the count for t.
		 * If we find a char in t not in the map we can return right away.
		 */
		for (char c : s.toCharArray()) {
			map.put(c, 0);
		}

		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				return "";
			}
		}

		int start = 0, end = 0, minStart = 0, minLength = Integer.MAX_VALUE, counter = t.length();

		while (end < s.length()) {
			/**
			 * These steps try to find a substring that contains t. For this we keep a track of 
			 * counter which in initialized with length of t.
			 * 
			 * To decrement the counter, we rely on the map , i.e we decrease only when the count of char c1
			 * is > 0. This is because of two reasons:
			 * 1) When we start only the chars in t will have count > 0. When their count becomes 0, we have 
			 *    got all those charcters in our substring.
			 * 2) We might have multiple characters from t in s, e.g A might be repeated several times,
			 * 	  but we only need one A in our substring. 
			 */
			char c1 = s.charAt(end);
			if (map.get(c1) > 0) {
				counter--;
			}
			/**
			 * For chars not in t, count will go negative.
			 */
			map.put(c1, map.get(c1) - 1);
			end++;

			/**
			 * When the counter becomes 0, we found a substring. Now we update this as minimum
			 * substring and try to move start to look for another substring.
			 * 
			 * while(counter == 0) means that we are moving our start pointer, but all those chars at start
			 * are not a part of t, so we do not need this substring.
			 */
			while (counter == 0) {
				char c2 = s.charAt(start);

				if (minLength > (end - start)) {
					minLength = end - start;
					minStart = start;
				}

				map.put(c2, map.get(c2) + 1);
				/**
				 * Again count will be > 0 for only the chars in t.
				 * Since other chars will have negative count, since we intialized with zero and 
				 * then decremented them while moving the end pointer.
				 * 
				 * Also since we are moving the start point here, we can at max increment a char the number 
				 * of times it appeared in substring(start, end)
				 */
				if (map.get(c2) > 0) {
					counter++;
				}
				start++;
			}
		}

		return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
	}
}
