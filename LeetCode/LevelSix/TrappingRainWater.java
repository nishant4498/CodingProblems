package LevelSix;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * CTCI 17.21 Volume of hisogram
 * 
 * SOLUTION 1: Similar to the LargestRectangleInHistogram
 * https://discuss.leetcode.com/topic/4939/a-stack-based-solution-for-reference-inspired-by-histogram/2
 * 
 * Here we keep pushing the index in the stack if either the stack is empty or the bars are in
 * decreasing order. 
 * 
 * a) For computing the water tapped bw two bars we, take the minimum of the height at curr position(i)
 *    and height of element at the top of stack, since max water held will be decided by the smaller bar.
 * b) Then we substract it from the height just popped out and multiply with the diff in positions.
 * 
 * SOLUTION 2
 * https://discuss.leetcode.com/topic/5125/sharing-my-simple-c-code-o-n-time-o-1-space
 * 
 */
public class TrappingRainWater {
	/**
	 * Solution 1 : Stack based
	 */
	public int trap(int[] height){
		if(height.length <= 2) return 0;
		
		Stack<Integer> s = new Stack<>();
		
		int i = 0 , maxWater = 0;
		
		while(i < height.length){
			if(s.isEmpty() || height[i] <= height[s.peek()]){// Push in decreasing order
				s.push(i++);
			}else{
				int top = s.pop();
				if(!s.isEmpty()){
					int min = Math.min(height[i], height[s.peek()]);
					int diff = min - height[top];
					maxWater += diff * (i - s.peek() - 1);
				}				
			}
		}
		return maxWater;
	}
	
	/**
	 * Solution 2 - TWO POINTERS
	 * 
	 * Search from left to right and maintain a max height of left and right separately, which is like 
	 * a one-side wall of partial container. Fix the higher one and flow water from the lower part. 
	 * For example, if current height of left is lower, we fill water in the left bin. 
	 * Until left meets right, we filled the whole container.
	 * 
	 */
	
	public int trapTwoPointers(int[] height) {
		int left = 0, right = height.length - 1;
		int maxLeft = 0, maxRight = 0, result = 0;

		while (left <= right) {
			if (height[left] <= height[right]) {
				if (height[left] >= maxLeft) {
					maxLeft = height[left];
				} else {
					result += maxLeft - height[left];
				}
				left++;
			} else {
				if (height[right] >= maxRight) {
					maxRight = height[right];
				} else {
					result += maxRight - height[right];
				}
				right--;
			}
		}

		return result;
	}
}
