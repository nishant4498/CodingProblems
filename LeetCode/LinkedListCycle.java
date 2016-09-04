
public class LinkedListCycle {
	
	/*
	 * Take a slow pointer and a fast pointer and keep them moving one and two
	 * steps respectively. If they meet LL contains a cycle.
	 */
	public static boolean hasCycle(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr)
				return true;
		}

		return false;
	}
}
