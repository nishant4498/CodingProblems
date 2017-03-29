package LevelSeven;

import java.util.LinkedList;
import java.util.Queue;

import LevelOne.TreeNode;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * 
 * Basic level order traversal for tree.
 * 
 * Basically we need to keep the value of first node in the queue for each level as the result.
 *
 */
public class BottomLeftTreeValue {
	 public int findBottomLeftValue(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<>();
	        
	        queue.add(root);
	        int result = 0;
	        
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            
	            for(int i = 0; i < size; i++){
	                TreeNode curr = queue.poll();
	                
	                if(i == 0) result = curr.data;// Store the first left value in result.
	                
	                if(curr.left != null){
	                    queue.offer(curr.left);
	                }
	                
	                if(curr.right != null){
	                    queue.offer(curr.right);
	                }
	            }
	        }
	        
	        return result;
	    }
}
