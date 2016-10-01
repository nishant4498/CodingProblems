package LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LevelOne.TreeNode;
/*
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */ 

public class PostorderIterative {
	/*
	 * Approach one - Two stacks
	 * 1) Take two stacks. Push the root into s1.
	 * 2) Move root to s2. Push its left child to s1 and then right child to s1.
	 * 3) Repeat
	 * 4) The resulting order is contained in s2. Put all the elemnets to list.
	 */
	
	public List<Integer> postorderTraversalTwoStacks(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        s1.push(root);
        
        while(!s1.isEmpty()){
            TreeNode t = s1.pop();
            s2.push(t);
            if(t.left != null){
                s1.push(t.left);
            }
            
            if(t.right != null){
                s1.push(t.right);
            }
        }
        
        while(!s2.isEmpty()){
            result.add(s2.pop().data);
        }
        return result;
    }
	
	/*
	 * Approach 2- One Stack
	 * 1) Keep a curr pointer to track the current node(start with root).
	 * 2) If the curr is not null and has a left child, push the left child to stack.
	 * 3) If curr is null, check if the node at the top of stack has a right child.
	 * 4) If no right child pop the node and print it.
	 * 5) Then we check if the node that we popped is a right child of top node.
	 * 6) If not right child, then check if top node has a right child, then set curr to right child
	 *    of top node.
	 * 7) In case a node popped is the right child of top node , then visit the top node since both 
	 *    its left and right are visited. 
	 *    
	 *  
	 *    
	 *  Repeat the steps. 
	 */
	
	public List<Integer> postorderTraversalOneStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
             if(curr != null){
                 stack.push(curr);
                 curr = curr.left; // keep pushing till the leaf node i.e last left child.
             }else{
                 TreeNode temp = stack.peek().right;// Check the right child of top of stack.
                 if(temp == null){ // If no right child we can print the node.
                     temp = stack.pop();
                     result.add(temp.data);
                     while(!stack.isEmpty() && temp == stack.peek().right){
                         temp = stack.pop();
                         result.add(temp.data);
                     }
                 }else{
                     curr = temp; // If there is a right child, then we iterate for this child.
                 }
             }
             
        }
        return result;
    }
}
