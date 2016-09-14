/*
 * The idea is to move the bigger list by the diffrence in the length of two lists and then move 
 * them together one step.
 * 
 * Other approaches - Two Stacks, Hash Table, Two pointers(leet code);
 * 
 * https://leetcode.com/articles/intersection-two-linked-lists/
 */
public class IntersectionTwoLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = 0;

		int lengthB = 0;

		ListNode temp = headA;
		while (temp != null) {
			lengthA++;
			temp = temp.next;
		}

		temp = headB;
		while (temp != null) {
			lengthB++;
			temp = temp.next;
		}

		if (lengthA == 0 || lengthB == 0) {
			return null;
		}

		int diff = Math.abs(lengthA - lengthB);

		ListNode biggerList = headA;
		ListNode smallerList = headB;
		if (lengthA <= lengthB) {
			biggerList = headB;
			smallerList = headA;
		}

		for (int i = 0; i < diff; i++) {
			biggerList = biggerList.next;
		}

		while (biggerList.data != smallerList.data) {
			biggerList = biggerList.next;
			if (biggerList == null)
				return null;
			smallerList = smallerList.next;
		}

		return biggerList;
	}
}
