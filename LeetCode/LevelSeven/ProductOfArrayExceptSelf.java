package LevelSeven;
/**
 * https://leetcode.com/problems/product-of-array-except-self
 * 
 * Return an array output such that output[i] is equal to the product of all the 
 * elements of nums except nums[i].No division needed.
 * 
 * Basically in this problem the idea is to divide into two parts:
 * 
 * At any element the product other than intself can be represented as: 
 * 		- Product of elements on its left * Product of elements on its right.
 * 
 * 1) Thus in one iteration from beginning to end we store the product till prev element in an array
 *    called result.
 * 2) The second iteration we start from right and keep multiplying each elemnt in result with
 *    product of all elements on the right.
 *    Thus result will store the product for each element except itself for the array.
 *
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums){
		int n = nums.length;
		int[] result = new int[n];
		
		result[0] = 1;
		for(int i = 1; i < n; i++){
			result[i] = result[i-1] * nums[i-1];
		}
		
		int rightProd = 1;
		
		for(int i = n-1; i >= 0; i--){
			result[i] = result[i] * rightProd;
			rightProd = rightProd * nums[i];			
		}
		
		return result;
	}
}
