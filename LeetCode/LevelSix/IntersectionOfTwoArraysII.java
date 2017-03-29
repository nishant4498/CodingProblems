package LevelSix;
/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * Basically we add the count of elements of one of the arrays into a map.
 * Then we iterate through the second array and whenever we get an element which is there
 * in the map, we add to the list.
 * Then we decrease the count of that element in the map.
 * 
 * It is important to check that the count of element in the map > 0 as we are not removing from the map.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }else{
                map.put(nums1[i], 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        
        int[] result = new int[list.size()];
        int i = 0;
        for(int num : list){
            result[i++] = num;
        }
        
        return result;
    }
}
