package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Design an algorithm to create a Linked List of all the nodes at each level in the tree.
 */
public class ListOfDepths {
	
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> current = new LinkedList<>();
		if(root != null){
			current.add(root);
		}
		
		while(!current.isEmpty()){
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			
			for(TreeNode parent : parents){
				if(parent.left != null){
					current.add(parent.left);
				}
				if(parent.right != null){
					current.add(parent.right);
				}
			}
		}
		
		return result;
		
	}
}
