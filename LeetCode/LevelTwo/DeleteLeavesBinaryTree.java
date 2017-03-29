package LevelTwo;
/**
 * This was one of the Visa questions on Glassdoor.
 * Verified it using the https://leetcode.com/problems/delete-node-in-a-bst/
 *
 */
public class DeleteLeavesBinaryTree {
	public TreeNode deleteLeaves(TreeNode root){
		return deleteLeafNode(root);
	}
	
	private TreeNode deleteLeafNode(TreeNode root){
		if(root == null) return null;
		
		if(root.left == null && root.right == null){
			return null;
		}else{
			root.left = deleteLeafNode(root.left);
			root.right = deleteLeafNode(root.right);
		}
		return root;
	}
}
