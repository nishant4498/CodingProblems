package LevelTwo;
/*
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
import LevelOne.TreeNode;

public class MinDepthBinaryTree {
	public int minDepth(TreeNode root){
		if(root == null) return 0;
		
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		
		return (left == 0 || right == 0) ? (1 + left +  right) : Math.min(left, right) + 1;
		
		/*
		 * Here we directly cant write the below since if one of the subtrees say right is null, we will get
		 * minDepth as 1(just the root) , but actually it should return minDepth on the left.
		 * return Math.min(minDepth(root.left) , minDepth(root.right)) + 1;
		 */
	}
}
