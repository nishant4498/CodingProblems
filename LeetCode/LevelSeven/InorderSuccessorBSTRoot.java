package LevelSeven;

import java.util.Stack;

import LevelOne.TreeNode;

/**
 * Leetcode locked.
 * 
 * In this problem we are given the root and a node, so it is not so diffuclt and we don't need parent
 * pointer as in CTCI.
 * 
 * The idea is to perform an inorder traversal of the BST and mark the flag when we pop the 
 * given node out of stack.
 * 
 * The succesor will be the next node to be popped out.
 * 
 */
public class InorderSuccessorBSTRoot {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> s = new Stack<>();
        if(root == null || p == null) return p;
        
        TreeNode curr = root;
        boolean found = false;
        
        while(curr != null || !s.isEmpty()){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = s.pop();
                /**
                 * If we previously found p, then the next node popped will be its successor.
                 */
                if(found){
                    return temp;
                }
                if(temp.data == p.data){
                    found = true;
                }
                curr = temp.right;
            }
        }
        return null;
    }
}
