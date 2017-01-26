package LevelFour;
/*
 * CTCI - 16.26
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {
	public static int calculate(String s){
		if(s == null || s.length() == 0) return 0;
		
		s = s.trim().replaceAll(" +", "");
		
		int md = -1; 
		int sign = 1;
		int prev = 0;
		int result = 0;
		
		for(int i =0; i< s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				int num = c - '0';
				while(++i < s.length() && Character.isDigit(s.charAt(i))){
					num = num * 10 + (s.charAt(i) - '0');
				}
				i--;
				
				if(md == 1){
					prev = prev * num;
					md = -1;
				}else if(md == 0){
					prev = prev / num;
					md = -1;
				}else{
					prev = num;
				}
			}else if(c == '*'){
				md = 1;
			}else if(c == '/'){
				md = 0;
			}else if(sign == '+'){
				result = result + sign * prev;
				sign = 1;
			}else if(sign == '-'){
				result = result + sign * prev;
				sign = -1;
			}
		}
		
		result = result + sign * prev;
		return result;
	}
}
