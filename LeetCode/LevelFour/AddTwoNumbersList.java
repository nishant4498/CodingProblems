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
			int sum = carry; // Initilaize sum with the carry coming from the prevous result
			
			if (p != null) {
				sum += p.data;
				p = p.next;
			}
			
			if(q != null){
				sum += q.data;
				q = q.next;
			}
			
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
		}
		
		return dummyHead.next;
	}
}
