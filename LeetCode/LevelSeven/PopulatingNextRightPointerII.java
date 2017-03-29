package LevelSeven;
import LevelSeven.TreeLinkNode;
/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Basically here we need to check the left and right elements at each level if they are null or not.
 * 
 * We keep three pointers:
 * 
 * 1) For each level 
 * 			- we store the head node, i.e the starting node for that level.
 *          - We store a prev node so that we can connect it to the next node.
 * 2) We store the curr node being traversed in the previous level
 *
 */
public class PopulatingNextRightPointerII {
	public void connect(TreeLinkNode root){
		if(root == null) return;
		
		TreeLinkNode head = root; // First node in lower level(which we are trying to connect)
		TreeLinkNode prev = null; // Previous node to be connected in the lower level to the next node.
		TreeLinkNode curr = null;
		
		while(head != null){// While there is no node in the next level
			curr = head;
			prev = null;
			head = null;
			/**
			 * Do a level order traversal on the upper level connecting the lower level nodes.
			 */
			while(curr != null){
				if(curr.left != null){
					if(prev != null){
						prev.next = curr.left;
					}else{
						head = curr.left;
					}
					prev = curr.left;/*IMPORTANT CONDITION*/
				}
				
				if(curr.right != null){
					if(prev != null){
						prev.next = curr.right;
					}else{
						head = curr.right;
					}
					prev = curr.right;
				}
				curr = curr.next;
			}
		}
	}
}
