package LevelSeven;
/**
 * https://leetcode.com/problems/sort-colors/
 * 
 * 1) One of the easy methods is to count the number of 0's, 1's, 2's in one pass and then
 *    place them in order in the array in second pass.
 */
public class SortColors {
	/**
	 * In this method, basically we copy the 2's to the end and 0's to the beginning.
	 * 1's remain in the middle.
	 */
	public void sortColors(int[] nums) {
        int begin = 0, end = nums.length -1;
        
        for(int i  = 0; i <= end; i++){
        	// We need this method since we can copy 2 at position i, we need to keep pushing it to the right.
            while(nums[i] == 2 && i < end){
                // We are swapping here. Don't need a temp variable since we know nums[i] = 2;
            	nums[i] = nums[end];
                nums[end] = 2;
                end--;
            }
            
            while(nums[i] == 0 && i > begin){
                nums[i] = nums[begin];
                nums[begin] = 0;
                begin++;
            }
        }
    }
	
	
	public void sortColorsTwoPass(int[] nums) {
        int countRed = 0 , countWhite = 0, countBlue = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countRed++;
            }else if(nums[i] == 1){
                countWhite++;
            }else if(nums[i] == 2){
                countBlue++;
            }
        }
        
        int k = 0;
        
        while(countRed != 0){
            nums[k] = 0;
            k++;
            countRed--;
        }
        
        while(countWhite != 0){
            nums[k] = 1;
            k++;
            countWhite--;
        }
        
        while(countBlue != 0){
            nums[k] = 2;
            k++;
            countBlue--;
        }
    }
}
