package LevelTwo;

import LevelOne.ListNode;

/*
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {
	public boolean isPalindromeList(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		/*
		 * Slow points to the mid element so we need to move it one further.
		 */
		ListNode secondHead = slow.next;
		slow.next = null;
		
		/*
		 * Reverse the second list.
		 */
		ListNode revHead = reverseList(secondHead);
		
		ListNode p = revHead;
		ListNode q = head;
		/*
		 * Here p is assigned the second half of the linked list.So length of p will be equal to q in case 
		 * of even length lists and one less than q(first half) in case of odd length list.
		 * This is why checking p != null takes care of both odd/even lists. 
		 */
		while(p != null){
			if(p.data != q.data){
				return false;
			}
			
			p = p.next;
			q = q.next;
		}

		return true;
	}
	
	public ListNode reverseList(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode nextTemp = null;
		
		while(curr != null){
			nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		
		return prev;
	}
}
