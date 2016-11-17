package LevelFour;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * This is typical DFS question.
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n == 0)
			return result;

		StringBuilder sb = new StringBuilder();
		helper(result, sb, n, n);
		return result;
	}
	
	/**
	 * Here left and right denote the number of left and right parentheses remaining to be added.
	 */
	public void helper(List<String> result, StringBuilder sb, int left, int right){
		/**
		 * This condition is very important since at any point the number of left should be higher
		 * than that of right.
		 */
		if(left > right){
			return;
		}
		
		if(left == 0 && right == 0){
			result.add(sb.toString());
			return;
		}
		
		if(left > 0){
			int len = sb.length();
			helper(result, sb.append('('), left -1, right);
			sb.setLength(len);
		}
		
		if(right > 0){
			int len = sb.length();
			helper(result,sb.append(')'), left, right -1);
			sb.setLength(len);
		}
	}
}
