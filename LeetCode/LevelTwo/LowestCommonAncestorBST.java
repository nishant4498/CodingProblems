package LevelTwo;
/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * The diff between LCA of a binary tree and BST is - in BST we can use the property that left is
 * less than euqal to root and right is greater than equal to root.
 */
public class LowestCommonAncestorBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || root == p || root == q) return root;
		
		if((p.data <= root.data && q.data > root.data) || (q.data <= root.data && p.data > root.data)){
			return root;
		}else if(p.data > root.data){
			return lowestCommonAncestor(root.right, p, q);
		}else{
			return lowestCommonAncestor(root.left, p, q);
		}
	}
}
