package Level8;
/**
 * https://leetcode.com/problems/length-of-last-word/
 *	Given s = "Hello World"
 *	return 5
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if(s.trim().length() == 0) return 0;
        
        String[] parts = s.split(" ");
        
        int len = parts.length;
        
        return parts[len -1].length();
    }
}
