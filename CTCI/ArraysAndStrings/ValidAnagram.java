package ArraysAndStrings;

public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "naaram"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		//This we can even take as 128 we take the whole char set instead of just lowercase letters.
		int[] table = new int[26];
		//int[] char_set = new int[128];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
			//char_set[s.charAt(i)]++;
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
