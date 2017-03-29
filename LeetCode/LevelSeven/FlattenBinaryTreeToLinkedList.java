package LevelSeven;

import java.util.Stack;

import LevelOne.TreeNode;

/**
 * 
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * 
 * Given a binary tree, we need to flaten the tree into a linked list in place.
 * 
 * If we look carefully, we have to do the following things:
 * 
 * 1) All the left child of tree will become right child.
 * 2) The right children will come after left child.
 * 
 * Thus as an intution we need to store the right child into a stack so that we can link them later.
 *
 */
public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root){
		if(root == null) return;
		
		Stack<TreeNode> s = new Stack<>();
		
		TreeNode curr = root;
		
		while(curr != null || !s.isEmpty()){
			if(curr.right != null){
				s.push(curr.right); // Store the right subtree
			}
			
			if(curr.left != null){
				curr.right = curr.left; //Move the left subtree to the right
				curr.right = null;
			}else if(!s.isEmpty()){
				curr.right = s.pop();
			}
			curr = curr.right;
		}
	}
}
