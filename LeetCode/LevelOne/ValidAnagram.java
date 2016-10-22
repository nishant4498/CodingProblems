package LevelOne;

public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "naaram"));
	}

	public static boolean isAnagram(String s, String t) {
		/*
		 * This condition is very important for this method.
		 */
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

}
