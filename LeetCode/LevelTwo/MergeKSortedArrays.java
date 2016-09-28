package LevelTwo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrays {
	
	public static int[] mergeKSortedArrays(int[][] arrs){
		Queue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int totalElements = 0;
		/*
		 * Even if we add all the arrays, time complexity will be still O(k), since there are only k arrays
		 * added in the heap.The space complexity of the heap will be O(n). As it stores all the elements.
		 */
		for(int[] arr : arrs){
			queue.add(new ArrayContainer(arr, 0));
			totalElements = totalElements + arr.length;
		}
		int[] result = new int[totalElements];
		int resultIndex = 0;
		
		while(!queue.isEmpty()){
			ArrayContainer min = queue.poll();
			result[resultIndex++] = min.arr[min.index];
			
			if(min.index < min.arr.length -1){
				queue.add(new ArrayContainer(min.arr, min.index + 1 ));
			}			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10,11,12};
 
		int[] result = mergeKSortedArrays(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}
	
}
/*
 * Comparator and Comparable are two different interfaces in Java to implement PQ.
 * Comparable is used when we are overiding the compareTo method in the class itself.
 * Comparator is used whenever we directly want to compare with some object and dont have to modify the class.
 */
class ArrayContainer implements Comparable<ArrayContainer>{
	int[] arr;
	int index;
	
	public ArrayContainer(int[] arr, int index){
		this.arr = arr;
		this.index = index;
	}
	
	@Override
	public int compareTo(ArrayContainer o) {
		return this.arr[this.index] - o.arr[o.index];
	}
}


