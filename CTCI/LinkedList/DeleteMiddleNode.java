package LinkedList;

public class DeleteMiddleNode {
	/*
	 * The idea is to copy the value of the next element and delete the next
	 * element.
	 */
	public boolean deleteNode(ListNode n){
		if(n == null || n.next == null) return false;
		ListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return false;
	}

}
