package LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LevelOne.TreeNode;
/*
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Time Complexity O(n)- Since we visit all the elements 
 * Space Complexity = O(logn) - At max there will be elements equal to the height of the tree in Stack.
 * The idea is to do the following:
 * 1) Push the root to the stack.
 * 2) Keep pushing the left child until null is reached.
 * 3) Then at each level we , pop the top node, add its data to result.
 * 4) Add right child to stack if its not null, else pop another element.
 */
public class InorderIterative {
	public List<Integer> inOrderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode curr = root;
		
		while(!stack.isEmpty() || curr != null){
			if(curr != null){
				stack.push(curr);
				curr = curr.left;
			}else{
				TreeNode t = stack.pop();
				result.add(t.data);
				curr = t.right;
			}
		}	
		
		return result;
	}
}
