package LevelSeven;
/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * Here head node marks the first node in the next level.
 * 
 * We start at the root and then keep connecting the nodes at next level.
 * 
 * We use the already connected next pointer to do a level order traversal at the curr level.
 * 
 * Here we are utilizing the property that the tree is a complete binary tree.
 * 
 */
public class PopulatingNextRightPointer {
	public void connect(TreeLinkNode root){
		if(root == null) return;
		
		TreeLinkNode head = root;// First Node in lower level(which we are trying to connect)
		TreeLinkNode curr = null;// Curr node in the previous level 
		/**
		 * 
		 */
		while(head.left != null){
			curr = head;
			while(curr != null){
				curr.left.next = curr.right;
				if(curr.next != null){
					curr.right.next = curr.next.left;
				}
				curr = curr.next;
			}
			head = head.left;
		}
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}
 
