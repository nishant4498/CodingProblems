package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateUnsortedList {
	public ListNode removeduplicates(ListNode head){
		ListNode curr = head;
		ListNode prev = null;
		
		Set<Integer> nodeList = new HashSet<>();
		while(curr != null){
			if(nodeList.contains(curr.val)){
				prev.next = curr.next;
			}else{
				nodeList.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}		
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
