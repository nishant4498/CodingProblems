package LevelTwo;
/**
 *  https://leetcode.com/problems/delete-node-in-a-bst/
 *	http://quiz.geeksforgeeks.org/binary-search-tree-set-2-delete/
 *
 *  The idea to delete a node in BST is as follows:
 *  
 *  1) First, we try to find the node in the BST using the BST property.
 *  2) Then to delete the node there are three conditions
 *     a) No left child - Return right child.
 *     b) No right child - Return the left child.
 *     c) No child - Return null(We do not put extra condition for this. Included in the first)
 *     d) In case both the child are there, we find the inorder succesor - i.e the smallest
 *        child in the right hand side and copy that value in the root.
 *     e) Then we delete that node from the right subtree.
 */
public class DeleteNodeBST {
	public TreeNode deleteNode(TreeNode root, int key){
		if(root == null) return null;
		
		if(key < root.data){
			deleteNode(root.left, key);
		}else if(key > root.data){
			deleteNode(root.right, key);
		}else{
			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}
			
			TreeNode minNode = findMinNode(root.right);
			root.data = minNode.data;
			deleteNode(root.right, root.data);
		}
		return root;
	}
	
	public TreeNode findMinNode(TreeNode node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
}
