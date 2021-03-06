package LevelTwo;
/*
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * Another way this can be done is using level order traversal and taking the sum of 
 * all the first node in each level.
 */
import LevelOne.TreeNode;

public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root){
		return findSum(root, false);
	}
	
	public int findSum(TreeNode root, boolean isLeft){
		if(root == null){
			return 0;
		}
		
		if(root.left == null && root.right == null){
			return isLeft ? root.data : 0;
		}
		
		return findSum(root.left, true) + findSum(root.right, false);
	}
}
