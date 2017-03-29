package Level8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode Locked
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * 
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * Basically the idea is as follows:
 * 
 * 1) We maintain a sum variable that holds the sum of elements in the window.
 * 2) If the current window size is less than maximum size, we return the sum/current size.
 * 3) If the size is equal to window size, it means that we need to remove one element.
 * 4) Thus we add the current number and substract the element in the front of queue.
 *
 */
public class MovingAverageFromDataStream {
	Queue<Integer> queue = new LinkedList<>();
    int size;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        sum += val; // Add the incoming number to the current sum.
        if(queue.size() == size){
          sum -= queue.poll();// Substract the outgoing number.
        }
        queue.offer(val);
        
        /**
         * If elements are less than the window size, we divide with the current count.
         */
        return (double)(sum * 1.0 / Math.min(size, queue.size()));
    }
}
