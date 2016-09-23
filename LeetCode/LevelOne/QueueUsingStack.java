package LevelOne;
import java.util.Stack;
/*
 * https://leetcode.com/articles/implement-queue-using-stacks/  
 *  Approach 2 - Push - O(1) per operation, Pop - Amortized O(1) per operation
 *  The idea is to keep pushing all the elments to s1.
 *  If we need to pop, we move all elements to s2 and then pop from s2. 
 */
public class QueueUsingStack {
	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();
	
	private int front;
	
	public void push(int x){
		if(s1.isEmpty()){
			front = x;
		}
		s1.push(x);
	}
	
	public int pop(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
	public int peek(){
		if(!s2.isEmpty()){
			return s2.peek();
		}
		return front;
	}
	
	public boolean isEmpty(){
		return s1.isEmpty() && s2.isEmpty();
	}
}
