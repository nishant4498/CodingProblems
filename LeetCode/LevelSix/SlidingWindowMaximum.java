package LevelSix;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * THIS CAN ALSO BE EASILY SOLVED USING A MAX HEAP WITH SIZE K.EVERY TIME ADD THE TOP OF THE HEAP
 * TO THE RESULT. Time Complexity O(nlogk)
 * 
 * Below is a linear solution using a dequeue:-
 * 
 * Basically the idea here is to maintain a Dequeue(or Linked List) which holds k elements at a time.
 * 
 * 1) We push the indices of the array in the queue. Every time we check that if the element in the front of
 * 	  the queue is out of range k, we remove the front element.
 * 2) Then we keep checking the elements from the end of the queue and remove the elements which are smaller 
 *    than the element at index i.Thus we are only left with the elements which are larger than i.
 * 3) Thus in this queue, the element at the front will be the max.We add this to the result.
 *
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k){
		int n = nums.length;
		
		if(n == 0) return nums;
		
		LinkedList<Integer> dq = new LinkedList<>();
		
		int[] result = new int[n-k+1];
		
		for(int i = 0; i < n; i++){
			/**
			 * peek() and poll() retreive and remove the head of the linked list.
			 */
			if(!dq.isEmpty() && dq.peek() < i-k+1){
				dq.poll();
			}
			
			while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
				dq.pollLast();
			}
			
			dq.offer(i);
			
			/**
			 * With this condition we can avoid initially pushing k elements and then starting.
			 */
			if(i-k + 1 >= 0){
				result[i-k+1] = nums[dq.peek()];
			}
		}
		return result;
	}
}
