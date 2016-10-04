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

	public void addNum(int num) {
		/*
		 * Intially add the number to the maxHeap and then pop it and put in the
		 * minHeap. The size of maxHeap should always be equal to or one more
		 * than minHeap.
		 */
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());

		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}
	/*
	 * This method is faster since in the above method we do more operations on the heap for each insert.
	 */
	public void addNumFaster(int num) {
		if (maxHeap.size() == minHeap.size()) {// size of maxHeap will increase
			if (minHeap.peek() != null && num > minHeap.peek()) {
				// Since number on the top of minHeap is smaller,it goes to the maxHeap
				maxHeap.offer(minHeap.poll());												
				minHeap.offer(num);
			} else {// either minHeap is empty or the number is smaller
				maxHeap.offer(num);
			}
		} else {//size of minHeap will increase.
			if (num < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(num);
			} else {
				minHeap.offer(num);
			}
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		} else {
			return maxHeap.peek();
		}
	}
}
