package StacksAndQueues;

import java.util.EmptyStackException;

public class MyQueue<T> {
	private static class QueueNode<T>{
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T input){
			this.data = input;
		}		
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item){
		QueueNode<T> t = new QueueNode<T>(item);
		
		if(last !=  null){
			/*
			 * Very important to note this here. We are not putting 
			 * t.next = last Think of it as a singly linked list, each element being
			 * added in the end and removed from beginning
			 */
			last.next = t;
		}
		last = t;
		if(first == null){
			first = last;
		}
	}
	
	public T remove(){
		if(first == null) throw new EmptyStackException();		
		T item = first.data;
		first = first.next;
		if(first == null){
			last = null;
		}
		return item;
	}
	
	public T peek(){
		if(first == null) throw new EmptyStackException();	
		return first.data;		
	}
	
	
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public static void main(String[] args){
		MyQueue<Integer> myQueue = new MyQueue<>();
		
		System.out.println(myQueue.isEmpty());
		
		myQueue.add(1);
		myQueue.add(2);
		myQueue.add(3);
		
		while(!myQueue.isEmpty()){
			System.out.println(myQueue.remove());
		}
	}
}
