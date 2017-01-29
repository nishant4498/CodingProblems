package LevelTwo;

import LevelOne.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Both leetcode and CTCI.
 * A tree is called balanced(in this case) when the height of the any two subtrees 
 * do not differ by more than one.
 */
public class CheckBalancedTree {
	public boolean isBalanced(TreeNode root) {
		return getHeight(root) != Integer.MIN_VALUE;
	}

	/**
	 * This is a customized height method for checking balanced tree which
	 * returns error whenever the diff in height is more than one at any level.
	 */
	public int getHeight(TreeNode root) {
		if (root == null)
			return -1;

		/**
		 * Here we can't write leftHeight = 1 + getHeight(root.left), since
		 * whenever min value is returned it will get added by 1 and thus
		 * condition at line 31 will never be met. Also we dont need to check
		 * any further when we find that some node is not balanced.
		 */
		int leftHeight = getHeight(root.left);
		/**
		 * Its very important to check this condition here since , it might be
		 * possible that both left and right return min value. In this case
		 * their diff will be zero and thus we will return true when we need to
		 * return false
		 */
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightHeight = getHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		if (Math.abs(leftHeight - rightHeight) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
