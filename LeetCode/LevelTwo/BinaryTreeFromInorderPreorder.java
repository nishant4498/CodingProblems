package LevelTwo;

import LevelOne.TreeNode;

public class BinaryTreeFromInorderPreorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length != preorder.length) return null;
        
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int pos = inStart;
		
		/*
		 * The less than is important.It should not be <=
		 */
		for(;pos < inEnd ; pos++){
			if(inorder[pos] == preorder[preStart]){
				break;
			}
		}
		
		int offset = pos - inStart;
        
        root.left = buildTree(preorder, preStart + 1, preStart + offset, inorder, inStart, inStart + offset -1);
        root.right = buildTree(preorder, preStart + offset + 1, preEnd, inorder, inStart + offset + 1,inEnd);
        return root;
        
    }
}
