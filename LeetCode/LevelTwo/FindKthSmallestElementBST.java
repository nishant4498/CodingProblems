package LevelTwo;
/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * https://discuss.leetcode.com/topic/17810/3-ways-implemented-in-java-binary-search-in-order-iterative-recursive
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LevelOne.TreeNode;

public class FindKthSmallestElementBST {
	/*
	 * In a recursive way we need to either handle extra variable cases or keep the count outside.
	 * The return will become a problem.
	 */
	public int kthSmallestInorderIterative(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode top = stack.pop();
                k--;
                if(k == 0) return top.data;
                curr = top.right;
            }
        }
        return -1;
    }	
	
	/*
	 * Basically this idea gets the inorder traversal list and returns the kth element since
	 * inorder list is always sorted.
	 */
	public int kthSmallest(TreeNode root, int k){
		if(root == null) return 0;		
		List<Integer> result = new ArrayList<Integer>();
		inorderList(root, result);
		return result.get(k-1);
	}
	
	private List<Integer> inorderList(TreeNode root, List<Integer> result){
		if (root == null) return null;
		inorderList(root.left, result);
		result.add(root.data);
		inorderList(root.right, result);
		return result;
	}
}
