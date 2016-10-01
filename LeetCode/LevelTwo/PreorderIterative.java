package LevelTwo;
/*
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Time Complexity O(n)- Since we visit all the elements 
 * Space Complexity = O(logn) - At max there will be elements equal to the height of the tree in Stack.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import TreesAndGraphs.TreeNode;
/*
 * Push the root in the stack. 
 * Pop it and push the right child first.
 * Then push the left child.
 * Repeat until stack is empty.
 */
public class PreorderIterative {
	public List<Integer> preOrderIterative(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root == null) return result;
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode t = stack.pop();
			result.add(t.data);
			
			if(t.right != null){
				stack.push(t.right);
			}
			
			if(t.left != null){
				stack.push(t.left);
			}
		}
		
		return result;
	}
}
