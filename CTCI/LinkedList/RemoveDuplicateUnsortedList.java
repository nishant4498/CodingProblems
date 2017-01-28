package LinkedList;
/*
 * From an unsorted list we need to remove the duplicate elements.
 * 
 * As a followup its given if we can do this without extra space. In that case, for every element 
 * we need to check the list and then remove that element. O(n^2);
 */
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateUnsortedList {
	public ListNode removeduplicates(ListNode head){
		if(head == null || head.next == null) return head;
		
		ListNode curr = head;
		ListNode prev = null;
		
		Set<Integer> nodeList = new HashSet<>();
		while(curr != null){
			if(nodeList.contains(curr.data)){
				prev.next = curr.next;
			}else{
				nodeList.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
		}		
		return head;
	}
}

class ListNode {
	int data;
	ListNode next;

	ListNode(int x) {
		data = x;
	}
}
