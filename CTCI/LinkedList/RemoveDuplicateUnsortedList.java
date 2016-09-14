package LinkedList;

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
