package LevelSix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number/
 * https://discuss.leetcode.com/topic/8018/my-java-solution-to-share
 * 
 * Given a list of non negative integers, arrange them such that they form the
 * largest number. For example, given [3, 30, 34, 5, 9], the largest formed
 * number is 9534330.
 * 
 * The idea here is to copy the nums into a string array and then use a
 * comparator to sort the string array into descending order.
 * 
 * String s1 = "9"; 
 * String s2 = "31";
 * 
 * String a = s1 + s2; // 931 
 * String b = s2 + s1; // 319
 */
public class LargestNumber {
	public static String largestNumber(int[] nums) {
		 String[] sNums = new String[nums.length];
	        
	        for(int i = 0; i < nums.length; i++){
	            sNums[i] = String.valueOf(nums[i]);
	        }
	        
	        Comparator<String> comp = new Comparator<String>(){
	            @Override
	            public int compare(String s1, String s2){
	                String a = s1 + s2;
	                String b = s2 + s1;
	                /**
					 * This step is to basically sort in descending order, bcoz that is how we have to append.
					 */
	                return b.compareTo(a);
	            }
	        };
	        
	        Arrays.sort(sNums, comp);
	        System.out.println(Arrays.toString(sNums));
	        
	        if(sNums[0].charAt(0) == '0') return "0";
	        
	        StringBuilder sb = new StringBuilder();
	        
	        for(String s : sNums){
	            sb.append(s);
	        }
	        return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		largestNumber(nums);
	}
}
