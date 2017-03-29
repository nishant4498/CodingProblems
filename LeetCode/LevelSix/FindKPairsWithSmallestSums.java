package LevelSix;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 * 
 * Similar to KthSmallestElementSortedMatrix Solution 2.
 * 
 * - We have to basically return the k pairs with smallest sums.
 * - For two arrays of size m and n, the number of pairs will be m * n.
 * - Similar to KthSmallestElementSortedMatrix, we add the second array elemnts with sum of 
 *   first element of array 1 to a min heap.
 * - Then we keep removing the top tuple and add to the result.
 * - To add the next element in the heap, we add the sum of next index element from array 1.
 * 
 *  WE CAN INTERCHANGE ANY ARRAY FOR PUTTING FIRST INTO THE HEAP.
 *
 */
public class FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Queue<Tuple> pq = new PriorityQueue<>();
        int m = nums1.length, n = nums2.length;
        
        List<int[]> result = new ArrayList<>();
        
        if(m == 0 || n == 0 || k <= 0) return result;
        
        /**
         * We add sum of number to the tuple as value.
         * 
         * Here we add to the PQ Tuple(0,0,val) , Tuple(0,1,val)...Tuple(0, n-1, val)
         * 
         * After that we try to increment i in the next round to get all the possible combinations.
         */
        for(int j = 0; j < n; j++) pq.add(new Tuple(0, j, nums1[0] + nums2[j]));
        
        for(int i = 0; i < Math.min(k, m * n);i++){
            Tuple top = pq.poll();
            
            result.add(new int[]{nums1[top.x], nums2[top.y]});
            
            if(top.x == m -1) continue;
            pq.add(new Tuple(top.x + 1, top.y, nums1[top.x + 1] + nums2[top.y]));
        }
        
        return result;
	}
}

/**
 * class Tuple is defined in KthSmallestElementSortedMatrix
 */

