package LevelSix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 * CTCI - 17.22
 * 
 *
 */
public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        beginSet.add(beginWord);
        
        if (dict.contains(endWord)) endSet.add(endWord); // all transformed words must be in dict (including endWord)
        
        /**
         * Since we need to reach from start to end, both being different- minimum length is bound to be 2.
         */
        int len = 2;
        
        while (!beginSet.isEmpty()) {
            Set<String> tempSet = new HashSet<>();
            
            for (String w : beginSet) {
                for (int j = 0; j < w.length(); j++) {
                    char[] chars = w.toCharArray();
                    
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        /**
                         * Here we can't write if(chars[i] == ch) since, we keep on updating
                         * chars, and this will lead to an infinite loop.
                         */
                    	if (ch == w.charAt(j)) continue; //beginWord and endWord not the same, so bypass itself
                        chars[j] = ch;
                        String target = String.valueOf(chars);
                        if (endSet.contains(target)) return len; //meet from two ends
                        /**
                         * This works even if we do not check in the visited, since tempSet itself is a set.
                         * But adding visited check improves the time.
                         */
                        if (dict.contains(target) && visited.add(target)) tempSet.add(target);
                    }
                }
            }
            /**
             * Here we switch to small one to traverse from other end. This is how bi- directional
             * search is applied here.
             */
            beginSet = (tempSet.size() < endSet.size()) ? tempSet : endSet; // 
            endSet = (beginSet == tempSet) ? endSet : tempSet;
            len++;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"});
		ladderLength(beginWord, endWord, wordList);
	}
}
