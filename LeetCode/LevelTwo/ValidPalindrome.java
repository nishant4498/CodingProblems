package LevelTwo;
/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));
	}
	
	public static boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        String input = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end){
            char a = input.charAt(start);
            char b = input.charAt(end);
            //To check whether a character is alphanumeric or not.
            if(!Character.isLetterOrDigit(a) || !Character.isLetterOrDigit(b)){
                if(!Character.isLetterOrDigit(a)){
                    start ++;
                }
                if(!Character.isLetterOrDigit(b)){
                    end --;
                }
            }
            else if(a != b){
                return false;
            }else{
                start++;
                end--;
            }
            
        }
        
        return true;
    }

}
