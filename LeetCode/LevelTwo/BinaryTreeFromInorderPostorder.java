package LevelTwo;
/*
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
import LevelOne.TreeNode;

public class BinaryTreeFromInorderPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null || postorder.length == 0 || inorder.length != postorder.length)
			return null;
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;

		TreeNode root = new TreeNode(postorder[postEnd]);

		int pos = inStart;

		for (; pos < inEnd; pos++) {
			if (inorder[pos] == postorder[postEnd]) {
				break;
			}
		}

		int offset = pos - inStart;

		root.left = buildTree(inorder, inStart, inStart + offset - 1, postorder, postStart, postStart + offset - 1);
		root.right = buildTree(inorder, inStart + offset + 1, inEnd, postorder, postStart + offset, postEnd - 1);

		return root;
	}
}
