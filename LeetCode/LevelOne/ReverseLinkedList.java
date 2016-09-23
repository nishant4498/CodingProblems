package LevelOne;
/*
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Both prev and nextTemp should be null initially.
 */
public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
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




