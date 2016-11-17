package LevelFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Both in leetcode and CTCI. 16.20
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Again a typical DFS problem. At each level of the tree, for each node we have those many branches
 * as the characters mapped to that digit.The result will be the path from root to leaf.
 */
public class LetterCombinationsOfPhoneNumber {
	public static void main(String[] args) {
		letterCombinations("2");
	}
	public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        
        StringBuilder sb = new StringBuilder();
        Map<Character,String> keyMap = getPhoneKeyMap();
        
        helper(result, sb, digits, 0, keyMap);
        return result;
    }
    
    public static void helper(List<String> result, StringBuilder sb, String digits, int index, Map<Character,String> keyMap){
        if(index > (digits.length() - 1)) {
            result.add(sb.toString());
            return;
        }
        
        String keyString = keyMap.get(digits.charAt(index));
        
        for(int i =0 ; i< keyString.length(); i++){
            int len = sb.length();
            char c = keyString.charAt(i);
            sb.append(c);
            helper(result, sb, digits, index + 1, keyMap);
            sb.setLength(len);
        }
    }
    
    private static Map<Character, String> getPhoneKeyMap(){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "");
        return map;
    }
}
