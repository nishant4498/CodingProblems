package LevelSix;
/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
	public static String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        
        if(s.length() < 2) return s;
        
        char[] chars = s.toCharArray();
        
        int l = 0 , r = s.length() -1;
        
        while(l < r){
        	/**
        	 * Important to give l < r condition inside as well.Otherwise one extra swap will be
        	 * done inside.
        	 */
        	while(l < r && !vowels.contains(chars[l])) l++;
            while(l < r && !vowels.contains(chars[r])) r--;
            swap(chars,l,r);
            l++;
            r--;
        }
        return new String(chars);
    }
    
    public static void swap(char[] chars, int l , int r){
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }
    
    public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
	}
}
