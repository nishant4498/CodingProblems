package LevelSix;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java
 * 
 * The idea here is very simple - For every histogram 'X' we compute the area with 'X' as the smallest bar in the 
 * rectangle.If we compute such area for every bar X, and find the maximum of all such areas, our task is done.
 * 
 * Maintain a stack
 * 
 * If stack is empty or value at index of stack is less than or equal to value at current 
 * index, push this into stack.
 * 
 * Otherwise keep removing values from stack till value at index at top of stack is 
 * less than value at current index.
 * 
 * While removing value from stack calculate area
 * 		- If stack is empty it means that till this point value just removed has to be smallest element
 * 		  So area = input[top] * i
 *      
 *      - If stack is not empty then this value at index top is less than or equal to 
 * 		  everything from stack top + 1 till i. 
 * 		  So area = input[top] * (i - stack.peek() - 1);
 * 
 * Finally maxArea is area if area is greater than maxArea.
 * 
 * Time complexity is O(n)
 * Space complexity is O(n)
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<>();
		
		int area = 0, maxArea = 0, i = 0;
		
		while(i < heights.length){
			if(s.isEmpty() || heights[s.peek()] <= heights[i]){
				s.push(i++);
			}else{
				int top = s.pop();
				
				area = heights[top] * (s.isEmpty()? i : (i - s.peek() - 1));				
				
				maxArea = Math.max(area, maxArea);
			}
		}
		
		while (!s.isEmpty()) {
			int top = s.pop();
			
			area = heights[top] * (s.isEmpty()? i : (i - s.peek() - 1));
			
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;
	}
}
