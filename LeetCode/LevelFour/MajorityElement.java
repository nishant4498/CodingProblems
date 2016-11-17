package LevelFour;
/*
 * CTCI - 17.10
 * https://leetcode.com/problems/majority-element/
 * 
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
 * 
 * The idea here is to keep a counter and keep incrementing it whenever we see the same element.
 * If the element if=s diiferent we decrement the counter.
 * When the counter becomes zero, we set the next element as majority element. 
 */
public class MajorityElement {
	public int majorityElement(int[] nums){
		if(nums == null || nums.length == 0) return -1;
		
		int count = 0;
		int majority = 0;
		
		for(int num : nums){
			if(count == 0){
				majority = num;
			}
			if(num == majority){
				count++;
			}else{
				count--;
			}
		}
		
		return majority;
		/*
		 * If we need to validate as well whether the result found is actual majority or not, we can call
		 * the validate function with just this number.
		 */
	}
	
	public boolean validate(int[] nums, int majority){
		int count = 0;
		for(int num : nums){
			if(num == majority){
				count++;
			}
		}
		
		return count > nums.length/2;
	}
}
