package LevelThree;
/**
 *https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "aabcbaaaabaaaa";
		System.out.println(longestPalindrome(s));
	}
	/*
	 * Basically we initialize all strings of length 1 as palindrome
	 * Then for len = 2 we initialize as true if a[i] = a[i + 1]
	 * Then we use these values for computing for len = 3 to n
	 * Recurrence = LPS[i][j] = true if (a[i] = a[j] & LPS[i+1][j-1] = true) 
	 */
	
	//Try to do O(1) space solution for this.
	public static String longestPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		int maxLength = 0;
		int begin = 0;
		int n = s.length();
		boolean[][] LPS = new boolean[n][n];

		maxLength = 1;
		for (int i = 0; i < n; i++) {
			LPS[i][i] = true;
		}
		/*
		 * Taking n-1 as we have to check for substring of length 2.
		 */
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				LPS[i][i + 1] = true;
				maxLength = 2;
				begin = i;
			}
		}
		//For length 3 and more.
		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j) && LPS[i + 1][j - 1]) {
					LPS[i][j] = true;
					if (k > maxLength) {
						maxLength = k;
						begin = i;
					}
				}
			}
		}

		return s.substring(begin, begin + maxLength);
	}
}
