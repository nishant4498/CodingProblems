package LevelTwo;

import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/*
 * To find the kth largest element, we need a max heap whereas for kth smallest we need a min heap.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/  
 */

public class FindKthLargestElementArray {
	
	public static int findKthLargest(int[] nums, int k) {
		Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int num : nums) {
			maxHeap.offer(num);
		}
		int result = 0;
		for (int i = 0; i < k; i++) {
			result = maxHeap.poll();
		}

		return result;
	}
	
	public static int findKthSmallest(int[] nums, int k) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int num : nums) {
			minHeap.offer(num);
		}
		int result = 0;
		for (int i = 0; i < k; i++) {
			result = minHeap.poll();
		}

		return result;
	}
	
	public static void main(String[] args){
		int[] nums = {6, 10, 67, 12, 65, 11, 8};		
		System.out.println(findKthLargest(nums, 2));
		System.out.println(findKthSmallest(nums, 2));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
