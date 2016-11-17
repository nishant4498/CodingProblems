package LevelFour;

import LevelOne.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * The idea here is to split the list into three parts, 
 * 1) head to m-1 th node
 * 2) m to n
 * 3) n + 1 to end
 * 
 * This way we reverse the list from m to n. Then m -1th node points to the nth node and m th node points
 * to the n + 1th node. 
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m , int n){
		if(head == null || head.next == null || m == n) return head;
		
		ListNode prev = null;//Stores the m-1th node.
		
		ListNode first = new ListNode(0);//Points to mth node. 
		ListNode second = new ListNode(0);//Points to n+ 1 th node.
		
		int pos = 1;
		
		ListNode curr = head;
		
		while(curr != null){
			if(pos == m-1){
				prev = curr;
			}else if(pos == m){
				first.next = curr;
			}else if(pos == n){
				second.next = curr.next;
				curr.next = null;
			}
			curr = curr.next;
			pos++;
		}
		
		ListNode p1 = first.next;
		ListNode p2 = p1.next;
		p1.next = second.next;// This makes m point to n+1 node.
		
		while(p2 != null){
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;			
		}
		// p1 is the head of the reversed list. Thus p1 should be the next
		// pointed by m-1 the node(here denoted by prev)
		if(prev == null){
			return p1;
		}else{
			prev.next = p1;// This makes m-1 point to n + 1 th node.
		}
		
		return head;
	}
}
