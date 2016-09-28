package LevelTwo;
/*
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
	Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	Queue<Integer> minHeap = new PriorityQueue<>();
	
	public void addNum(int num){
		/*
		 * Intially add the number to the maxHeap and then pop it and put in the minHeap.
		 * The size of maxHeap should always be equal to or one more than minHeap.
		 */
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		
		if(maxHeap.size() < minHeap.size()){
			maxHeap.offer(minHeap.poll());
		}
	}
	
	public double findMedian(){
		if(maxHeap.size() == minHeap.size()){
			return (double)(maxHeap.peek() + minHeap.peek())/2;
		}else{
			return maxHeap.peek();
		}
	}
}
