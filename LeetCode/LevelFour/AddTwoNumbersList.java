package LevelFour;

import LevelOne.ListNode;

/*
 * https://leetcode.com/problems/add-two-numbers/
 * CTCI - Sum List 2.5
 */
public class AddTwoNumbersList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode(0);
		
		ListNode p = l1, q = l2, tail = dummyHead;
		int carry = 0;
		
		while(p != null || q != null){
			int sum = 0;
			
			if (p != null) {
				sum += p.data;
				p = p.next;
			}
			
			if(q != null){
				sum += q.data;
				q = q.next;
			}
			
			sum += carry;
			
			ListNode result = new ListNode(sum % 10);
			tail.next = result;
			tail = tail.next;
			carry = sum / 10;
		}
		/*
		 * Important condition to check the last carry.
		 */
		if(carry > 0){
			tail.next = new ListNode(1);
			tail = tail.next;
		}
		
		tail.next = null;
		return dummyHead.next;
	}
	
	public ListNode sumList(ListNode l1, ListNode l2, int carry){
		if(l1 == null && l2 == null && carry == 0) return null;
		
		ListNode result = new ListNode(0);
		int value = carry;
		
		if(l1 != null){
			value += l1.data;
		}
		
		if(l2 != null){
			value += l2.data;
		}
		
		result.data = value % 10;
		
		if(l1 != null || l2 != null ){
			ListNode next = sumList(l1 == null ? null : l1.next, 
									l2 == null ? null : l2.next, 
									value >= 10 ? 1 : 0);
			result.next = next;
		}
		
		return result;		
	}
}
