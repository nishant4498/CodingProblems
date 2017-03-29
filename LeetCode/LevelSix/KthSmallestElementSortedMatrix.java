package LevelSix;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code
 * 
 * SOLUTION 1 HEAP:   One of the easiest solution in such cases is using a heap.
 * 					- Since we need kth smallest element, we will need a max heap of size k.
 *                  - Whenever the heap size grows beyond k, we remove the top element.
 *                  - Thus at the end we will be left with k smallest elements in the heap,
 *                    with the largest amongst them on the top.
 *                    
 * SOLUTION 2: HEAP 2
 *           - Here we use heap but we also use the property of the sorted array.
 *           - Here we first add the first column into the min heap.
 *           - Then we remove k-1 elements from the heap.To add the next element we add the element
 *             from the next row of the current element(if row count < n)
 *             
 * SOLUTION 3: BINARY SEARCH
 *         - In this solution basically:
 *         - Start with low = first element, high = last element.
 *         - For each mid, we compute the number of elements less than mid.
 *         - For this we take each row and column from the end and keep decrementing the column,
 *           since its in ascending order.
 *         - If count < k, it means we need to look for more elements greater than mid,
 *           thus set low = mid + 1
 *           else set, high = mid. 
 *             
 *             
 * 
 *
 */
public class KthSmallestElementSortedMatrix {
	/**
	 * HEAP-1
	 */
	public int kthSmallestHeap(int[][] matrix, int k) {
		int n = matrix.length;
		if (n == 0) return 0;
		
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				pq.add(matrix[i][j]);
				if (pq.size() > k)
					pq.poll();
			}
		}
		return pq.peek();
	}
	
	/**
	 * HEAP-2 - Similar to merge K sorted arrays.
	 * Important points
	 * 1) Min -heap
	 * 2) Add first column to heap.
	 * 3) Keep removing top k-1 elements
	 * 4) Add element from next row.
	 */
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 0) return 0;
        
        Queue<Tuple> pq = new PriorityQueue<>();
        
        for(int j = 0; j < n;j++){
            pq.add(new Tuple(0, j, matrix[0][j]));
        }
        
        for(int i = 0; i < k-1; i++){
            Tuple top = pq.poll();
            
            if(top.x == n-1) continue;
            pq.offer(new Tuple(top.x + 1, top.y, matrix[top.x + 1][top.y]));
        }
        return pq.peek().val;
    }
	
	/**
	 * 3. BINARY SEARCH
	 */
	
	public int kthSmallestBinary(int[][] matrix, int k) {
        int n = matrix.length;
        
        int l = matrix[0][0] , r = matrix[n-1][n-1] + 1;
        
        while(l < r){
            int mid = l + (r - l)/2;
            
            int count = 0, j = n-1;
            for(int i = 0; i < n; i++){
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            
            if(count < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

class Tuple implements Comparable<Tuple>{
    int x, y , val;
    
    public Tuple(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Tuple o){
        return this.val - o.val;
    }
}
