package LevelSix;
/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 
 * when the reversed integer overflows.
 * 
 * e.g -123 result = -321
 */
public class ReverseInteger {
	public int reverse(int x) {
        int input = x;
        int sign = input < 0 ? -1 : 1;
        
        input *= sign;
        
        int result = 0;
        
        while(input > 0){
            if(Integer.MAX_VALUE/10 < result  || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10 < input % 10){
					return 0;
			}
            result = result * 10 + input % 10;
            input = input/10;
        }
        return result * sign;
    }
}
