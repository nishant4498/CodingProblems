package LevelFour;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements that appear twice in this array.
 * 
 * We utilize the fact here that the numbers are in the range 1 to n, where n is the length of the array.
 * Thus if the max element of the array is 8, the index of array will be 0-7.
 * We just set the number negative at its index e.g if we find a number two, we set the index 1(2-1) as negative.
 * Whenever we encounter two again, if check index 1, we can figure out that 2 was seen  earlier.So store it as result.
 */
public class FindAllDuplicatesArray {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> result = findDuplicates(nums);
		for(int num : result) System.out.println(num);
	}
	
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i =0; i< nums.length; i++){
        	/*
        	 * Since the numbers are in range 0-n, index will be in range 0-n-1;
        	 */
            int index = Math.abs(nums[i]) -1;
            if(nums[index] < 0){
                result.add(index + 1);
            }else{
                nums[index] = -1 * nums[index];
            }
        }
        
        return result;
    }

}
