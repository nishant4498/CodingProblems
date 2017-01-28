package StacksAndQueues;
/**
 * Basically the idea here is while pushing the elemnts in the buffer stack,
 * we make sure we are pushing in the sorted order.
 */
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.push(15);
		myStack.push(10);
		myStack.push(2);
		myStack.push(20);
		myStack.push(11);
		myStack.push(7);
		
		Stack<Integer> sortedStack = sortStack(myStack);
		
		while(!myStack.isEmpty()){
			System.out.print(myStack.pop() + " ");
		}		
		
		System.out.println();
		while(!sortedStack.isEmpty()){
			System.out.print(sortedStack.pop()+ " ");
		}

	}
	
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!r.isEmpty() && r.peek() < temp){
				s.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}
}
