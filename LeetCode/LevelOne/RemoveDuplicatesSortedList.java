package LevelOne;
/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesSortedList {
	
	public ListNode deleteDuplicates(ListNode head) {
	    ListNode current = head;
	    while (current != null && current.next != null) {
	        if (current.next.data == current.data) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}
}

