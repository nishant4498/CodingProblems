package StacksAndQueues;

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
	
	public static Stack<Integer> sortStack(Stack<Integer> originalStack){
		Stack<Integer> bufferStack = new Stack<Integer>();
		while(!originalStack.isEmpty()){
			int temp = originalStack.pop();
			while(!bufferStack.isEmpty() && bufferStack.peek() < temp){
				originalStack.push(bufferStack.pop());
			}
			bufferStack.push(temp);
		}
		return bufferStack;
	}

}
