package LevelTwo;

import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/*
 * To find the kth largest element, we need a min heap whereas for kth smallest we need a max heap.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/  
 */

public class FindKthLargestElementArray {	
	/*
	 * Here we maintain a Min Heap of size k, so that we keep the k largest
	 * elements in the heap.Whenever the size is k+1 we rove the top, which basically removes
	 * the minimum element.
	 */
	public static int findKthLargest(int[] nums, int k) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int num : nums) {
			minHeap.offer(num);
			if(minHeap.size() > k){
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}
	/*
	 * We keep a max heap of size k and keep removing the larger elements leaving behind
	 * the smallest k elements in the heap.
	 */
	public static int findKthSmallest(int[] nums, int k) {
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int num : nums) {
			maxHeap.offer(num);
			
			if(maxHeap.size() > k){
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}
	
	public static void main(String[] args){
		int[] nums = {6, 10, 67, 12, 65, 11, 8};		
		System.out.println(findKthLargest(nums, 3));
		System.out.println(findKthSmallest(nums, 3));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
