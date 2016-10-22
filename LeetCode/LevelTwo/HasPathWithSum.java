package LevelTwo;

import LevelOne.TreeNode;
/*
 * https://leetcode.com/problems/path-sum/
 */
public class HasPathWithSum {
	public boolean hasPathWithSum(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		
		if(root.left == null && root.right == null && root.data == sum){
			return true;
		} 
		
		return hasPathWithSum(root.left, sum - root.data) || hasPathWithSum(root.right, sum - root.data);
	}
}
