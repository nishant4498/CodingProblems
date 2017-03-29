package LevelSeven;
/**
 * https://leetcode.com/problems/closest-binary-search-tree-value
 * 
 * Closest is either the root's value (a) or the closest in the appropriate subtree (b).
 * 
 * This can also be done iteratively by taking note of the previous and next values of the target.
 */
import LevelOne.TreeNode;

public class ClosestBSTValue {
	public int closestValue(TreeNode root, double target){
		int a = root.data;
		TreeNode child = target < a ? root.left : root.right;
		if(child == null) return a;
		int b = closestValue(child, target);
		return Math.abs(a - target) < Math.abs(b - target) ? a : b;
	}
}
