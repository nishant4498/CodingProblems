package LevelTwo;
/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * We are given that the binary tree is complete(In a complete binary tree every level, 
 * except possibly the last, is completely filled, and all nodes in the last level are as 
 * far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.).
 * Complexity log(n) * log(n)
 * It first walks all the way left and right to determine the height and whether it's a full tree, 
 * meaning the last row is full. If so, then the answer is just 2^height-1. 
 * And since always at least one of the two recursive calls is such a full tree, 
 * at least one of the two calls immediately stops. Again we have runtime O(log(n)^2).
 * 
 * Basically its a kind of binary search.
 */
import LevelOne.TreeNode;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		/**
		 * This is important since, in general when we compute height we return
		 * -1.
		 */
		if (root == null)
			return 0;
		int leftHeight = getLeftHeight(root);
		int rightHeight = getRightHeight(root);

		/*
		 * We do a left shift of one less than h, since 2 << h = 2 * pow(2,h)
		 * thus 2 << 1 = 4. This needs to be taken carefully.
		 */
		if (leftHeight == rightHeight) {
			/**
			 * Math.pow(2,h) -1 - Problem with this it needs double as parameter
			 * and returns double (2 << h-1) - 1
			 */
			return (1 << leftHeight) - 1;
		} else {
			return 1 + countNodes(root.left) + countNodes(root.right);
		}
	}
	    
	public int getLeftHeight(TreeNode node) {
		if (node == null)
			return 0;
		TreeNode curr = node;
		int height = 0;

		while (curr != null) {
			curr = curr.left;
			height++;
		}
		return height;
	}

	public int getRightHeight(TreeNode node) {
		if (node == null)
			return 0;
		TreeNode curr = node;
		int height = 0;

		while (curr != null) {
			curr = curr.right;
			height++;
		}
		return height;
	}
}
