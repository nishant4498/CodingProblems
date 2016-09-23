package LevelOne;
/*
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeList {
	public void deleteNode(ListNode node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}
}
