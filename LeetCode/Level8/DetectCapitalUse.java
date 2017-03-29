package Level8;
/**
 * https://leetcode.com/problems/detect-capital/
 * 
 * It should be either all uppercase, lowercase or Upper camel case.
 *
 */
public class DetectCapitalUse {
	public boolean detectCapitalUse(String word) {
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
	}
}
