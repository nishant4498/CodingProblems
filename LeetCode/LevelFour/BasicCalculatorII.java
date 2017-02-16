package LevelFour;
/**
 * CTCI - 16.26
 * https://leetcode.com/problems/basic-calculator-ii/
 * 
 * Basically there are couple of things to take care of for solving elegantly:
 * We will run through the expression 3 + 2 - 5 * 4 for understanding:
 * 
 * 1) We need three variables here for holding numbers, 
 * 		result -> Keeps the result computed till now.
 * 		prev -> keeps hold of the previous number emcountered
 *      num -> current number being processed.
 * 2) We have md and sign to take care of which operator we have encountered.
 * 3) One very important point to note is, if we encounter +/- operator, we can directly compute the
 *    previous result. But in case of * or / we have to wait for the next operand.
 *    
 *    e.g when we encounter - sign in the above expression, we can go can add prev(here 2) to the 
 *    result computed till now(i.e 3) and we update the sign for the next result computation. 
 * 4) So after processing every number we need to see if there has been a m or d encountered.
 *    In that case we need to process the number( here 4) with the prev number(5).
 *    
 * 5) The biggest challenge with understanding this implemnetation is to, usally we think from start to end,
 *    but we need to code this from end to beginning. e.g. - Checking the md sign right after fetching a number. 
 */
public class BasicCalculatorII {
	public static int calculate(String s){
		if(s == null || s.length() == 0) return 0;
		
		s = s.trim().replaceAll(" +", "");
		
		int md = -1; // 1 for multiplication, 0 for division
		int sign = 1;// Addition and subtraction
		int prev = 0;
		int result = 0;
		
		for(int i =0; i< s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				int num = c - '0';
				while(++i < s.length() && Character.isDigit(s.charAt(i))){
					num = num * 10 + (s.charAt(i) - '0');
				}
				i--;// Decrement since we have moved one ahead while seraching the number.
				
				
				/**
				 * After processing a number we check if we had encountered md before.
				 * In that case we compute prev value and then reset the md flag.
				 */
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
				/**
				 * Important point to note here is that the result computed here is the result of
				 * the expression coming before that sign.Since there is no md flag, we dont need to 
				 * wait for the next number for evaluation.
				 */
				result = result + sign * prev;
				sign = 1;
			}else if(sign == '-'){
				result = result + sign * prev;
				sign = -1;
			}
		}
		// This step is needed so that we dont leave the last value.
		result = result + sign * prev;
		return result;
	}
}
