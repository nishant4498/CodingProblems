package LevelTwo;
/**
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * 
 * The time complexity of this approach is O(n^2).
 * We can optimize this to O(n) by computing the height in the 
 * ssame call rather than calling seaparately.
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
	
	public int height(TreeNode root){
		if(root == null) return -1;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
