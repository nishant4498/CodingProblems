package Locked;

import LevelOne.TreeNode;

/*
 * If the Node has right child then the Succesor will be found on the left most child of right 
 * subtree.
 * 
 * If there is no right child, then we need to go up until we are on the left branch.The node on whose 
 * left branch we will be , is the succesor. This is because Inorder = LNR. So now we have traversed the 
 * Left and we are the Node. So Node will be the succesor.
 */
public class InorderSuccesorBST {
	
	/*
	 * This is assuming that we have already reached that Node and we have the
	 * pointers to the parent node.
	 */
	public TreeNode inorderSuccesor(TreeNode node){
		if(node == null){
			return null;
		}
		if(node.right != null){
			return leftMostChild(node.right);
		}else{
			// Go up until we are on the left branch instead of right.
			TreeNode curr = node;
			TreeNode parnt = curr.parent;
			
			while(parnt!= null && parnt.left != curr){
				curr = parnt;
				parnt = curr.parent;
			}
			return parnt;
		}
	}
	
	public TreeNode leftMostChild(TreeNode node){
		if(node == null) return null;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
}
