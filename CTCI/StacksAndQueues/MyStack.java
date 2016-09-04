package StacksAndQueues;

import java.util.EmptyStackException;

public class MyStack<T> {
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T input){
			this.data = input;
		}		
	}
	
	private StackNode<T> top;
	
	public T pop(){
		if(top == null) throw new EmptyStackException();		
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public T peek(){
		if(top == null) throw new EmptyStackException();	
		return top.data;		
	}
	
	public void push(T item){
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public static void main(String[] args){
		MyStack<Integer> myStack = new MyStack<>();
		
		System.out.println(myStack.isEmpty());
		
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		
		while(!myStack.isEmpty()){
			System.out.println(myStack.pop());
		}
	}
}
