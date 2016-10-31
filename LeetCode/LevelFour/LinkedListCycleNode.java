package LevelFour;
/*
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
import LevelOne.ListNode;

public class LinkedListCycleNode {
	public ListNode detectCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if(slowPtr == fastPtr){
                break;
            }
        }
        
        if(fastPtr == null || fastPtr.next == null) return null;
        
        slowPtr = head;
        
        while(slowPtr != fastPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        
        return slowPtr;
    }
}
