package LevelFive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
	
	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        helper(result, tempList, s, 0);
        return result;
    }
    
    public void helper(List<List<String>> result, List<String> tempList, String s, int start){
       if(start == s.length()){
    	   result.add(new ArrayList<>(tempList));
    	   return;
       }
       
       for(int i = start; i < s.length(); i++){
    	   if(isPalindrome(s, start, i)){
    		   tempList.add(s.substring(start, i+1));
    		   helper(result, tempList, s, i+1);
    		   tempList.remove(tempList.size() -1);
    	   }
       }
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println("abc".substring(0, 1));
	}
}
