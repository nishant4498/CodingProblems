package LinkedList;
/*
 * 2.4 The idea is to partion two lists on the basis of a given number.The numbers less than x should
 * be on the left and greater than equal on the right.  
 */
public class PartitionList {
	/*
	 * This method is used when we dont care about preserving the order of
	 * elements in the new list same as original list.
	 */
	public ListNode partitionWithoutOrder(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode tail = head;        
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;// This is important to take the next node before.
            if(curr.data >= x){
                tail.next = curr;
                tail = curr;
            }else{
                curr.next = head;
                head = curr;
            }
            curr = next;
        }
        
        tail.next = null;
        return head;
    }
	
	public ListNode partitionWithOrder(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            if(curr.data < x){
                if(beforeStart == null){
                    beforeStart = curr;
                    beforeEnd = curr;
                }else{
                    beforeEnd.next = curr;
                    beforeEnd = curr;
                }
            }else{
                if(afterStart == null){
                    afterStart = curr;
                    afterEnd = curr;
                }else{
                    afterEnd.next = curr;
                    afterEnd = curr;
                }
            }
            curr = next;
        }
        if(beforeEnd != null) beforeEnd.next = null;
        
        if (afterEnd != null) afterEnd.next = null;
        if(beforeStart == null) return afterStart;
        
        
        
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
