package LevelOne;
/*
 * Check whether a given tree is Binary Search Tree or not.
 * left.data <= node.data < right.data
 */
public class CheckBST {
	public long lastVistedValue = Long.MIN_VALUE;
	
	/*
	 * This method while checking the nodes inorder stores the previous node value.
	 * If current value at any level is less than previous value, we return false;
	 */
	public boolean checkBSTInorder(TreeNode root){
		if(root == null) return true;
		
		if(!checkBSTInorder(root.left)) return false;
		
		if(root.data < lastVistedValue){
			return false;
		}
		
		lastVistedValue = root.data;
		
		if(!checkBSTInorder(root.right)) return false;
		
		return true;
	}
	/*
	 * Initially the min/max range is taken as the maximum possible.
	 * After then we use the property of BST, 
	 * When we go left - Update max , as the left value cant be greater than max.
	 * When we go Right - Update min , as the right value can't be less than min.
	 */
	public boolean checkBSTMinMax(TreeNode root){
		return checkBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE);
	}
	
	private boolean checkBST(TreeNode node, Integer minValue, Integer maxValue){
		if(node == null) return true;
		
		if(node.data <= minValue || node.data > maxValue) return false;
		
		return checkBST(node.left, minValue, node.data) && checkBST(node, node.data, maxValue);
	}
}
