package TreesAndGraphs;
/*
 * Both leetcode and CTCI.
 * A tree is called balanced(in this case) when the height of the any two subtrees 
 * do not differ by more than one.
 */
public class CheckBalancedTree {
	public boolean isBalanced(TreeNode root) {
        return getHeight(root) != Integer.MIN_VALUE;
    }
    /*
     * This is a customized height method for checking balanced tree which returns
     * error whenever the diff in height is more than one in any level.
     */
    public int getHeight(TreeNode root){
        if(root == null) 
        	return -1;
        
        int leftHeight = getHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        int rightHeight = getHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        if(Math.abs(leftHeight - rightHeight) > 1){
            return Integer.MIN_VALUE;
        }
        else{
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
