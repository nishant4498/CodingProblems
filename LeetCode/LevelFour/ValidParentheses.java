package LevelFour;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * This is the classic stack problem.
 * 
 * Here we keep a Map of the opening/closing parentheses and key value pair.
 * For each character  
 * 
 */
public class ValidParentheses {
	public boolean isValid(String str){
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		Stack<Character> s = new Stack<>();
		
		for(int i =0; i< str.length(); i++){
			char curr = str.charAt(i);
			if(map.keySet().contains(curr)){
				s.push(curr);
			}else{
				if(!s.isEmpty() && map.get(s.peek()) == curr){
					s.pop();
				}else{
					return false;
				}
			}
		}
		
		return s.isEmpty();
	}
}
