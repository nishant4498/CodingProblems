package LevelTwo;

import LevelOne.ListNode;

public class MergeSortLinkedList {
	/* Driver program to test above functions */
	public static void main(String args[]) {
		LinkedList llist = new LinkedList();

		llist.push(15);
		llist.push(10);
		llist.push(5);
		llist.push(20);
		llist.push(3);
		llist.push(2);

		llist.head = llist.mergeSort(llist.head);
		llist.printList(llist.head);

		System.out.println();

		LinkedList llist1 = new LinkedList();
		llist1.push(3);
		llist1.push(2);
		llist1.push(4);
		llist1.head = llist1.mergeSort(llist1.head);
		llist1.printList(llist1.head);

	}
}

class LinkedList {

	ListNode head; // head of list

	ListNode mergeSort(ListNode head) {
		/* Base case -- length 0 or 1 */
		if (head == null || head.next == null) {
			return head;
		}
		// get middle node for Split head into 'a' and 'b' sublists
		ListNode mid = getMidNode(head);

		ListNode a = head;// firstList
		ListNode b = mid.next;// secondList
		mid.next = null;

		/* Recursively sort the sublists */
		mergeSort(a);
		mergeSort(b);

		/* answer = merge the two sorted lists together */
		head = MergeSortedList(a, b);

		return head;
	}

	/*
	 * In case of MergeSortedList we need the previous node before the middle
	 * node so that we can set the next to null;
	 */
	ListNode getMidNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return prev;
	}

	ListNode MergeSortedList(ListNode left, ListNode right) {
		ListNode result = null;
		/* Base cases */
		if (left == null)
			return right;
		else if (right == null)
			return (left);

		/* Pick either a or b, and recur */
		if (left.data <= right.data) {
			result = left;
			result.next = MergeSortedList(left.next, right);
		} else {
			result = right;
			result.next = MergeSortedList(left, right.next);
		}

		return result;
	}
	
	public ListNode MergeSortedListIteration(ListNode left, ListNode right) {
//		if (left == null) {
//			return right;
//		}
//
//		if (right == null) {
//			return left;
//		}
		ListNode mergeHead = new ListNode(0);
		ListNode tail = mergeHead;
		while (left != null && right != null) {
			if (left.data < right.data) {
				tail.next = left;
				left = left.next;
			} else {
				tail.next = right;
				right = right.next;
			}
			tail = tail.next;
		}

		if (left == null) {
			tail.next = right;
		}

		if (right == null) {
			tail.next = left;
		}

		return mergeHead.next;
	}
	

	public void push(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}

	void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}