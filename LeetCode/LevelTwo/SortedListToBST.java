package LevelTwo;
/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
 *
 * Since we are given a LinkedList head node, for forming a BST we need to find the middle node every time.
 */
import LevelOne.ListNode;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head){
		if(head == null) return null;
		return convertToBST(head, null);
	}
	
	private TreeNode convertToBST(ListNode head, ListNode tail){
		if(head == tail) return null;
		
		ListNode slow = head;
		ListNode fast = head;
		
		/**
         * Its important to run loop till fast != tail(usually we compare till null since tail is null);
         */
		while(fast != tail && fast.next != tail){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode root = new TreeNode(slow.data);
		/**
		 * We don't need a previous pointer here.We directly pass slow as the last node
		 * for first half.
		 */
		root.left = convertToBST(head, slow);
		root.right = convertToBST(slow.next, tail);
		return root;
	}
}
