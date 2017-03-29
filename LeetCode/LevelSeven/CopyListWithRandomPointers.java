package LevelSeven;
/**
 * https://leetcode.com/problems/copy-list-with-random-pointer
 * 
 * Given a linked list node which has an additional random pointer to some other node in the linked list,
 * which might be null as well, we need to create a deep copy of the list.
 * 
 * 1) One approach would be to create a HashMap where we store the Original List with random pointers.
 * 	  In one iteration we copy the list and in other we copy the random pointers.
 * 
 * 2) Here we will apply a constant space solution, in three steps :
 * 
 *    a) In first iteration we will create a copy of the ListNodes side by side in the original list.
 *    b) In second iteration, we copy the random pointers in the list.
 *    c) In third iteration, we detach the copied list from the original. 
 *
 */
public class CopyListWithRandomPointers {
	 public RandomListNode copyRandomList(RandomListNode head) {
		 RandomListNode orig = head;
		 
		 /**
		  * COPY NODES SIDE BY SIDE ORIGINAL LIST
		  */
		 while(orig != null){
			 RandomListNode next = orig.next;
			 
			 RandomListNode copy = new RandomListNode(orig.label);
			 orig.next = copy;
			 copy.next = next;
			 
			 orig = next;
		 }
		 
		 orig = head;
		 
		 /**
		  * Copy the random node pointers
		  */
		 while(orig != null){
			 if(orig.random != null){
				 /**
				  * Since nodes are copied side by side, the next node of the random node
				  * in the above list will be the random node for the copied list. 
				  */
				 
				 orig.next.random = orig.random.next;
			 }
			 
			 orig = orig.next.next;
		 }
		 
		 /**
		  * Separate the two lists.
		  */
		 RandomListNode dummyHead = new RandomListNode(0);
		 RandomListNode tail = dummyHead;
		 
		 orig = head;
		 
		 while(orig != null){
			 RandomListNode next = orig.next.next;
			 
			 tail.next = orig.next;
			 tail = tail.next;
			 
			 orig.next = next;
			 orig = next;
		 }
		 
		 return dummyHead.next;
	 }
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};
