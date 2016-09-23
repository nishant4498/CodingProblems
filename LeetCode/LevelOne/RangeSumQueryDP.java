package LevelOne;
/*
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryDP {
	private int[] sum;

    public RangeSumQueryDP(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
    
	public static void main(String[] args) {
		int[] nums = { -1, 0, -2, -5, 7 };
		RangeSumQueryDP numArray = new RangeSumQueryDP(nums);
		System.out.println(numArray.sumRange(0, 1));
		System.out.println(numArray.sumRange(1, 2));
		System.out.println(numArray.sumRange(0, 4));
	}
}
