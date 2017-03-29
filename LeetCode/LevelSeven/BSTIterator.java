package LevelSeven;

import java.util.Stack;

import LevelOne.TreeNode;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * Here we need to implement a binary serach tree iterator which can support the following methods:
 * 
 * 	- hasNext()
 *  - next() - Returns the next smallest element.
 *  
 *  This is basically redesigning the inorder traversal of the BST which gives the elements in
 *  the ascending order.
 *  
 *  To initalize the data-stucture we initially push all the elements starting from root.
 *  When ever we pop an element using next() function we push its right child if it's not null.
 */
public class BSTIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		pushNodes(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode temp = stack.pop();
		if (temp.right != null) {
			pushNodes(temp.right);// Its important to note that we just do not only push the right child
		}                         // but also push its left children.
		return temp.data;
	}

	public void pushNodes(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
}
