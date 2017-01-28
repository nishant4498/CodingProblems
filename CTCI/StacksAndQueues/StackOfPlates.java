package StacksAndQueues;
/**
 * We need to implement a stack of plates where the size of each stack can only reach a certain capacity. 
 * TODO - Implement a function which can pop at any index
 */
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
	private List<Stack<Integer>> stacks;
	private int capacity;
	
	public StackOfPlates(int capacity){
		stacks = new ArrayList<>();
		this.capacity = capacity;
	}
	
	public void push(int item){
		Stack<Integer> last = getLastStack();
		if(last != null && ! (last.size() == capacity)){
			last.push(item);
		}else{
			Stack<Integer> s = new Stack<>();
			s.push(item);
			stacks.add(s);
		}
	}
	
	public void pop(){
		Stack<Integer> last = getLastStack();
		if (last == null) throw new EmptyStackException(); 
		
		last.pop();
		if(last.size() == 0){
			stacks.remove(stacks.size() - 1);
		}		
	}
	
	/**
	 * TODO
	 * Removes the element at that particulat index.
	 * @param int index  
	 * @return int value at that index
	 */
	
	public int popAt(int index){
		return 0;
	}
	/**
	 * TODO
	 * Also left shifts the remaining elemnets to fill the gap.
	 * @param index
	 * @return value at that index
	 */
	public int leftShift(int index){
		/*
		 * This is little crucial function.It can be implemented recursively
		 */
		return 0;
	} 
	
	private Stack<Integer> getLastStack(){
		if(stacks == null || stacks.isEmpty()) return null;		
		return stacks.get(stacks.size() - 1);
	}
}
