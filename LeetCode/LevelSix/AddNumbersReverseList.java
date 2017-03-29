package LevelSix;

import java.util.Stack;

import LevelOne.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * Basically we use a stack here.
 * 1) We push elements of both the lists into two stacks.
 * 2) Add the top elements of stack.
 * 3) Append the result in the beginning of the list.
 */
public class AddNumbersReverseList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		ListNode temp = l1;

		while (temp != null) {
			s1.push(temp.data);
			temp = temp.next;
		}

		temp = l2;

		while (temp != null) {
			s2.push(temp.data);
			temp = temp.next;
		}

		int carry = 0;
		ListNode head = null;

		while (!s1.isEmpty() || !s2.isEmpty()) {
			int sum = 0;
			if (!s1.isEmpty()) {
				sum += s1.pop();
			}

			if (!s2.isEmpty()) {
				sum += s2.pop();
			}
			sum += carry;

			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;

			node.next = head;
			head = node;
		}

		if (carry > 0) {
			ListNode node = new ListNode(carry);
			node.next = head;
			head = node;
		}
		return head;
	}
}
