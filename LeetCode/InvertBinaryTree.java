import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/articles/invert-binary-tree/


public class InvertBinaryTree {
    //Recursive approach is faster.
	public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    
    public TreeNode invertTreeIterative(TreeNode root){
    	if(root == null) return null;
    	Queue<TreeNode> queue = new LinkedList<>();    	
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		TreeNode current = queue.poll();
    		TreeNode temp = current.left;
    		current.left = current.right;
    		current.right = temp;
    		
    		if(current.left != null) queue.offer(current.left);
    		if(current.right != null) queue.offer(current.right);
    	}
    	return root;
    }
}