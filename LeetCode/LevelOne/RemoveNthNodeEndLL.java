package LevelOne;

/*
 * We solve this question using a one pass & two pointer method.
 * Important point to note is that the first pointer(fast) should move n+1 steps so that the
 * gap bw second and first pointer is n. In this case when first pointer will reach the end,
 * the second pointer will be just before the nth node from end. 
 */
public class RemoveNthNodeEndLL {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		/**
		 * Creating a dummy node saves a lot of effort of handling the null
		 * conditions.
		 */
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode first = dummy;
		ListNode second = dummy;
		
		//Move the first pointer n+1 steps(starting from dummy node) so that the gap is of n nodes.
		
		for(int i =1; i<= n+1 ; i++){
			if (first == null) return null; 
			first = first.next;
		}
		
		while(first != null){
			first = first.next;
			second = second.next;
		}
		/*
		 * Dummy node helps here. In case we have just one node head, this
		 * condition will give null pointer exception since next.next will
		 * fails. This also fails in cases like [1,2,3] and n =3 since the first node deleted 
		 * is again head. Taking a dummy node makes all these problems simpler.
		 * 
		 * To try things just remove the dummy node logic at leetcode and see the issues.
		 */
		second.next = second.next.next;
		
		// This takes care of null conditions.In case there is only one node and
		// that has to be removed, this will return null
		return dummy.next;
	}
}
