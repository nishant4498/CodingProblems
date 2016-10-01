package LevelTwo;
/*
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import LevelOne.ListNode;

@SuppressWarnings("unused")
public class MergeKSortedLists {
	public ListNode mergeKSortedLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		/*Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return o1.data - o2.data;
			}
		});*/
		
		/*
		 * Using lambda expressions.
		 */
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (o1,o2) -> o1.data - o2.data );
		
		for (ListNode list : lists) {
			if (list != null) {
				queue.offer(list);
			}
		}

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!queue.isEmpty()) {
			ListNode top = queue.poll();
			tail.next = top;
			tail = tail.next;
			if (top.next != null) {
				queue.add(top.next);
			}
		}

		return dummy.next;
	}
}
