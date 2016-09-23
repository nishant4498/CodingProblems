package LevelOne;

/*
 *  https://leetcode.com/articles/remove-element/ 
 *  Also Refer RemoveDuplicatesSortedArray.
 */
public class RemoveElementArray {

	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		int val = 3;
		System.out.println(removeElement(nums, val));
	}
	
	/*
	 * The whole idea is to use the point that the order of elements in the
	 * arrays can be changed. So just keep copying the last element in the ith
	 * position if get the given value.
	 */
	
	/*
	 * One important point to keep in mind is that we dont increment the value of i when we get the 
	 * number at pos i equal to val. The reason for this is the number that we copied from the end 
	 * might also be euqal to val and thus we need to check that as well.
	 */
	public static int removeElement(int[] nums, int val) {
        int count = nums.length;
        int i = 0;
        while( i < count){
            if(nums[i] == val){
                nums[i] = nums[count - 1];
                count--;
                // Dont increment i to check the copied number from end again.
            }else{
                i++;
            }
        }        
        return count;
    }

}
