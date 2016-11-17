package LevelFour;
/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 * First create a hash map with the count for each number.
 * Then we create a min heap of size k sorted based on the frequency of numbers.
 * The final numbers in the heap will be top k frequent numbers.
 * NOTE: The top element in the heap will be the one with least frequency amongst top k since its a min- heap.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		List<Integer> result = topKFrequent(nums, k);
		for(int res : result){
			System.out.println(res);
		}
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<NumberWrapper> pq = new PriorityQueue<>();
        
        for(int num : nums){
        	if(countMap.containsKey(num)){
        		countMap.put(num, countMap.get(num) + 1);
        	}else{
        		countMap.put(num, 1);
        	}
        }
        
        for(Integer num : countMap.keySet()){
        	NumberWrapper nw = new NumberWrapper(num, countMap.get(num));
        	pq.add(nw);
        	if(pq.size() > k){
        		pq.poll();
        	}
        }
        /*
         * It is important to add in the beginning since we are creating a min-heap to keep top 
         * k largest elements. Thus in the end we will have top k elements in the heap but amongs those
         * smallest frequency one will be in the top.
         * Since we want the result in the order of decreasing frequency we will have to add in the beginning.
         */
        for(NumberWrapper nw : pq){
        	result.add(0,nw.num);
        }
        
        return result;
    }
}

class NumberWrapper implements Comparable<NumberWrapper>{
	public int num;
	public int count;
	
	public NumberWrapper(int num, int count){
		this.num = num;
		this.count = count;
	}
	
	@Override
	public int compareTo(NumberWrapper o){
		return (this.count - o.count);
	}
	
}
