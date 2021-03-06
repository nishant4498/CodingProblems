package LevelTwo;
/**
 * https://leetcode.com/problems/diameter-of-binary-tree
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * 
 * The time complexity of this approach is O(n^2).
 * We can optimize this to O(n) by computing the height in the 
 * same call rather than calling seaparately.
 */
import LevelOne.TreeNode;

public class DiameterOfTree {
	public int diameterTree(TreeNode root){
		if(root == null) return 0;
		
		int lHeight = height(root.left);
		int rHeight = height(root.right);
		
		int leftDiameter = diameterTree(root.left);
		int rightDiameter = diameterTree(root.right);
		
		int maxDiameter = Math.max(leftDiameter , rightDiameter);
		return Math.max(lHeight + rHeight + 3, maxDiameter);		
	}
	/**
	 * When we return -1, then height is the length of the longest path from root to leaf node.
	 * When we return 0, height is the number of nodes in the longest path from root to leaf.
	 */
	public int height(TreeNode root){
		if(root == null) return -1;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	/**
	 * Solution 2  - Using Max Depth approach
	 * https://discuss.leetcode.com/topic/83456/java-solution-maxdepth
	 */
	
	int max = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    public int maxDepth(TreeNode root){
		if(root == null) return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		max = Math.max(max, left + right);
		
		return Math.max(left, right) + 1;
	}
}
