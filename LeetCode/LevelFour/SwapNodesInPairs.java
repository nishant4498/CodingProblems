package LevelFour;

import LevelOne.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * We take a dummyHead that acts as a prev node.We need to swap the node in pairs, so we need to keep track 
 * of the prev node which will point to the swapped node
 * In each loop we need three pointer changes:
 * 1) prev points to the curr's next.
 * 2) curr's next points to the curr
 * 3) curr points to the curr.next.next
 * 
 * Important points--- NOW THESE HAVE BEEN SIMPLIFIED SO NOT NEEDED: 
 * 1) We start with the dummynode as the curr node and then in the loop we set it to prev.
 * 2) Basically at the beginning of each pair swap, curr points to the previous node.
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode curr = head;
        ListNode prev = dummyHead;        
        
        while(curr != null && curr.next != null){            
            prev.next = curr.next;
            
            ListNode next = curr.next.next;
            curr.next.next = curr;
            curr.next = next;
            
            prev = curr;
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}
