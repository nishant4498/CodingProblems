package LevelSix;

import LevelOne.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * 
 * Basically we keep three pointers,
 * 	- odd - starts with head
 *  - even - starts with head.next
 *  - evenHead - To join the odd list and the even list.
 * 
 * Thus in one iteration join all the odd nodes with the odd nodes and even nodes with even nodes.
 * 
 * And then join the odd list with even list.
 */
public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            
            odd = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        return head;
    }
}
