package LevelOne;
/*
 * https://leetcode.com/articles/longest-common-prefix/
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] inputStrings = {"abcxyz" , "abcde", "abctf", "abcdefgh", "abc"};
		System.out.println(longestCommonPrefixHorizontalScan(inputStrings));
		System.out.println(longestCommonPrefixVerticalScan(inputStrings));
		System.out.println(longestCommonPrefixDivideAndConquer(inputStrings));
		System.out.println(longestCommonPrefixBinarySearch(inputStrings));
	}

	/*
	 * Approach #1 (Horizontal scanning)
	 * In this approach, we take the first string as prefix and then
	 * keep comparing it with other strings starting with the second one.Each
	 * time we update the prefix to the common string. This way we get the
	 * common of all if exists at the end.
	 */
	public static String longestCommonPrefixHorizontalScan(String[] strs) {
        if(strs.length == 0) return "";
        
        String prefix = strs[0];
        for(int i = 1; i< strs.length; i++){
        	//indexOf returns the first index of specified substring. Here since its prefix we are comparing to zero.
        	while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,  prefix.length() - 1);// The last index is exclusive.
                if(prefix == "") return "";
            }
        }
        return prefix;
    }

	/*
	 * Approach 2- Vertical 
	 * Here we take the first string and keep it matching
	 * with other strings character by character. We return the substring of the
	 * first string , whenever either there is the end of other string or there
	 * is a character mismatch.
	 * 
	 * But its overall runtime is more for all the test cases on leetcode.
	 */
	public static String longestCommonPrefixVerticalScan(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        for(int i =0; i < strs[0].length(); i++ ){
            char c = strs[0].charAt(i);
            
            for(int j = 1; j < strs.length ; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];//Return the first string when all of itsa characters match with other strings.
    }
	/*
	 * In this method we apply Divide and Conquer approach to solve the problem.
	 * We find the LCP in the left and then in the right and then compare both of them.
	 * The longest common prefix is the common prefix of the left and the right.
	 */
	public static String longestCommonPrefixDivideAndConquer(String[] strs) {
        if(strs == null || strs.length == 0) return "";        
        return longestCommonPrefix(strs , 0 , strs.length -1);        
    }
    
    private static String longestCommonPrefix(String[] strs , int left, int right){
        // Return condition always important
        if(left == right) {
            return strs[right];
        }else{
            int mid = (left + right)/2;
            String leftLCP = longestCommonPrefix(strs , left, mid);
            String rightLCP = longestCommonPrefix(strs , mid + 1, right);
            return commonPrefix(leftLCP, rightLCP);
        }        
    }
    
    private static String commonPrefix(String leftLCP,String rightLCP){
        int minLength = Math.min(leftLCP.length() , rightLCP.length());
        
        for(int i = 0; i < minLength; i++){
            if(leftLCP.charAt(i) != rightLCP.charAt(i)){
                return leftLCP.substring(0,i);
            }
        }
        
        return leftLCP.substring(0, minLength);
    }
    
    /*
     * This can also be solved using binary search.
     * 1) Find the min length of the all the strings.
     * 2) Perform a binary serach to find the prefix of the largest length in all the strings.
     */
    
    public static String longestCommonPrefixBinarySearch(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        
        int minLength = Integer.MAX_VALUE;
        for(String str : strs){
            minLength = Math.min(minLength , str.length());
        }
        
        int low = 0;
        /*
         * minLength is used to determine the initial high value for binary search.
         */
        int high = minLength;
        while(low <= high){
            int medium = (low + high)/2; // This is fine here as there cant be overflow.
            if(isCommonPrefix(strs, medium))
                low = medium + 1;
            else
                high = medium - 1;
        }
        return strs[0].substring(0, (low + high)/2);
    }
    
    
    /*
     * Checks if all the strings in the given array have a common prefix of length len.
     */
    private static boolean isCommonPrefix(String[] strs, int len){
        String prefix = strs[0].substring(0,len);
        
        for(int i = 1; i < strs.length; i++){
            if(!strs[i].startsWith(prefix))
                return false;
        }
        return true;
    }

}
