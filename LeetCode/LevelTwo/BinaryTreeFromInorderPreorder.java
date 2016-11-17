package LevelTwo;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
import LevelOne.TreeNode;

public class BinaryTreeFromInorderPreorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length != preorder.length)
			return null;

		return buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);

	}

	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
		if (preStart > preEnd || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		int pos = inStart;

		// Find the position of the root elemnet in the inOrder array.
		// The less than is important.It should not be <=
		for (; pos < inEnd; pos++) {
			if (inorder[pos] == preorder[preStart]) {
				break;
			}
		}

		int offset = pos - inStart;

		root.left = buildTree(inorder, inStart, inStart + offset - 1, preorder, preStart + 1, preStart + offset);
		root.right = buildTree(inorder, inStart + offset + 1, inEnd, preorder, preStart + offset + 1, preEnd);
		return root;

	}
}
