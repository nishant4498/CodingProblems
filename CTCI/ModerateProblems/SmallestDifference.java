package ModerateProblems;

import java.util.Arrays;

/**
 * Given two arrays find the pair that gives the smallest difference.Both the elements should 
 * belong to two arrays.
 * 
 * Brute force - O(mm)
 * Optimal - Sort the arrays. keep checking the difference. Every time move the index for the 
 * array whose elemnt is smaller.
 *
 */
public class SmallestDifference {
	public static int findDifference(int[] array1, int[] array2){
		if(array1.length == 0 || array2.length == 0) return -1;
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int i = 0;
		int j = 0;
		
		int diff = Integer.MAX_VALUE;
		
		while(i < array1.length && j < array2.length){
			diff = Math.min(Math.abs(array1[i] - array2[j]), diff);
			
			if(array1[i] > array2[j]){
				j++;
			}else{
				i++;
			}
		}
		
		return diff;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1,3,15,11,2};
		int[] array2 = {23,127,235,19,8};
		
		System.out.println(findDifference(array1, array2));
		
		array1 = new int[]{1,2,11,15,235};
		array2 = new int[]{4,12,19,23,127,235};
		
		System.out.println(findDifference(array1, array2));
		
	}
}
