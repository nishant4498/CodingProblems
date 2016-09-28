package LevelTwo;
/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
import LevelOne.ListNode;

public class MergeTwoSortedList {
	/*
	 * This uses a dummy node appended in the beginning.
	 */
	public ListNode mergeTwoSortedListDummy(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while(l1 != null && l2 != null){
			if(l1.data < l2.data){
				tail.next = l1;
				l1 = l1.next;
			}else{
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		
		if(l1 == null){
			tail.next = l2;
		}
		
		if(l2 == null){
			tail.next = l1;
		}
		
		return dummy.next;
	}
	
	public ListNode mergeTwoSortedListRecursion(ListNode l1, ListNode l2){
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		
		ListNode newHead;
		
		if(l1.data < l2.data){
			newHead = l1;
			newHead.next = mergeTwoSortedListRecursion(l1.next, l2);
		}else{
			newHead = l2;
			newHead.next = mergeTwoSortedListRecursion(l1, l2.next);
		}
		
		return newHead;	
	}
}
