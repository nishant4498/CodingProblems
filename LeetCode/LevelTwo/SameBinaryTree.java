package LevelTwo;

import LevelOne.TreeNode;

public class SameBinaryTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        
        if(p == null || q == null){
            return false;
        }
        
        if(p.data != q.data) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
