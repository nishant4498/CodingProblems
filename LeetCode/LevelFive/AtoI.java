package LevelFive;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * Following things to check
 * 
 * 1) Can have empty strings in the beginning.
 * 2) Can have sign(+/-) in the start as first char.
 * 3) Can have non numeric characters in the later part 123abcd-= should retrn 123
 * 4) Range should not exceed max/min allowed value for integer.
 *
 */
public class AtoI {
	public int atoi(String str){
		str = str.trim();
		if(str.length() == 0) return 0;
		
		int sign = 1;
		int result = 0;
		int i = 0;
		
		if(str.charAt(i) == '-'){
			sign = -1;
			i++;
		}else if(str.charAt(i) == '+'){
			i++;
		}
		
		for(; i < str.length(); i++){
			char c = str.charAt(i);
			
			if(Character.isDigit(c)){
				int num = c - '0';
				
				if(Integer.MAX_VALUE/10 < result || Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10 < num){
					return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				
				result = result * 10 + num;
			}else{
				return 0;
			}
		}
		
		return sign * result;
	}
	
	
}
