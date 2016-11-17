package LevelFour;

import LevelOne.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * We take a dummyHead that acts as a prev node.We need to swp the node in pairs, so we need to keep track 
 * of the prev node which will point to the swapped node
 * In each loop we need three pointer changes:
 * 1) prev points to the curr's next.
 * 2) curr's next points to the curr
 * 3) curr points to the curr.next.next
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode curr = dummyHead;
        
        /**
         * Since we have taken curr as dummy we need to check conditions curr.next && curr.next.next
         * instead of just curr && curr.next.
         */
        while(curr.next != null && curr.next.next != null){
            ListNode prev = curr;
            curr = curr.next;
            prev.next = curr.next;
            
            ListNode next = curr.next.next;
            curr.next.next = curr;
            curr.next = next;
        }
        
        return dummyHead.next;
    }
}
