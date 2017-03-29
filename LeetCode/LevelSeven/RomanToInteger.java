package LevelSeven;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer
 * https://www.youtube.com/watch?v=AshOD_YF7Fw
 * 
 * Below are the rules:
 * 
 * The symbols are : I = 1 , V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
 */
public class RomanToInteger {
	/**
	 * Basically in this approach, we only subtract the current value from result if it is smaller than result.
	 * Also we check if curr character is not equal to previous character.
	 */
	public int romanToIntSimple(String s){
		Map<Character, Integer> map = getValueMap();
		
		int result = 0;
		char prev = '#';
		
		for(int i = s.length() - 1; i >= 0; i++){
			char ch = s.charAt(i);
			int value = map.get(ch);
			
			if(value < result && ch != prev){
				result = result - value;
			}else{
				result = result - value;
			}
			prev = ch;
		}
		return result;
	}
	
	/** 
	 * Basically we start from the right and keep adding/substracting the values
	 * from result computed till now.
	 * 
	 * For reduction here are the rules 1) If we get 'I' and result till now >= 5,
	 * we reduce 1. 2) If we get 'X' and the result >= 50 , we reduce 10. 3) If we
	 * get 'C' and the result >= 500, we reduce 100
	 */
	public int romanToInt(String s) {
		int result = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			switch (ch) {
			case 'I':
				result += (result >= 5 ? -1 : 1);
				break;
			case 'V':
				result += 5;
				break;
			case 'X':
				result += 10 * (result >= 50 ? -1 : 1);
				break;
			case 'L':
				result += 50;
				break;
			case 'C':
				result += 100 * (result >= 500 ? -1 : 1);
				break;
			case 'D':
				result += 500;
				break;
			case 'M':
				result += 1000;
				break;
			}
		}

		return result;
	}
	
	public Map<Character, Integer> getValueMap() {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		return map;
	}
}
