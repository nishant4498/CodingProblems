package LevelTwo;
/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * The maximum depth is the number of nodes along the longest path from the root node 
 * down to the farthest leaf node.This is the reason why we return 0 instead of -1 as
 * compared to height.
 */
import LevelOne.TreeNode;

public class MaxDepthBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
