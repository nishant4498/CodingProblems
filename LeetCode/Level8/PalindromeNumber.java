package Level8;
/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Reverse the integer and compare with the number.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        int num = x;
        int reverse = 0;
        
        while(num > 0){
            reverse = reverse * 10 + num % 10;
            num = num /10;
        }
        
        return (x == reverse);
    }
}
