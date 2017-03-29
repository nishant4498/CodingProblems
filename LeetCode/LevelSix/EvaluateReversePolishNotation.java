package LevelSix;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * It is basically standard postfix evaluation using stack.
 * 
 * IDEA : If we get an operator, we pop the top two elements, perform the operartion and push 
 *        the result back into the stack.
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<>();
        if(tokens.length == 0) return 0;
        int result = 0;
        int n1, n2;
        for(String curr : tokens){
            if(curr.equals("+")){
               result = s.pop() + s.pop();
               s.push(result);
            }else if(curr.equals("-")){
            	n2 = Integer.valueOf(s.pop());
                n1 = Integer.valueOf(s.pop());
                result = n1 - n2;
                s.push(result);
            }else if(curr.equals("*")){
                result = s.pop() * s.pop();
                s.push(result);
            }else if(curr.equals("/")){
                n2 = Integer.valueOf(s.pop());
                n1 = Integer.valueOf(s.pop());
                result = n1/n2;
                s.push(result);
            }else{
                s.push(Integer.valueOf(curr));
            }
        }
        return s.pop();
	}
}
