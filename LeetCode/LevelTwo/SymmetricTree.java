package LevelTwo;
/* https://leetcode.com/problems/symmetric-tree/
 * Checks if a given tree is symmtric or not.
 * Basically it checks whether the tree is a mirror of itself or not.
 */
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMirror(root.left, root.right);
	}

	public boolean isMirror(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}

}
