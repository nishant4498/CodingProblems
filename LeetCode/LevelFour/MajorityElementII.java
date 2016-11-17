package LevelFour;
/*
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * In this problem we need to find elements which appear more tha n/3 times. As we can easily see,
 * there can only be two such majority elements.
 * Thus this is a simple extension to the majority element problem but we need to keep track of two pointers
 * for the two elements. 
 */
import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int c1 = 0, c2 =0;
        Integer n1 = null, n2 = null;
        
        for(int num : nums){
            if(n1 != null && num == n1){
                c1++;
            }else if(n2 != null && num == n2){
                c2++;
            }else if(c1 == 0){
                n1 = num;
                c1++;
            }else if(c2 == 0){
                n2 = num;
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        
        if(c1 > 0){
            int count = 0;
            for(int num : nums){
                if(num == n1){
                    count++;
                }
            }
            if(count > nums.length/3){
                result.add(n1);
            }
        }
        
        if(c2 > 0){
            int count = 0;
            for(int num : nums){
                if(num == n2){
                    count++;
                }
            }
            if(count > nums.length/3){
                result.add(n2);
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {1};
		List<Integer> result = majorityElement(nums);
		for(int num : result){
			System.out.println(num);
		}
	}
}
