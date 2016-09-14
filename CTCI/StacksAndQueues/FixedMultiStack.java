package StacksAndQueues;

import java.util.EmptyStackException;

public class FixedMultiStack {
	private int stackCapacity; //No of elements each stack can contain.
	private int numStacks = 3;
	private int[] values;// This is the array that holds all the values in the stack.
	private int[] sizes;//This array holds the number of elements currently in each stack;
	
	
	public FixedMultiStack(int stackSize){
		stackCapacity = stackSize;
		values = new int[stackSize * numStacks];
		sizes = new int[numStacks];
	}
	
	public void push(int stackNum, int value) throws FullStackException{
		if(isFull(stackNum)){
			throw new FullStackException();
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws EmptyStackException {
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		int value = values[indexOfTop(stackNum)];
		values[indexOfTop(stackNum)] = 0;
		sizes[stackNum]--;
		return value;
	}
	
	public int peek(int stackNum) throws EmptyStackException {
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNum)];
	}
	
	public boolean isEmpty(int stackNum){
		return sizes[stackNum] == 0;
	}
	
	
	public boolean isFull(int stackNum){
		return sizes[stackNum] == stackCapacity;
	}
	
	private int indexOfTop(int stackNum){
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size -1;
	}
}

class FullStackException extends Exception{
	private static final long serialVersionUID = 1L;
	
}

