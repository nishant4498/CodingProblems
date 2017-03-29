package LevelSix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * Given two arrays, write a function to compute their intersection.Each element in the result 
 * must be unique.
 * 
 * The idea is to store the elements of the first array into a HashSet and, then we add only those elements
 * from the second array that are into this set.
 *
 */
public class IntersectionOfTwoArrays {
	/**
	 * APPROACH 1 - HASH SET
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        
        int[] result = new int[set2.size()];
        int i = 0;
        for(int num : set2){
            result[i] = num;
            i++;
        }
        return result;
    }
	
	/**
	 * APPROACH 2 - SORTING - TWO POINTERS
	 */
	
	public int[] intersectionTwoPointers(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        
        int[] result = new int[set.size()];
        i = 0;
        for(int num : set){
            result[i++] = num;
        }
        return result;
    }
}
