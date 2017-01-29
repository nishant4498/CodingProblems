package LevelTwo;

import LevelOne.TreeNode;
/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * CTCI 4.2
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return createMinimalBST(nums,0, nums.length-1);
    }
	
	public TreeNode createMinimalBST(int[] nums,int start, int end){
		if(start > end){
			return null;
		}
		
		int mid = start + (end - start)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = createMinimalBST(nums, start, mid -1);
		node.right = createMinimalBST(nums, mid + 1, end);
		return node;
	}
}
