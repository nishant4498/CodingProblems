package LevelSeven;
/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/?tab=Description
 */
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharString {
	/**
	 * 1) Basically here we compute a frequency table of characters in the string.
	 * 
	 * 2) Then we iterate through the string and check if the freq for some character is 1. That 
	 * 	  will be the first unique char.
	 */
	public int firstUniqueChar(String s) {
		int[] freq = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			freq[ch - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (freq[ch - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}
	
	/**
	 * This method is same as the above with the only difference being, instead of freqTable
	 * we are generating a freq map.
	 */
	public int firstUniqCharMap(String s) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        
        return -1;
        
    }
}
